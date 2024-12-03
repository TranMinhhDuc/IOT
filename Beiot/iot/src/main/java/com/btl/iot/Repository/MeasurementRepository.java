package com.btl.iot.Repository;

import com.btl.iot.Entity.MeasurementHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface MeasurementRepository extends JpaRepository<MeasurementHistory, String>, JpaSpecificationExecutor<MeasurementHistory> {

}
