package com.btl.iot.Repository;

import com.btl.iot.Entity.DeviceHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface DeviceRepository extends JpaRepository<DeviceHistory, String>, JpaSpecificationExecutor<DeviceHistory> {

}
