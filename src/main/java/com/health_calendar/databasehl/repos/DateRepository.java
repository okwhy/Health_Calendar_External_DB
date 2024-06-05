package com.health_calendar.databasehl.repos;

import com.health_calendar.databasehl.entites.Date;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DateRepository extends JpaRepository<Date, Long> {

    Date findByUid(String uid);

    List<Date> findByFkUser_Id(Long id);
}