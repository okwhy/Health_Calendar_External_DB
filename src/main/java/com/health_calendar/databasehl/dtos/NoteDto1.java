package com.health_calendar.databasehl.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * DTO for {@link com.health_calendar.databasehl.entites.Note}
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class NoteDto1 implements Serializable {
    private String type;
    private String value;
}