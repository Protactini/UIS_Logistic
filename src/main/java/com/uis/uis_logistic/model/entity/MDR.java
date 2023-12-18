package com.uis.uis_logistic.model.entity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;


@Entity
@Getter
@Setter
@Table(name = "Items")
public class MDR {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer mdrId;

    @Column(name = "Title")
    private String title;

    @Column(name = "Building")
    private Integer building;

    @Column(name = "Status")
    private String status;

    @Column(name = "Urgent")
    private Boolean urgent;

    @Column(name = "CompanyID")
    private Integer companyId;

}
