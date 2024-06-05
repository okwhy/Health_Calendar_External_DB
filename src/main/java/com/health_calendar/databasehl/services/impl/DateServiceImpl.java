package com.health_calendar.databasehl.services.impl;

import com.health_calendar.databasehl.dtos.DateDto;
import com.health_calendar.databasehl.dtos.DateDto1;
import com.health_calendar.databasehl.dtos.GroupCreatorForCreatorDto;
import com.health_calendar.databasehl.entites.Date;
import com.health_calendar.databasehl.repos.DateRepository;
import com.health_calendar.databasehl.repos.UsersDbRepository;
import com.health_calendar.databasehl.services.DateService;
import lombok.Data;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Data
public class DateServiceImpl implements DateService {
    private final DateRepository dateRepository;
    private final UsersDbRepository usersDbRepository;
    private final ModelMapper modelMapper;
    @Override
    public boolean addDate(DateDto dto, Long id) {
        Date date = modelMapper.map(dto, Date.class);
        date.setFkUser(usersDbRepository.findById(id).get());
        dateRepository.save(date);
        return true;
    }

    @Override
    public boolean addDate(Date date, Long id) {
        date.setFkUser(usersDbRepository.findById(id).get());
        System.out.println(date.getNotes());
        dateRepository.save(date);
        return false;
    }

    @Override
    public boolean updateDate(DateDto dto, Long id) {
        Date date = modelMapper.map(dto, Date.class);

        Long date_id = dateRepository.findByUid(dto.getUid()).getId();

        date.setId(date_id);

        date.setFkUser(usersDbRepository.findById(id).get());

        dateRepository.save(date);

        return false;
    }

    @Override
    public List<DateDto1> getDates(Long id) {
        List<Date> tmp=dateRepository.findByFkUser_Id(id);
        return modelMapper.map(tmp, new TypeToken<List<DateDto1>>(){}.getType());
    }

}
