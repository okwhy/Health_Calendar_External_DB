package com.health_calendar.databasehl.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * DTO for {@link com.health_calendar.databasehl.entites.GroupCreator}
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class GroupCreatorForCreatorDto implements Serializable {
    private Long id;
    private String groupName;
    private String accessKey;
    private Set<GroupMemberForCreatorDto> groupMembers = new LinkedHashSet<>();
}