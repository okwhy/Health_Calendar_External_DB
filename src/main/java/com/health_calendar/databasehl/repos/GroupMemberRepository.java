package com.health_calendar.databasehl.repos;

import com.health_calendar.databasehl.entites.GroupCreator;
import com.health_calendar.databasehl.entites.GroupMember;
import com.health_calendar.databasehl.entites.UsersDb;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GroupMemberRepository extends JpaRepository<GroupMember, Long> {

    List<GroupMember> findByFkGroup(GroupCreator group);

    List<GroupMember> findByFkUser(UsersDb user);

}
