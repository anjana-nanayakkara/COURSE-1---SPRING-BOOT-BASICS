package com.springBasic.Course1.dto.responce;

import com.springBasic.Course1.entity.enums.MeasuringUnitType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@AllArgsConstructor
@NoArgsConstructor
@Data
public class ItemGetResponceDTO {


    private int itemId;

    private String itemName;

    private double balanceQty;

    private double supplierPrice;

    private double sellingPrice;

    private boolean activeState;
}



