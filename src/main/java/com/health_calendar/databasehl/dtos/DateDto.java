package com.health_calendar.databasehl.dtos;

import lombok.Value;

import java.io.Serializable;
import java.util.Set;

/**
 * DTO for {@link com.health_calendar.databasehl.entites.Date}
 */
@Value
public class DateDto implements Serializable {
    Long id;
    Integer year;
    Integer month;
    Integer day;
    Set<NoteDto> notes;
}