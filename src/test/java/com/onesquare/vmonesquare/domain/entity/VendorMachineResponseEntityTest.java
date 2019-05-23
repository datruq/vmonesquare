package com.onesquare.vmonesquare.domain.entity;

import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;

public class VendorMachineResponseEntityTest {

    private static final int ONE_BILLS = 1;
    private static final int FIFTY_CENTS = 50;
    private static final String L5_CODE = "L5";
    private static final double COST = 5.50;
    private static final String NAME = "nuts";
    private static final int ERROR_RESPONSE_FAIL = -1;
    private static final int ERROR_RESPONSE_OK = 0;
    private static final int THREE_BILLS = 3;
    public static final int SISTY_CENTS = 60;
    public static final String P4_CODE = "P4";
    private VendorMachineResponseEntity vendorMachineResponseEntity;
    private VendorMachineEntity vendorMachineEntity;
    private VendorMachineEntity.VMItem vmItem;

    @Before
    public void setup() {
        vendorMachineResponseEntity = new VendorMachineResponseEntity();
    }

    @Test
    public void getValidateMoneyItIsOkTest(){
        setVendorMachineEntity(ONE_BILLS, FIFTY_CENTS, L5_CODE);
        vendorMachineResponseEntity.getValidateMoney(vendorMachineEntity);
        Assertions.assertThat(vendorMachineResponseEntity.getResponseCode()).isEqualTo(ERROR_RESPONSE_OK);
    }

    @Test
    public void getValidateMoneyWithDiferentCentsFailTest(){
        setVendorMachineEntity(ONE_BILLS, SISTY_CENTS, L5_CODE);
        vendorMachineResponseEntity.getValidateMoney(vendorMachineEntity);
        Assertions.assertThat(vendorMachineResponseEntity.getResponseCode()).isEqualTo(ERROR_RESPONSE_FAIL);
    }

    @Test
    public void getValidateMoneyWithDiferentBillsFailTest(){
        setVendorMachineEntity(THREE_BILLS,FIFTY_CENTS, L5_CODE);
        vendorMachineResponseEntity.getValidateMoney(vendorMachineEntity);
        Assertions.assertThat(vendorMachineResponseEntity.getResponseCode()).isEqualTo(ERROR_RESPONSE_FAIL);
    }

    @Test
    public void getValidateMoneyWithDiferentProductFailTest(){
        setVendorMachineEntity(ONE_BILLS,FIFTY_CENTS, P4_CODE);
        vendorMachineResponseEntity.getValidateMoney(vendorMachineEntity);
        Assertions.assertThat(vendorMachineResponseEntity.getResponseCode()).isEqualTo(ERROR_RESPONSE_FAIL);
    }

    private void setVendorMachineEntity(int bills, int cents, String code){
        vendorMachineEntity = new VendorMachineEntity();
        vmItem = new VendorMachineEntity().new VMItem();
        vendorMachineEntity.setBills(bills);
        vendorMachineEntity.setCents(cents);
        vmItem.setCode(code);
        vmItem.setPrice(COST);
        vmItem.setName(NAME);
        vendorMachineEntity.setVmItem(vmItem);
    }
}
