package com.onesquare.vmonesquare.domain.entity;

import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;

public class VendorMachineResponseEntityTest {

    private static final double ONE_BILLS = 1.0;
    private static final double FIFTY_CENTS = 0.50;
    private static final String L5_CODE = "L5";
    private static final double COST = 5.50;
    private static final String NAME = "nuts";
    private static final int ERROR_RESPONSE_FAIL = -1;
    private static final int ERROR_RESPONSE_OK = 0;
    private static final double THREE_BILLS = 3.0;
    private static final double TWO_BILLS = 2.0;
    private static final double SISTY_CENTS = 0.60;
    private static final String P4_CODE = "P4";
    private static final double TOTAL_AMOUNT = 5.50;
    private static final double TOTAL_AMOUNT_NOT_ENOUGH = 1.0;
    private static final double TOTAL_AMOUNT_EXACT = 2.50;
    private VendorMachineResponseEntity vendorMachineResponseEntity;
    private VendorMachineEntity vendorMachineEntity;
    private VendorMachineEntity.VMItem vmItem;

    @Before
    public void setup() {
        vendorMachineResponseEntity = new VendorMachineResponseEntity();
    }

    @Test
    public void getValidateMoneyItIsOkTest(){
        setVendorMachineEntity(ONE_BILLS, FIFTY_CENTS, TOTAL_AMOUNT, L5_CODE);
        vendorMachineResponseEntity.getValidateMoney(vendorMachineEntity);
        Assertions.assertThat(vendorMachineResponseEntity.getResponseCode()).isEqualTo(ERROR_RESPONSE_OK);
    }

    @Test
    public void getValidateMoneyWithDiferentCentsFailTest(){
        setVendorMachineEntity(ONE_BILLS, SISTY_CENTS, TOTAL_AMOUNT, L5_CODE);
        vendorMachineResponseEntity.getValidateMoney(vendorMachineEntity);
        Assertions.assertThat(vendorMachineResponseEntity.getResponseCode()).isEqualTo(ERROR_RESPONSE_FAIL);
    }

    @Test
    public void getValidateMoneyWithDiferentBillsFailTest(){
        setVendorMachineEntity(THREE_BILLS,FIFTY_CENTS, TOTAL_AMOUNT, L5_CODE);
        vendorMachineResponseEntity.getValidateMoney(vendorMachineEntity);
        Assertions.assertThat(vendorMachineResponseEntity.getResponseCode()).isEqualTo(ERROR_RESPONSE_FAIL);
    }

    @Test
    public void getValidateMoneyWithDiferentProductFailTest(){
        setVendorMachineEntity(ONE_BILLS,FIFTY_CENTS, TOTAL_AMOUNT, P4_CODE);
        vendorMachineResponseEntity.getValidateMoney(vendorMachineEntity);
        Assertions.assertThat(vendorMachineResponseEntity.getResponseCode()).isEqualTo(ERROR_RESPONSE_FAIL);
    }

    @Test
    public void getProductFromVendorMachineExactMoneyTobuyTest(){
        setVendorMachineEntity(TWO_BILLS, FIFTY_CENTS, TOTAL_AMOUNT_EXACT, L5_CODE);
        vendorMachineResponseEntity.getProductFromVendorMachine(vendorMachineEntity);
        Assertions.assertThat(vendorMachineResponseEntity.getResponseCode()).isEqualTo(ERROR_RESPONSE_OK);
    }

    @Test
    public void getProductFromVendorMachineEnoughMoneyTobuyTest(){
        setVendorMachineEntity(TWO_BILLS, FIFTY_CENTS, TOTAL_AMOUNT, L5_CODE);
        vendorMachineResponseEntity.getProductFromVendorMachine(vendorMachineEntity);
        Assertions.assertThat(vendorMachineResponseEntity.getResponseCode()).isEqualTo(ERROR_RESPONSE_OK);
    }

    @Test
    public void getProductFromVendorMachineNotEnoughMoneyTest(){
        setVendorMachineEntity(ONE_BILLS, FIFTY_CENTS, TOTAL_AMOUNT_NOT_ENOUGH, L5_CODE);
        vendorMachineResponseEntity.getProductFromVendorMachine(vendorMachineEntity);
        Assertions.assertThat(vendorMachineResponseEntity.getResponseCode()).isEqualTo(ERROR_RESPONSE_FAIL);
    }

    private void setVendorMachineEntity(double bills, double cents, double totalAmount, String code){
        vendorMachineEntity = new VendorMachineEntity();
        vmItem = new VendorMachineEntity().new VMItem();
        vendorMachineEntity.setBills(bills);
        vendorMachineEntity.setCents(cents);
        vendorMachineEntity.setTotalAmount(totalAmount);
        vmItem.setCode(code);
        vmItem.setPrice(COST);
        vmItem.setName(NAME);
        vendorMachineEntity.setVmItem(vmItem);
    }
}
