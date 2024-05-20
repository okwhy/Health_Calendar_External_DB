package com.health_calendar.databasehl.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * DTO for {@link com.health_calendar.databasehl.entites.GroupCreator}
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class GroupCreatorToMemberDto implements Serializable {
    private Long id;
    private String groupName;
}