package com.health_calendar.databasehl.controllers;

import com.health_calendar.databasehl.dtos.DateDto;
import com.health_calendar.databasehl.entites.Date;
import com.health_calendar.databasehl.entites.GroupCreator;
import com.health_calendar.databasehl.entites.UsersDb;
import com.health_calendar.databasehl.services.DateService;
import com.health_calendar.databasehl.services.GroupCreatorService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/groups")
public class GroupController {
    private final GroupCreatorService groupCreatorService;

    @PostMapping("/add")
    public String add(@RequestParam Long creator_id, @RequestParam String name) {

        return groupCreatorService.createGroup(creator_id, name);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Long id) {

        groupCreatorService.deleteGroup(id);
    }

    @GetMapping("/users/{id}")
    public List<GroupCreator> getAllGroups(@PathVariable Long id) {

        return groupCreatorService.getAllGroups(id);
    }
    @GetMapping("/byuser/{id}")
    public List<GroupCreator> getAllUserGroups(@PathVariable Long id) {

        return groupCreatorService.getAllUserGroups(id);
    }

    @PostMapping("/users/add")
    public void addUser(@RequestParam Long id, @RequestParam String key) {
        groupCreatorService.addUser(id,key);
    }
    @GetMapping("/users/{id}/dates")
    public Map<UsersDb,List<Date>> getUserDates(@PathVariable Long id,@RequestParam String key) {
        return groupCreatorService.getDates(id, key);
    }
}
