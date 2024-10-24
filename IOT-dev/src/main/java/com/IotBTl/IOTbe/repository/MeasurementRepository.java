package com.IotBTl.IOTbe.repository;

import com.IotBTl.IOTbe.entity.ControlDevicesHistory;
import com.IotBTl.IOTbe.entity.MeasurementHistory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalTime;

@Repository
public interface MeasurementRepository extends JpaRepository<MeasurementHistory, String>, JpaSpecificationExecutor<MeasurementHistory> {

}