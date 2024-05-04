package com.health_calendar.databasehl.services;


import com.health_calendar.databasehl.entites.Date;
import com.health_calendar.databasehl.entites.GroupCreator;
import com.health_calendar.databasehl.entites.UsersDb;

import java.util.List;
import java.util.Map;

public interface GroupCreatorService {

    String createGroup(Long creator_id,String name);

    void deleteGroup(Long id);

    List<GroupCreator> getAllGroups(Long creator_id);

    List<GroupCreator> getAllUserGroups(Long creator_id);

    void addUser(Long user_id, String key);

    void deleteUser(Long user_id, String key);

//    Map<UsersDb,List<Date>> getDatesForPeriod(Long creator_id, String key);

    Map<UsersDb,List<Date>> getDates(Long creator_id, String key);
}
