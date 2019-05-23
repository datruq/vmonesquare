package com.onesquare.vmonesquare.web.app;

import com.onesquare.vmonesquare.domain.entity.VendorMachineEntity;
import com.onesquare.vmonesquare.domain.entity.VendorMachineResponseEntity;
import com.onesquare.vmonesquare.domain.usercase.VmonesquareAppUsercase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("vm/")
public class VmonesquareAppController {

    @Autowired
    VmonesquareAppUsercase vmonesquareAppUsercase;

    @RequestMapping(value = { "postVendorMachine" }, method = RequestMethod.POST,
            produces = "application/json", consumes = "application/json")
    @ResponseBody
    public VendorMachineResponseEntity postVendorMachine(@RequestBody VendorMachineEntity vendorMachineEntity) {
        return vmonesquareAppUsercase.getItemFromVendorMachine(vendorMachineEntity);
    }
}
