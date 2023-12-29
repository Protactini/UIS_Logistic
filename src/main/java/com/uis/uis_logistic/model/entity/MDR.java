package com.uis.uis_logistic.model.entity;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;


@Entity
@Data
@Table(name = "mdr")
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

    @ManyToMany
    @JoinTable(
            name = "MDRItem",
            joinColumns = @JoinColumn(name = "MDRID"),
            inverseJoinColumns = @JoinColumn(name = "ItemID")
    )
    private List<Item> items;

}
