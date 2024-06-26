package com.health_calendar.databasehl.services.impl;

import com.health_calendar.databasehl.dtos.GroupCreatorForCreatorDto;
import com.health_calendar.databasehl.dtos.GroupCreatorToMemberDto;
import com.health_calendar.databasehl.entites.Date;
import com.health_calendar.databasehl.entites.GroupCreator;
import com.health_calendar.databasehl.entites.GroupMember;
import com.health_calendar.databasehl.entites.UsersDb;
import com.health_calendar.databasehl.repos.GroupCreatorRepository;
import com.health_calendar.databasehl.repos.GroupMemberRepository;
import com.health_calendar.databasehl.repos.UsersDbRepository;
import com.health_calendar.databasehl.services.GroupCreatorService;
import com.health_calendar.databasehl.utils.RandomUtil;
import lombok.Data;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

@Service
@Data
public class GroupCreatorServiceImpl implements GroupCreatorService {

    private final UsersDbRepository usersDbRepository;
    private final GroupCreatorRepository groupCreatorRepository;
    private final GroupMemberRepository groupMemberRepository;
    private final ModelMapper modelMapper;


    @Override
    public GroupCreatorForCreatorDto createGroup(Long creator_id, String name) {

        String randomString = RandomUtil.generateRandomString(6);

        GroupCreator groupCreator = GroupCreator.builder()
                .fkCreator(usersDbRepository.findById(creator_id).get())
                .groupName(name)
                .accessKey(randomString)
                .groupMembers(new HashSet<>())
                .build();
       GroupCreator tmp=  groupCreatorRepository.save(groupCreator);

        return modelMapper.map(tmp, GroupCreatorForCreatorDto.class);
    }

    @Override
    public void deleteGroup(Long id) {

        groupCreatorRepository.deleteById(id);

    }

    @Override
    public List<GroupCreatorForCreatorDto> getAllGroups(Long creator_id) {

        List<GroupCreator> groupCreators= groupCreatorRepository.findByFkCreator(usersDbRepository.findById(creator_id).get());
        return modelMapper.map(groupCreators, new TypeToken<List<GroupCreatorForCreatorDto>>(){}.getType());

    }

    @Override
    public List<GroupCreatorToMemberDto> getAllUserGroups(Long user_id) {
         List<GroupCreator> groupCreators=groupMemberRepository.findByFkUser_Id(user_id)
                .stream()
                .map(GroupMember::getFkGroup)
                .toList();
        return modelMapper.map(groupCreators,new TypeToken<List<GroupCreatorToMemberDto>>(){}.getType());

    }
    @Override
    public GroupCreatorToMemberDto addUser(Long user_id, String key){
        GroupCreator group = groupCreatorRepository.findByAccessKey(key);
        GroupMember newGroup = GroupMember.builder()
                .fkGroup(group)
                .fkUser(usersDbRepository.findById(user_id).get())
                .build();
        GroupMember tmp= groupMemberRepository.save(newGroup);
        GroupCreatorToMemberDto res=modelMapper.map(tmp,GroupCreatorToMemberDto.class);
        res.setId(tmp.getFkGroup().getId());
        return res;
    }
    @Override
    public void deleteUser(Long user_id, Long id){
        GroupMember groupMember= groupMemberRepository.findByFkUser_IdAndFkGroup_Id(user_id, id);
        groupMemberRepository.delete(groupMember);
    }
    @Override
    public Map<UsersDb,List<Date>> getDates(Long creator_id,String key){
        GroupCreator groupCreator=groupCreatorRepository.findByAccessKey(key);
        if(!groupCreator.getFkCreator().getId().equals(creator_id)){
            return null;
        }
        Map<UsersDb,List<Date>> res=new HashMap<>();
        List<UsersDb> users= usersDbRepository.findByGroupMembers_FkGroup(groupCreator);
        for(UsersDb usersDb:users){
           res.put(usersDb,usersDb.getDates());
        }
        return res;
    }


}
