package com.onesquare.vmonesquare.domain.usercase;

import com.onesquare.vmonesquare.domain.entity.VendorMachineEntity;
import com.onesquare.vmonesquare.domain.entity.VendorMachineResponseEntity;
import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;

public class VmonesquareAppUsercaseTest {

    private static final int ONE_BILLS = 1;
    private static final int FIFTY_CENTS = 50;
    private static final String L5_CODE = "L5";
    private static final double COST = 5.50;
    private static final String NAME = "nuts";
    private static final int ERROR_RESPONSE_FAIL = -1;
    private static final int ERROR_RESPONSE_OK = 0;

    private VmonesquareAppUsercase vmonesquareAppUsercase;
    private VendorMachineResponseEntity vendorMachineResponseEntity;
    private VendorMachineEntity vendorMachineEntity;
    private VendorMachineEntity.VMItem vmItem;

    @Before
    public void setup() {
        vmonesquareAppUsercase = new VmonesquareAppUsercase();
    }

    @Test
    public void pureba(){
        setVendorMachineEntity(ONE_BILLS, FIFTY_CENTS, L5_CODE);
        vmonesquareAppUsercase.getItemFromVendorMachine(vendorMachineEntity);
        Assertions.assertThat(vendorMachineResponseEntity.getResponseCode()).isEqualTo(ERROR_RESPONSE_OK);
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
