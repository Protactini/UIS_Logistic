package com.uis.uis_logistic.model;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;


@Entity
@Getter
@Setter
@Table(name = "MDO")
public class MDO {
    @Id
    @Column(name = "OrderDetailsID")
    private Integer orderDetailsId;

    @Column(name = "OrderID")
    private Integer orderId;

    @Column(name = "User_ID")
    private Integer userId;
}
