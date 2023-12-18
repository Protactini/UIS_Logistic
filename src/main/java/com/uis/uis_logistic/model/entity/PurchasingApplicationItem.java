package com.uis.uis_logistic.model.entity;
import com.uis.uis_logistic.model.IDs.PurchasingApplicationItemId;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;


@Entity
@Getter
@Setter
@Table(name = "PurchasingApplicationItems")
@IdClass(PurchasingApplicationItemId.class)
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
