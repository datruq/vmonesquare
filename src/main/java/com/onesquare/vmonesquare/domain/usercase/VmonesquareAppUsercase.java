package com.onesquare.vmonesquare.domain.usercase;

import com.onesquare.vmonesquare.domain.entity.VendorMachineEntity;
import com.onesquare.vmonesquare.domain.entity.VendorMachineResponseEntity;

public class VmonesquareAppUsercase {

    public static final int ERROR_CODE_FAIL = -1;

    public VendorMachineResponseEntity getItemFromVendorMachine(VendorMachineEntity vendorMachineEntity){
        VendorMachineResponseEntity vendorMachineResponseEntity = new VendorMachineResponseEntity();
        vendorMachineResponseEntity.getValidateMoney(vendorMachineEntity);
        if(vendorMachineResponseEntity.getResponseCode() == ERROR_CODE_FAIL){
            return vendorMachineResponseEntity;
        }
        vendorMachineResponseEntity.getProductFromVendorMachine(vendorMachineEntity);
        if(vendorMachineResponseEntity.getResponseCode() == ERROR_CODE_FAIL){
            return vendorMachineResponseEntity;
        }
        return vendorMachineResponseEntity;
    }


}
