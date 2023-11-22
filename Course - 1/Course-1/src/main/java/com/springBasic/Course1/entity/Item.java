package com.springBasic.Course1.entity;

import com.springBasic.Course1.entity.enums.MeasuringUnitType;
import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "item")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Item {
    @Id
    @Column(name="item_id",length = 45)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int itemId;

    @Column(name = "item_name",nullable = false,length = 100)
    private String itemName;

    @Enumerated(EnumType.STRING)
    @Column(name="measure_type",length = 255)
    private MeasuringUnitType measuringUnitType;

    @Column(name = "balance_qty",nullable = false,length = 100)
    private double balanceQty;

    @Column(name = "supplier_price",nullable = false,length = 100)
    private double supplierPrice;

    @Column(name = "selling_price",nullable = false,length = 100)
    private double sellingPrice;

    @Column(name="active_state",columnDefinition = "TINYINT default 1")
    private boolean activeState;
}
