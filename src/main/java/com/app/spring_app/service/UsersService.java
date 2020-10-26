package com.app.spring_app.service;

import com.app.spring_app.dto.UsersDto;
import com.app.spring_app.exception.ValidationException;


import java.util.List;


public interface UsersService {
    UsersDto saveUser(UsersDto usersDto) throws ValidationException;

    void deleteUser(Integer userId);

    UsersDto findByLogin(String login);

    List<UsersDto> findAll();
}
