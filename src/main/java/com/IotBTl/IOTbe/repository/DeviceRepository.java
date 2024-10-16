package com.IotBTl.IOTbe.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.IotBTl.IOTbe.entity.ControllDevicesHistory;

@Repository
public interface DeviceRepository extends JpaRepository<ControllDevicesHistory, String>{

    Page<ControllDevicesHistory> findAllByOrderByActionDateDescActionTimeDesc(Pageable pageable);
}
