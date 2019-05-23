package com.onesquare.vmonesquare.domain.usercase;

import com.onesquare.vmonesquare.DB.VendorMachineServiceImpl;
import com.onesquare.vmonesquare.domain.entity.VendorMachineEntity;
import com.onesquare.vmonesquare.domain.entity.VendorMachineResponseEntity;
import org.springframework.beans.factory.annotation.Autowired;

public class VmonesquareAppUsercase {

    @Autowired
    VendorMachineServiceImpl vendorMachineService;

    public static final int ERROR_CODE_FAIL = -1;

    public VendorMachineResponseEntity getItemFromVendorMachine(VendorMachineEntity vendorMachineEntity){
        VendorMachineResponseEntity vendorMachineResponseEntity = new VendorMachineResponseEntity();
        vendorMachineResponseEntity.getValidateMoney(vendorMachineEntity);
        if(vendorMachineResponseEntity.getResponseCode() == ERROR_CODE_FAIL){
            return vendorMachineResponseEntity;
        }
        vendorMachineService.saveOrUpdate(vendorMachineEntity);
        return vendorMachineResponseEntity;
    }


}
