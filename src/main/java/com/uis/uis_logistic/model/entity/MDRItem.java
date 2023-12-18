package com.uis.uis_logistic.model.entity;
import com.uis.uis_logistic.model.IDs.MDRItemId;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;


@Entity
@Getter
@Setter
@IdClass(MDRItemId.class)
public class MDRItem {

    @Id
    @Column(name = "MDRID")
    private Integer mdrId;

    @Id
    @Column(name = "ItemID")
    private Integer itemId;
}
