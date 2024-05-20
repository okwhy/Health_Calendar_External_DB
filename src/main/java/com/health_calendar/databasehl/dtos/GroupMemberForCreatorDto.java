package com.health_calendar.databasehl.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * DTO for {@link com.health_calendar.databasehl.entites.GroupMember}
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class GroupMemberForCreatorDto implements Serializable {
    private UsersDbDto1 fkUser;
}