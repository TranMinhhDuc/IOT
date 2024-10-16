package com.IotBTl.IOTbe.Controller;

import com.IotBTl.IOTbe.Service.MeasureService;
import com.IotBTl.IOTbe.dto.request.MeasurementHistoryRequest;
import com.IotBTl.IOTbe.entity.MeasurementHistory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/measurement-history")
public class MeasurementController {
    @Autowired
    private MeasureService measureService;

    @PostMapping
    MeasurementHistory createMeasurementHistory(@RequestBody MeasurementHistoryRequest request){
        return measureService.CreateMeasurementHistory(request);
    }

    @GetMapping
    List<MeasurementHistory> getMeasureHistory(){
        return measureService.getMeasureHistory();
    }
}
