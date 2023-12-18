package com.uis.uis_logistic.model.entity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Timestamp;


@Entity
@Getter
@Setter
@Table(name = "MDO")
public class MDO {
    @Id
    @Column(name = "MDOID")
    private Integer mdoId;

    @Column(name = "Title")
    private String title;

    @Column(name = "Body")
    private String body;

    @Column(name = "MDRID")
    private Integer mdrId;

    @Column(name = "Status")
    private String status;

    @Column(name = "CreatedAt")
    private Timestamp createdAt;

    @Column(name = "CompanyID")
    private Integer companyId;
}
