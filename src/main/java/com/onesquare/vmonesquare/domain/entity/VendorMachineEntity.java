package com.onesquare.vmonesquare.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Map;

@Getter
public class VendorMachineEntity {

    @Setter
    public double cents;

    @Setter
    public double bills;

    @Setter
    public double totalAmount;

    @Setter
    public VMItem vmItem;

    @Getter
    public class VMItem{
        @Setter
        public String name;
        @Setter
        public String code;
        @Setter
        public double price;

    }


}
