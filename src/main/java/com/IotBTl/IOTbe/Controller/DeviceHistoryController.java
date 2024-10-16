package com.IotBTl.IOTbe.Controller;

import com.IotBTl.IOTbe.Service.DeviceService;
import com.IotBTl.IOTbe.dto.request.DeviceCreationRequest;
import com.IotBTl.IOTbe.entity.ControllDevicesHistory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/device-history")
public class DeviceHistoryController {
    @Autowired
    private DeviceService deviceService;

    @PostMapping
    ControllDevicesHistory createDeviceHistory(@RequestBody DeviceCreationRequest request) {
        return deviceService.createDeviceHistory(request);
    }
    @GetMapping
    public Page<ControllDevicesHistory> getDeviceHistory(
            @RequestParam(defaultValue = "0") int pageNumber
    ) {
        return deviceService.getDeviceHistory(pageNumber);
    }

}
