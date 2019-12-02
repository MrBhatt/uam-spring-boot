package com.dbune.uam.model;

import javax.persistence.Entity;
import lombok.Data;
import javax.persistence.Id;

@Data
@Entity
public class Privilege extends AbstractEntity {

    @Id
    private String name;
}