package com.health_calendar.databasehl.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * DTO for {@link com.health_calendar.databasehl.entites.Date}
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DateDtoIDMutable implements Serializable {
    private Long id;
    private Integer year;
    private Integer month;
    private Integer day;
    private List<NoteDto1> notes = new ArrayList<>();
    private String uid;
}