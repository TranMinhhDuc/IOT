package com.IotBTl.IOTbe.Controller;

import com.IotBTl.IOTbe.Service.DeviceService;
import com.IotBTl.IOTbe.dto.request.DeviceCreationRequest;
import com.IotBTl.IOTbe.entity.ControlDevicesHistory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalTime;

@RestController
@RequestMapping("/device-history")
public class DeviceHistoryController {
    @Autowired
    private DeviceService deviceService;

    @GetMapping
    public Page<ControlDevicesHistory> getDeviceHistory(
            @RequestParam(defaultValue = "0") int pageNumber
    ) {
        return deviceService.getDeviceHistory(pageNumber);
    }

    @GetMapping("/search-by-name")
    public Page<ControlDevicesHistory> findDeviceHistory(
            @RequestParam String deviceName,
            @RequestParam(defaultValue = "0") int pageNumber
    ) {
        return deviceService.findDeviceHistory(deviceName, pageNumber);
    }

    // Tìm kiếm theo khoảng ngày
    @GetMapping("/search-by-date")
    public Page<ControlDevicesHistory> findDeviceHistory(
            @RequestParam LocalDate firstDate,
            @RequestParam LocalDate lastDate,
            @RequestParam(defaultValue = "0") int pageNumber
    ) {
        return deviceService.findDeviceHistory(firstDate, lastDate, pageNumber);
    }

    // Tìm kiếm theo tên thiết bị và khoảng ngày
    @GetMapping("/search-by-name-date")
    public Page<ControlDevicesHistory> findDeviceHistory(
            @RequestParam String deviceName,
            @RequestParam LocalDate firstDate,
            @RequestParam LocalDate lastDate,
            @RequestParam(defaultValue = "0") int pageNumber
    ) {
        return deviceService.findDeviceHistory(deviceName, firstDate, lastDate, pageNumber);
    }

    // Tìm kiếm theo khoảng ngày và khoảng thời gian
    @GetMapping("/search-by-date-time")
    public Page<ControlDevicesHistory> findDeviceHistory(
            @RequestParam LocalDate firstDate,
            @RequestParam LocalDate lastDate,
            @RequestParam LocalTime begin,
            @RequestParam LocalTime end,
            @RequestParam(defaultValue = "0") int pageNumber
    ) {
        return deviceService.findDeviceHistory(firstDate, lastDate, begin, end, pageNumber);
    }

    // Tìm kiếm theo tất cả các điều kiện: tên thiết bị, khoảng ngày, khoảng thời gian
    @GetMapping("/search-by-all")
    public Page<ControlDevicesHistory> findDevicesHistory(
            @RequestParam String deviceName,
            @RequestParam LocalDate firstDate,
            @RequestParam LocalDate lastDate,
            @RequestParam LocalTime begin,
            @RequestParam LocalTime end,
            @RequestParam(defaultValue = "0") int pageNumber
    ) {
        return deviceService.findDevicesHistory(deviceName, firstDate, lastDate, begin, end, pageNumber);
    }
}