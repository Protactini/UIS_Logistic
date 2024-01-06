package com.uis.uis_logistic.model;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "categories")
public class CategoryEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CategoryID")
    private Integer categoryId;

    @Column(name = "ParentCategoryID")
    private Integer parentCategoryId;

    @Column(name = "Name")
    private String name;

    @Column(name = "Description")
    private String description;
}
