package com.uis.uis_logistic.model.entity;
import lombok.Getter;
import lombok.Setter;
import java.sql.Timestamp;

import javax.persistence.*;


@Entity
@Getter
@Setter
@Table(name = "Items")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer orderId;

    @Column(name = "OrderDate")
    private Timestamp orderDate;

    @Column(name = "CustomerID")
    private Integer customerId;
}
