package com.health_calendar.databasehl.services;


import com.health_calendar.databasehl.entites.GroupCreator;

import java.util.List;

public interface GroupCreatorService {

    String createGroup(Long creator_id,String name);

    void deleteGroup(Long id);

    List<GroupCreator> getAllGroups(Long creator_id);
}
