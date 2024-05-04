package com.health_calendar.databasehl.repos;

import com.health_calendar.databasehl.entites.GroupCreator;
import com.health_calendar.databasehl.entites.GroupMember;
import com.health_calendar.databasehl.entites.UsersDb;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GroupMemberRepository extends JpaRepository<GroupMember, Long> {

    List<GroupMember> findByFkGroup(GroupCreator group);

    List<GroupMember> findByFkUser(UsersDb user);

    List<GroupMember> findDistinctByFkUser_Id(Long id);

    List<GroupMember> findByFkUser_Id(Long userId);

    GroupMember findByFkUser_IdAndFkGroup(Long id, GroupCreator fkGroup);

    GroupMember findByFkUser_IdAndFkGroup_AccessKey(Long id, String accessKey);
}
