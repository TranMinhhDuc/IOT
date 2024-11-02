package com.IotBTl.IOTbe.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import com.IotBTl.IOTbe.entity.ControlDevicesHistory;

@Repository
public interface DeviceRepository extends JpaRepository<ControlDevicesHistory, String>, JpaSpecificationExecutor<ControlDevicesHistory> {

}