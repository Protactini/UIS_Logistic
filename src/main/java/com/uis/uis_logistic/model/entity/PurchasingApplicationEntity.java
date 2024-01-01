package com.uis.uis_logistic.model.entity;
import lombok.Data;

import javax.persistence.*;


@Entity
@Data
@Table(name = "purchasingapplication")
public class PurchasingApplicationEntity {
    @Id
    @Column(name = "OrderDetailsID")
    private Integer orderDetailsId;

    @Id
    @Column(name = "ItemID")
    private Integer itemId;

    @Column(name = "Quantity")
    private Integer quantity;
}
