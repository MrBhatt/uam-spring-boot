
package com.dbune.uam.model;

import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;

@Data
@Entity
public class User extends AbstractEntity {

    @Id
    @Column(nullable = false)
    private String username;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String firstName;

    @Column(nullable = false)
    private String lastName;

    @Column(nullable = false, columnDefinition = "TINYINT(1)")
    private boolean enabled;

    @Column(nullable = false, columnDefinition = "TINYINT(1)")
    private boolean accountNonExpired;

    @Column(nullable = false, columnDefinition = "TINYINT(1)")
    private boolean accountNonLocked;

    @Column(nullable = false, columnDefinition = "TINYINT(1)")
    private boolean credentialsNonExpired;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "users_roles", joinColumns = @JoinColumn(name = "user_username", referencedColumnName = "username"), inverseJoinColumns = @JoinColumn(name = "role_name", referencedColumnName = "name"))
    @JsonManagedReference
    private Collection<Role> roles;
}
