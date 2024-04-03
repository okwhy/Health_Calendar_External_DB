package com.health_calendar.databasehl.repos;

import com.health_calendar.databasehl.entites.UsersDb;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsersDbRepository extends JpaRepository<UsersDb, Long> {
//    @Query("select (count(u) > 0) from UsersDb u where u.auth like ?1")
    boolean existsByLogin(String login);
    boolean existsByLoginAndPassword(String login,String password);
}