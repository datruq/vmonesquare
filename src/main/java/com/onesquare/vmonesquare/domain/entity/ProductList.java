package com.onesquare.vmonesquare.domain.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductList {
    private String productCode;
    private String productName;
    private double productPrice;

    public void ProductList(){
        this.productCode = "L5";
        this.productName = "nuts";
        this.productPrice = 0.50;
    }
}
