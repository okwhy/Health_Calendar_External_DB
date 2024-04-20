package com.health_calendar.databasehl.services;

import com.health_calendar.databasehl.dtos.DateDto;
import com.health_calendar.databasehl.entites.Date;

public interface DateService {
   boolean addDate(DateDto dto, Long id);
   boolean addDate(Date date, Long id);
}
