package com.IotBTl.IOTbe.repository;

import com.IotBTl.IOTbe.entity.MeasurementHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;


@Repository
public interface MeasurementRepository extends JpaRepository<MeasurementHistory, String>, JpaSpecificationExecutor<MeasurementHistory> {

}