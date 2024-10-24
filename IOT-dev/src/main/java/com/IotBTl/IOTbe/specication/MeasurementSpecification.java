package com.IotBTl.IOTbe.specication;

import com.IotBTl.IOTbe.entity.MeasurementHistory;
import org.springframework.data.jpa.domain.Specification;

import java.time.LocalDate;
import java.time.LocalTime;

public class MeasurementSpecification {

    public static Specification<MeasurementHistory> findByDate(LocalDate firstDate, LocalDate lastDate) {
        return (root, query, builder) -> builder.between(root.get("measurementDate"), firstDate, lastDate );
    }

    public static Specification<MeasurementHistory> findByTime(LocalTime begin, LocalTime end) {
        return (root, query, builder) -> builder.between(root.get("measurementTime"), begin, end );
    }
}
