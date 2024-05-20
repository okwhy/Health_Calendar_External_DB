package com.health_calendar.databasehl.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * DTO for {@link com.health_calendar.databasehl.entites.UsersDb}
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UsersDbDto1 implements Serializable {
    private Long id;
    private String name;
    private List<DateDto1> dates = new ArrayList<>();
}