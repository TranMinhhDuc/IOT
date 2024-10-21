package com.IotBTl.IOTbe.Controller;

import com.IotBTl.IOTbe.Service.MeasureService;
import com.IotBTl.IOTbe.dto.request.MeasurementHistoryRequest;
import com.IotBTl.IOTbe.entity.MeasurementHistory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalTime;
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
    public Page<MeasurementHistory> getMeasureHistory(
            @RequestParam(defaultValue = "0") int pageNumber
    ) {
        return measureService.getMeasureHistory(pageNumber);
    }

    @GetMapping("/search-by-date")
    public Page<MeasurementHistory> getMeasureHistoryByDateRange(
            @RequestParam("startDate") LocalDate startDate,
            @RequestParam("endDate") LocalDate endDate,
            @RequestParam(defaultValue = "0") int pageNumber
    ) {
        return measureService.getMeasureHistoryByDateRange(startDate, endDate, pageNumber);
    }

    @GetMapping("/search-by-datetime")
    public Page<MeasurementHistory> getMeasureHistoryByDateTimeRange(
            @RequestParam("startDate") LocalDate startDate,
            @RequestParam("endDate") LocalDate endDate,
            @RequestParam("startTime") LocalTime startTime,
            @RequestParam("endTime") LocalTime endTime,
            @RequestParam(defaultValue = "0") int pageNumber
    ) {
        return measureService.getMeasureHistoryByDateTimeRange(startDate, endDate, startTime, endTime, pageNumber);
    }
}
