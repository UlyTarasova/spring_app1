package com.app.spring_app.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;



@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class UsersDto {

    private Integer id;
    private String name;
    private String login;
    private String email;
}