package com.uis.uis_logistic.model;
import lombok.Data;

import java.sql.Timestamp;

import jakarta.persistence.*;


@Entity
@Data
@Table(name = "orders")
public class OrderEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer orderId;

    @Column(name = "OrderDate")
    private Timestamp orderDate;

    @Column(name = "CustomerID")
    private Integer customerId;
}
