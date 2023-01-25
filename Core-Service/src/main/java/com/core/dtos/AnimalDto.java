package com.core.dtos;

import lombok.Data;

@Data
public class AnimalDto {
    private Long id;
    private String username;
    private String viewAnimal;
    private String dateBorn;
    private String gender;
    private String nickName;

    public AnimalDto(Long id, String username, String viewAnimal, String dateBorn, String gender, String nickName) {
        this.id = id;
        this.username = username;
        this.viewAnimal = viewAnimal;
        this.dateBorn = dateBorn;
        this.gender = gender;
        this.nickName = nickName;
    }
}
