package com.health_calendar.databasehl.repos;

import com.health_calendar.databasehl.entites.Date;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DateRepository extends JpaRepository<Date, Long> {

    Date findByUid(String uid);
}