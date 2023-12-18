package com.uis.uis_logistic.model.entity;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;


@Entity
@Getter
@Setter
@Table(name = "Items")
public class PurchasingApplication {
    @Id
    @Column(name = "OrderDetailsID")
    private Integer orderDetailsId;

    @Id
    @Column(name = "ItemID")
    private Integer itemId;

    @Column(name = "Quantity")
    private Integer quantity;
}
