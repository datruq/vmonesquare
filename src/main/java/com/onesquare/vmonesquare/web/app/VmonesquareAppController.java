package com.onesquare.vmonesquare.web.app;

import com.onesquare.vmonesquare.domain.entity.VendorMachineEntity;
import com.onesquare.vmonesquare.domain.usercase.VmonesquareAppUsercase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("VM/")
public class VmonesquareAppController {

    @Autowired
    VmonesquareAppUsercase vmonesquareAppUsercase;

    @GetMapping("getItem")
    public VendorMachineEntity getWatherReport(){
        List<VendorMachineEntity> vendorMachineEntityList = new ArrayList<>();
        return vmonesquareAppUsercase.getItemFromVendorMachine();
    }
}
