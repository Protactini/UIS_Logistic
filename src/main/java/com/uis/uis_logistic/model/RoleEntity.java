package com.uis.uis_logistic.model;

import lombok.Data;

import jakarta.persistence.*;

@Entity
@Data
@Table(name = "roles")
public class RoleEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

}
