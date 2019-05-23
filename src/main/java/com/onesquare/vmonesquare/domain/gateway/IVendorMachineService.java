package com.onesquare.vmonesquare.domain.gateway;

import com.onesquare.vmonesquare.DB.dto.VendorMachineDB;
import com.onesquare.vmonesquare.domain.entity.VendorMachineEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface IVendorMachineService {
    List<VendorMachineEntity> getAllPersons();
    VendorMachineDB getPersonById(int id);
    void saveOrUpdate(VendorMachineEntity vendorMachineEntity);
    void delete(int id);
}
