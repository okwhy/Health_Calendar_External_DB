package com.health_calendar.databasehl.dtos;

import lombok.Value;

import java.io.Serializable;

/**
 * DTO for {@link com.health_calendar.databasehl.entites.Note}
 */
@Value
public class NoteDto implements Serializable {
    Long id;
    String type;
    String value;
}