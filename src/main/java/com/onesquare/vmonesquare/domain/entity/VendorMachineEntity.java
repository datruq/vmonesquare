package com.onesquare.vmonesquare.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Map;

@Getter
public class VendorMachineEntity {

    @Setter
    public int cents;

    @Setter
    public int bills;

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
