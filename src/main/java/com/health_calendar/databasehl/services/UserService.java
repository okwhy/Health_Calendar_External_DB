package com.health_calendar.databasehl.services;

import com.health_calendar.databasehl.dtos.UsersDbDto;

public interface UserService {
    boolean addUser(String login,String password,String name);
    UsersDbDto auth(String login, String password);
}
