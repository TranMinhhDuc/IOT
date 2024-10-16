package com.IotBTl.IOTbe.Service;

import com.IotBTl.IOTbe.dto.request.MeasurementHistoryRequest;
import com.IotBTl.IOTbe.entity.MeasurementHistory;
import com.IotBTl.IOTbe.repository.MeasurementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MeasureService {
    @Autowired
    private MeasurementRepository measurementRepository;

    public com.IotBTl.IOTbe.entity.MeasurementHistory CreateMeasurementHistory(MeasurementHistoryRequest measure) {
        MeasurementHistory measureCreation = new MeasurementHistory();
        measureCreation.setTemperature(measure.getTemperature());
        measureCreation.setHumidity(measure.getHumidity());
        measureCreation.setBright(measure.getBright());
        measureCreation.setMeasurementDate(measure.getMeasurementDate());
        measureCreation.setMeasurementTime(measure.getMeasurementTime());

        return measurementRepository.save(measureCreation);
    }

    public List<MeasurementHistory> getMeasureHistory() {
        return measurementRepository.findAll();
    }
}
