package com.onesquare.vmonesquare.web.app;

import com.onesquare.vmonesquare.domain.entity.VendorMachineEntity;
import com.onesquare.vmonesquare.domain.usercase.VmonesquareAppUsercase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("vm/")
public class VmonesquareAppController {

    @Autowired
    VmonesquareAppUsercase vmonesquareAppUsercase;

    @GetMapping("getItem/")
    public VendorMachineEntity getWatherReport(){
        List<VendorMachineEntity> vendorMachineEntityList = new ArrayList<>();
        return vmonesquareAppUsercase.getItemFromVendorMachine();
    }

    @RequestMapping(value = { "postItem" }, method = RequestMethod.POST, produces = "application/json", consumes = "application/json")
    @ResponseBody
    public VendorMachineEntity postItem( @RequestBody VendorMachineEntity pojo) {
        VendorMachineEntity vm = new VendorMachineEntity();
        vm.cents = pojo.cents;
        return vmonesquareAppUsercase.getItemFromVendorMachine();
    }
}
