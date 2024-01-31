package com.uis.uis_logistic.model;
import lombok.Data;

import jakarta.persistence.*;
import java.sql.Timestamp;


@Entity
@Data
@Table(name = "mdo")
public class MDOEntity {
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
