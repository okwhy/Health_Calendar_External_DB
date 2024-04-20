package com.health_calendar.databasehl.services.impl;

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
    public Long auth(String login, String password) {
        if (!usersDbRepository.existsByLogin(login)) {
            return (long) -1;
        }
        if(!usersDbRepository.existsByLoginAndPassword(login, password)){
            return (long) -2;
        }
        return usersDbRepository.findByLoginAndPassword(login, password).getId();
    }
}
