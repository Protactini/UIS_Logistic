package com.uis.uis_logistic.model;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "Companies")
public class Company {

    @Id
    private Integer id;

    @Column(name = "companyname")
    private String companyName;

}
