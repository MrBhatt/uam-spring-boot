package com.dbune.uam.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import lombok.Data;
import java.util.Collection;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Data
@Entity
public class Role extends AbstractEntity {

    @Id
    private String name;

    @ManyToMany(mappedBy = "roles", fetch = FetchType.LAZY)
    @JsonBackReference
    private Collection<User> users;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "roles_privileges", joinColumns = @JoinColumn(name = "role_name", referencedColumnName = "name"), inverseJoinColumns = @JoinColumn(name = "privilege_name", referencedColumnName = "name"))
    @JsonManagedReference
    private Collection<Privilege> privileges;
}