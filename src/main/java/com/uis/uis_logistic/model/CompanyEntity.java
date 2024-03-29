package com.uis.uis_logistic.model;
import lombok.Data;

import jakarta.persistence.*;

@Entity
@Data
@Table(name = "companies")
public class CompanyEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "companyname")
    private String companyName;

}
