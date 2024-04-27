package com.health_calendar.databasehl.services.impl;

import com.health_calendar.databasehl.entites.GroupCreator;
import com.health_calendar.databasehl.repos.GroupCreatorRepository;
import com.health_calendar.databasehl.repos.UsersDbRepository;
import com.health_calendar.databasehl.services.GroupCreatorService;
import com.health_calendar.databasehl.utils.RandomUtil;
import lombok.Data;
import org.modelmapper.internal.bytebuddy.utility.RandomString;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Data
public class GroupCreatorServiceImpl implements GroupCreatorService {

    private final UsersDbRepository usersDbRepository;
    private final GroupCreatorRepository groupCreatorRepository;


    @Override
    public String createGroup(Long creator_id, String name) {

        String randomString = RandomUtil.generateRandomString(6);

        GroupCreator groupCreator = GroupCreator.builder()
                .fkCreator(usersDbRepository.findById(creator_id).get())
                .groupName(name)
                .accessKey(randomString)
                .build();
        groupCreatorRepository.save(groupCreator);

        return randomString;
    }

    @Override
    public void deleteGroup(Long id) {

        groupCreatorRepository.deleteById(id);

    }

    @Override
    public List<GroupCreator> getAllGroups(Long creator_id) {

        return groupCreatorRepository.findByFkCreator(usersDbRepository.findById(creator_id).get());

    }


}
