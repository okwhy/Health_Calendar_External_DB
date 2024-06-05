package com.health_calendar.databasehl.services.impl;

import com.health_calendar.databasehl.dtos.UsersDbDto;
import com.health_calendar.databasehl.entites.UsersDb;
import com.health_calendar.databasehl.repos.UsersDbRepository;
import com.health_calendar.databasehl.services.UserService;
import lombok.Data;
import org.springframework.stereotype.Service;

@Service
@Data
public class UserServiceImpl  implements UserService {
    private final UsersDbRepository usersDbRepository;
    @Override
    public boolean addUser(String login, String password, String name) {
        if (usersDbRepository.existsByLogin(login)) {
            return false;
        }
        UsersDb tmp = UsersDb.builder()
                .login(login)
                .password(password)
                .name(name)
                .build();
        usersDbRepository.save(tmp);
        return true;
    }

    @Override
    public UsersDbDto auth(String login, String password) {
        System.out.println(login +" "+password);
        if (!usersDbRepository.existsByLogin(login)) {
            return new UsersDbDto((long) -1,null);
        }
        if(!usersDbRepository.existsByLoginAndPassword(login, password)){
            return new UsersDbDto((long) -2,null);
        }
        var tmp = usersDbRepository.findByLoginAndPassword(login, password);
        return new UsersDbDto(tmp.getId(),tmp.getName());
    }
}
