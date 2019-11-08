package com.dbune.uam.model;

import javax.persistence.MappedSuperclass;

import lombok.Data;

@MappedSuperclass
@Data
public class AbstractEntity {
    final static Long serialVersionUID = 1L;
}
