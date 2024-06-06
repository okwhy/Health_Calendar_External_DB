package com.health_calendar.databasehl.services;

import com.health_calendar.databasehl.dtos.DateDto;
import com.health_calendar.databasehl.dtos.DateDto1;
import com.health_calendar.databasehl.dtos.DateDtoIDMutable;
import com.health_calendar.databasehl.entites.Date;

import java.util.List;

public interface DateService {
   boolean addDate(DateDto dto, Long id);
   boolean addDate(Date date, Long id);
   DateDtoIDMutable addDate(DateDto1 dto, Long id);
   DateDtoIDMutable updateDate(DateDto1 date, Long id);
   List<DateDto1> getDates(Long id);
}
