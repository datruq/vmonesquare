package com.onesquare.vmonesquare.domain.entity;

import lombok.Getter;
import lombok.Setter;

import java.util.Map;

@Getter
public class VendorMachineEntity {

    @Setter
    public Map<String, Double> money;

    @Setter
    public double cents;

    @Setter
    public double bills;

    @Setter
    public VMItem vmItem;

    @Getter
    public class VMItem{
        @Setter
        public String name;
        @Setter
        public String code;
        @Setter
        public String cost;

    }


}
