package com.uis.uis_logistic.model.entity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Timestamp;


@Entity
@Getter
@Setter
@Table(name = "Users")
public class User {

    @Id @GeneratedValue
    private Integer id;

    private String username;
    private String role;

    @Column(name = "CompanyID")
    private Integer companyId;

    @Column(name = "Created_at")
    private Timestamp createdAt;

    // Getters and Setters
}