package com.uis.uis_logistic.model;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
@Entity
@Getter
@Setter
@Table(name = "Items")
public class Item {
    @Id
    @Column(name = "ItemID")
    private Integer itemId;

    private String name;
    private String description;

    private BigDecimal price;
    private Integer quantity;

    @Column(name = "CategoryID")
    private Integer categoryId;
}
