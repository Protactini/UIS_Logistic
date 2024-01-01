package com.uis.uis_logistic.model.entity;
import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;
@Entity
@Data
@Table(name = "items")
public class ItemEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ItemID")
    private Integer itemId;

    @Column(name = "Name")
    private String name;

    @Column(name = "Description")
    private String description;

    @Column(name = "Price")
    private BigDecimal price;

    @Column(name = "Quantity")
    private Integer quantity;

    @Column(name = "CategoryID")
    private Integer categoryId;
}
