package com.IotBTl.IOTbe.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.IotBTl.IOTbe.entity.ControlDevicesHistory;

import java.time.LocalDate;
import java.time.LocalTime;

@Repository
public interface DeviceRepository extends JpaRepository<ControlDevicesHistory, String>{

    @Query(value = "SELECT * FROM control_devices_history " +
            "ORDER BY action_date DESC, action_time DESC", nativeQuery = true)
    Page<ControlDevicesHistory> findDeviceHistory(Pageable pageable);

    @Query(value = "SELECT * FROM control_devices_history " +
            "WHERE device_name LIKE %:deviceName% " +
            "ORDER BY action_date DESC, action_time DESC", nativeQuery = true)
    Page<ControlDevicesHistory> findDeviceHistoryByName(@Param("deviceName") String deviceName, Pageable pageable);

    @Query(value = "SELECT * FROM control_devices_history " +
            "WHERE action_date >= :firstDate " +
            "AND action_date <= :lastDate " +
            "ORDER BY action_date DESC, action_time DESC", nativeQuery = true)
    Page<ControlDevicesHistory> findDeviceHistoryByDate(
            @Param("firstDate") LocalDate firstDate,
            @Param("lastDate") LocalDate lastDate,
            Pageable pageable
    );

    @Query(value = "SELECT * FROM control_devices_history " +
            "WHERE device_name = :deviceName " +
            "AND action_date >= :firstDate " +
            "AND action_date <= :lastDate " +
            "ORDER BY action_date DESC, action_time DESC", nativeQuery = true)
    Page<ControlDevicesHistory> findDeviceHistoryByNameAndDate(
            @Param("deviceName") String deviceName,
            @Param("firstDate") LocalDate firstDate,
            @Param("lastDate") LocalDate lastDate,
            Pageable pageable
    );

    @Query(value = "SELECT * FROM control_devices_history" +
            "WHERE action_date >= :firstDate" +
            "AND action_date <= :lastDate" +
            "AND action_time >= :begin" +
            "AND action_time <= :end" +
            "ORDER BY action_date DESC, action_time DESC", nativeQuery = true)
    Page<ControlDevicesHistory> findDeviceHistoryByDateAndTime(
            @Param("firstDate") LocalDate firstDate,
            @Param("lastDate") LocalDate lastDate,
            @Param("begin") LocalTime begin,
            @Param("end") LocalTime end,
            Pageable pageable
    );

    @Query(value = "SELECT * FROM control_devices_history " +
            "WHERE device_name = :deviceName " +
            "AND action_date >= :firstDate  + " +
            "AND action_date <= :lastDate " +
            "AND action_time >= :begin" +
            "AND action_time <= :end", nativeQuery = true )
    Page<ControlDevicesHistory> findDevicesByAll(
            @Param("deviceName") String deviceName,
            @Param("firstDate") LocalDate firstDate,
            @Param("lastDate") LocalDate lastDate,
            @Param("begin") LocalTime begin,
            @Param("end") LocalTime end,
            Pageable pageable
    );

}
