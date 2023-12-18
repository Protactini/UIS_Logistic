package com.uis.uis_logistic.model.entity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "Categories")
public class Category {
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
