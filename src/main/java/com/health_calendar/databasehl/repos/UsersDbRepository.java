package com.health_calendar.databasehl.repos;

import com.health_calendar.databasehl.entites.GroupCreator;
import com.health_calendar.databasehl.entites.UsersDb;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UsersDbRepository extends JpaRepository<UsersDb, Long> {
    boolean existsByLogin(String login);
    boolean existsByLoginAndPassword(String login,String password);
    UsersDb findByLoginAndPassword(String login, String password);

    List<UsersDb> findByGroupMembers_FkGroup(GroupCreator fkGroup);
}