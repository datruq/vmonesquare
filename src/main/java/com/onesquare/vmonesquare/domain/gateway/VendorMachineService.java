package com.onesquare.vmonesquare.domain.gateway;

import com.onesquare.vmonesquare.DB.dto.VendorMachineDB;
import org.springframework.data.repository.CrudRepository;

public interface VendorMachineService extends CrudRepository<VendorMachineDB, Integer> {
}
