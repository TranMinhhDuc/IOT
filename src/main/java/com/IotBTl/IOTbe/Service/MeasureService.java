
package com.IotBTl.IOTbe.Service;

import com.IotBTl.IOTbe.WebSocketHandler.MeasurementHandler;
import com.IotBTl.IOTbe.dto.request.MeasurementHistoryRequest;
import com.IotBTl.IOTbe.entity.MeasurementHistory;
import com.IotBTl.IOTbe.repository.MeasurementRepository;
import com.IotBTl.IOTbe.specication.MeasurementSpecification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class MeasureService {
    @Autowired
    private MeasurementRepository measurementRepository;

    public Page<MeasurementHistory> getMeasureHistory(int pageNumber, int pageSize) {
        Pageable pageable = PageRequest.of(pageNumber, pageSize,
                Sort.by(Sort.Order.desc("measurementDate"), Sort.Order.desc("measurementTime")));
        return measurementRepository.findAll(pageable);
    }

    public Page<MeasurementHistory> getMeasureHistory
            (LocalDate startDate, LocalDate endDate, int pageNumber) {

        Specification<MeasurementHistory> spec = Specification
                .where(MeasurementSpecification.findByDate(startDate, endDate));
        Pageable pageable = PageRequest.of(pageNumber, 10,
                Sort.by(Sort.Order.desc("measurementDate"), Sort.Order.desc("measurementTime")));
        return measurementRepository.findAll(spec, pageable);
    }

    public Page<MeasurementHistory> getMeasureHistory(
            LocalDate startDate, LocalDate endDate,
            LocalTime begin, LocalTime end, int pageNumber) {

        Specification<MeasurementHistory> spec = Specification
                .where(MeasurementSpecification.findByDate(startDate,endDate))
                .and(MeasurementSpecification.findByTime(begin, end));
        Pageable pageable = PageRequest.of(pageNumber, 10,
                Sort.by(Sort.Order.desc("measurementDate"), Sort.Order.desc("measurementTime")));
        return measurementRepository.findAll(spec, pageable);
    }
}
