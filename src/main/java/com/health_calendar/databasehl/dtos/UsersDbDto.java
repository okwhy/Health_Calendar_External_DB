package com.health_calendar.databasehl.dtos;

import lombok.Value;

import java.io.Serializable;

/**
 * DTO for {@link com.health_calendar.databasehl.entites.UsersDb}
 */
@Value
public class UsersDbDto implements Serializable {
    Long id;
    String name;
}