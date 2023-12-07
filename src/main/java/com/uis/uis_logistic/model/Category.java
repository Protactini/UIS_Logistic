package com.uis.uis_logistic.model;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "Categories")
public class Category {
    @Id
    @Column(name = "CategoryID")
    private Integer categoryId;

    @Column(name = "ParentCategoryID")
    private Integer parentCategoryId;

    private String name;
    private String description;
}
