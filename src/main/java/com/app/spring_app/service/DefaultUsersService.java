package com.app.spring_app.service;

import com.app.spring_app.dto.UsersDto;
import com.app.spring_app.entity.Users;
import com.app.spring_app.exception.ValidationException;
import com.app.spring_app.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import static java.util.Objects.isNull;
@AllArgsConstructor
@Service
public class DefaultUsersService implements UsersService{

    private final UserRepository userRepository;
    private  final UsersConverter usersConverter;


    private void validateUserDto(UsersDto usersDto) throws ValidationException {
        if (isNull(usersDto)) {
            throw new ValidationException("Object user is null");
        }
       if (isNull(usersDto.getLogin()) || usersDto.getLogin().isEmpty()) {
           throw new ValidationException("Login is empty");
       }
    }

    @Override
    public UsersDto saveUser(UsersDto usersDto) throws ValidationException {
        validateUserDto(usersDto);
        Users savedUser = userRepository.save(usersConverter.fromUserDtoToUser(usersDto));
        return usersConverter.fromUserToUserDto(savedUser);
    }

    @Override
    public void deleteUser(Integer userId) {
        userRepository.deleteById(userId);
    }

    @Override
    public UsersDto findByLogin(String login) {
        Users users = userRepository.findByLogin(login);
        if (users != null) {
            return usersConverter.fromUserToUserDto(users);
        }
        return null;
    }

    @Override
    public List<UsersDto> findAll() {
        return userRepository.findAll()
                .stream()
                .map(usersConverter::fromUserToUserDto)
                .collect(Collectors.toList());
    }


}
