package com.example.ms1.ms1.entity.dto;

import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {
    private int id;
    private String name;
    private String lastName;
    private String userName;
    private LocalDate creationDate;
}
