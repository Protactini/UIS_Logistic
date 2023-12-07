package com.uis.uis_logistic.model;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;


@Entity
@Getter
@Setter
@Table(name = "Items")
public class MDR {
    @Id
    @Column(name = "MDRID")
    private Integer mdrId;

    private String title;
    private Integer building;
    private String status;
    private Boolean urgent;

    @Column(name = "CompanyID")
    private Integer companyId;

}
