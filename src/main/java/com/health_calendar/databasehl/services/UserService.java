package com.health_calendar.databasehl.services;

public interface UserService {
    boolean addUser(String login,String password,String name);
    String auth(String login, String password);
}
