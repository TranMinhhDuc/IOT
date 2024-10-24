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
    public Page<MeasurementHistory> findMeasureHistory(
            @RequestParam(defaultValue = "0") int pageNumber,
            @RequestParam LocalDate firstDate,
            @RequestParam LocalDate lastDate
    ){
        return measureService.getMeasureHistory(firstDate, lastDate, pageNumber);
    }

    @GetMapping("/search-by-date-time")
    public Page<MeasurementHistory> findMeasurementHistory(
            @RequestParam(defaultValue = "0") int pageNumber,
            @RequestParam LocalDate firstDate,
            @RequestParam LocalDate lastDate,
            @RequestParam LocalTime begin,
            @RequestParam LocalTime end
    ) {
        return measureService.getMeasureHistory(firstDate, lastDate, begin, end, pageNumber);
    }
}
