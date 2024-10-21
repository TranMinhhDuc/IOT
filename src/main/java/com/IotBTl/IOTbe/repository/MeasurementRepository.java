package com.IotBTl.IOTbe.repository;

import com.IotBTl.IOTbe.entity.MeasurementHistory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalTime;

@Repository
public interface MeasurementRepository extends JpaRepository<MeasurementHistory, String> {

    // Tìm kiếm theo ngày
    @Query(value = "SELECT * FROM measurement_history WHERE measurement_date >= :startDate AND measurement_date <= :endDate ORDER BY measurement_date DESC, measurement_time DESC", nativeQuery = true)
    Page<MeasurementHistory> findByDateRange(
            @Param("startDate") LocalDate startDate,
            @Param("endDate") LocalDate endDate,
            Pageable pageable
    );

    // Tìm kiếm theo ngày và giờ
    @Query(value = "SELECT * FROM measurement_history WHERE measurement_date >= :startDate AND measurement_date <= :endDate AND measurement_time >= :startTime AND measurement_time <= :endTime ORDER BY measurement_date DESC, measurement_time DESC", nativeQuery = true)
    Page<MeasurementHistory> findByDateTimeRange(
            @Param("startDate") LocalDate startDate,
            @Param("endDate") LocalDate endDate,
            @Param("startTime") LocalTime startTime,
            @Param("endTime") LocalTime endTime,
            Pageable pageable
    );
}
