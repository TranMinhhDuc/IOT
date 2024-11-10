package com.IotBTl.IOTbe.Service;

import com.IotBTl.IOTbe.WebSocketHandler.DashboardHandler;
import com.IotBTl.IOTbe.dto.request.MeasurementHistoryRequest;
import com.IotBTl.IOTbe.entity.ControlDevicesHistory;
import com.IotBTl.IOTbe.entity.MeasurementHistory;
import com.IotBTl.IOTbe.repository.DeviceRepository;
import com.IotBTl.IOTbe.repository.MeasurementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DashboardService {

    @Autowired
    DeviceRepository deviceRepository;
    @Autowired
    MeasurementRepository measurementRepository;
    @Autowired
    private DashboardHandler dashboardHandler;

    private List<MeasurementHistory> measurementHistoriesList = new ArrayList<>();
    
    public ControlDevicesHistory createDeviceHistory(String s) {
        ControlDevicesHistory newControlDevice = new ControlDevicesHistory();
        if (s.charAt(0) == '1') {
            newControlDevice.setDeviceName("Light");
        } else if (s.charAt(0) == '2') {
            newControlDevice.setDeviceName("FAN");
        } else if (s.charAt(0) == '3') {
            newControlDevice.setDeviceName("AC");
        }

        newControlDevice.setAction(s.substring(1));
        newControlDevice.setActionDate();
        newControlDevice.setActionTime();

        dashboardHandler.sendMessage(s);

        return deviceRepository.save(newControlDevice);
    }


    public void createMeasurementHistory(MeasurementHistoryRequest measure) {
        MeasurementHistory measureCreation = new MeasurementHistory();
        measureCreation.setTemperature(measure.getTemperature());
        measureCreation.setHumidity(measure.getHumidity());
        measureCreation.setBright(measure.getBright());
        measureCreation.setMeasurementDate();
        measureCreation.setMeasurementTime();

        dashboardHandler.sendMessage(measureCreation.toJson());
        measurementHistoriesList.add(measureCreation);
        System.out.println(measureCreation.toJson());

        // Save and clear list if it reaches 30 items
        if (measurementHistoriesList.size() >= 30) {
            measurementRepository.saveAll(new ArrayList<>(measurementHistoriesList));

            System.out.println("Saving 30 items of measurement history.");// Create a copy to avoid concurrency issues
            measurementHistoriesList.clear();
        }
    }

    public Page<MeasurementHistory> getItemChart() {
        Pageable pageable = PageRequest.of(0,10,
                Sort.by(Sort.Order.desc("measurementDate"),
                        Sort.Order.desc("measurementTime")));

        return measurementRepository.findAll(pageable);
    }
}
