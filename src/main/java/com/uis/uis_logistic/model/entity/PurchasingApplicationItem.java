package com.uis.uis_logistic.model.entity;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;


@Entity
@Data
@Table(name = "purchasingapplicationitems")
public class PurchasingApplicationItem {
    @Id
    @Column(name = "OrderDetailsID")
    private Integer orderDetailsId;

    @Id
    @Column(name = "ItemID")
    private Integer itemId;

    @Column(name = "Quantity")
    private Integer quantity;
}
