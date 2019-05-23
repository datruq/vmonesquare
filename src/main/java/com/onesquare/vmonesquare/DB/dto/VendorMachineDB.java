package com.onesquare.vmonesquare.DB.dto;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Getter
@Setter
public class VendorMachineDB {
    @Id
    @GeneratedValue
    private int id;
    private String code;
    private String name;
    private double price;
    private double currentAmount;

}

