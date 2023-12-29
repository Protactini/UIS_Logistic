package com.uis.uis_logistic.model.entity;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import java.sql.Timestamp;

import javax.persistence.*;


@Entity
@Data
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer orderId;

    @Column(name = "OrderDate")
    private Timestamp orderDate;

    @Column(name = "CustomerID")
    private Integer customerId;
}
