package com.uis.uis_logistic.model;
import lombok.Data;

import jakarta.persistence.*;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;


@Entity
@Data
@Table(name = "users")
public class UserEntity {

    @Id @GeneratedValue
    private Integer id;

    private String username;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "user_roles", joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "role_id", referencedColumnName = "id"))
    private List<RoleEntity> roles = new ArrayList<>();

    @Column(name = "CompanyID")
    private Integer companyId;

    @Column(name = "Created_at")
    private Timestamp createdAt;

    @Column(name = "password")
    private String password;

    // Getters and Setters
}