package com.onesquare.vmonesquare.DB;

import com.onesquare.vmonesquare.DB.dto.VendorMachineDB;
import com.onesquare.vmonesquare.domain.entity.VendorMachineEntity;
import com.onesquare.vmonesquare.domain.gateway.IVendorMachineService;
import com.onesquare.vmonesquare.domain.gateway.VendorMachineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class VendorMachineServiceImpl implements IVendorMachineService {

    @Autowired
    VendorMachineService vendorMachineService;

    private VendorMachineDB vendorMachineDB;
    private VendorMachineEntity vendorMachineEntity;
    private VendorMachineEntity.VMItem vmItem;

    @Override
    public List<VendorMachineEntity> getAllPersons() {
        List<VendorMachineDB> vendorMachineDBList = new ArrayList<>();
        List<VendorMachineEntity> vendorMachineEntityList = new ArrayList<>();
        vendorMachineService.findAll().forEach(vendorMachineDB -> vendorMachineDBList.add(vendorMachineDB));
        vendorMachineEntityList = vendorMachineDBList.stream().
                map(this::transformVendorMachineDBToVendorMachineEntity).collect(Collectors.toList());
        return vendorMachineEntityList;
    }
    @Override
    public VendorMachineDB getPersonById(int id) {
        return vendorMachineService.findById(id).get();
    }

    @Override
    public void saveOrUpdate(VendorMachineEntity vendorMachineEntity) {
        vendorMachineService.save(vendorMachineDB);
    }

    @Override
    public void delete(int id) {
        vendorMachineService.deleteById(id);
    }

    private VendorMachineDB transformVendorMachineEntityToVendorMachineDB(VendorMachineEntity vendorMachineEntity){
        vendorMachineDB = new VendorMachineDB();
        vendorMachineDB.setCode(vendorMachineEntity.getVmItem().getCode());
        vendorMachineDB.setName(vendorMachineEntity.getVmItem().getName());
        vendorMachineDB.setPrice(vendorMachineEntity.getVmItem().getPrice());
        return vendorMachineDB;
    }

    private VendorMachineEntity transformVendorMachineDBToVendorMachineEntity(VendorMachineDB vendorMachineDB){
        vendorMachineEntity = new VendorMachineEntity();
        vmItem = new VendorMachineEntity().new VMItem();
        vmItem.setName(vendorMachineDB.getName());
        vmItem.setCode(vendorMachineDB.getCode());
        vmItem.setPrice(vendorMachineDB.getPrice());
        vendorMachineEntity.setVmItem(vmItem);
        return vendorMachineEntity;
    }
}
