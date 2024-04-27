package com.health_calendar.databasehl.repos;

import com.health_calendar.databasehl.entites.GroupCreator;
import com.health_calendar.databasehl.entites.UsersDb;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GroupCreatorRepository extends JpaRepository<GroupCreator, Long> {
    List<GroupCreator> findByFkCreator(UsersDb fk_creator);

}
