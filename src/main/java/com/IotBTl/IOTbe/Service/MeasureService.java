package com.IotBTl.IOTbe.Service;

import com.IotBTl.IOTbe.dto.request.MeasurementHistoryRequest;
import com.IotBTl.IOTbe.entity.MeasurementHistory;
import com.IotBTl.IOTbe.repository.MeasurementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Service
public class MeasureService {
    @Autowired
    private MeasurementRepository measurementRepository;

    public MeasurementHistory CreateMeasurementHistory(MeasurementHistoryRequest measure) {
        MeasurementHistory measureCreation = new MeasurementHistory();
        measureCreation.setTemperature(measure.getTemperature());
        measureCreation.setHumidity(measure.getHumidity());
        measureCreation.setBright(measure.getBright());
        measureCreation.setMeasurementDate(measure.getMeasurementDate());
        measureCreation.setMeasurementTime(measure.getMeasurementTime());

        return measurementRepository.save(measureCreation);
    }

    public Page<MeasurementHistory> getMeasureHistory(int pageNumber) {
        Pageable pageable = PageRequest.of(pageNumber, 10);
        return measurementRepository.findAll(pageable);
    }

    public Page<MeasurementHistory> getMeasureHistoryByDateRange(LocalDate startDate, LocalDate endDate, int pageNumber) {
        Pageable pageable = PageRequest.of(pageNumber, 10);
        return measurementRepository.findByDateRange(startDate, endDate, pageable);
    }

    public Page<MeasurementHistory> getMeasureHistoryByDateTimeRange(LocalDate startDate, LocalDate endDate, LocalTime startTime, LocalTime endTime, int pageNumber) {
        Pageable pageable = PageRequest.of(pageNumber, 10);
        return measurementRepository.findByDateTimeRange(startDate, endDate, startTime, endTime, pageable);
    }
}
