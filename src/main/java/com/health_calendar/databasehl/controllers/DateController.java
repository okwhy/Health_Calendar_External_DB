package com.health_calendar.databasehl.controllers;

import com.health_calendar.databasehl.dtos.DateDto;
import com.health_calendar.databasehl.entites.Date;
import com.health_calendar.databasehl.services.DateService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/dates")
public class DateController {
    private final DateService dateService;
    @PostMapping("/add/{id}")
    public boolean add(@PathVariable Long id,@RequestBody DateDto dateDto) {
        return dateService.addDate(dateDto,id);
    }
//    @PostMapping("/add2/{id}")
//    public boolean add(@PathVariable Long id,@RequestBody Date dateDto) {
//        return dateService.addDate(dateDto,id);
//    }
}
