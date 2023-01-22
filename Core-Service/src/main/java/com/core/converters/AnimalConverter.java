package com.core.converters;

import com.core.dtos.AnimalDto;
import com.core.entities.Animal;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class AnimalConverter {


    public Animal dtoToEntity(AnimalDto animalDto) {
        return new Animal(
                animalDto.getId(),
                animalDto.getUsername(),
                animalDto.getViewAnimal(),
                animalDto.getDateBorn(),
                animalDto.getGender(),
                animalDto.getNickName()
        );
    }

    public AnimalDto entityToDto(Animal animal) {
        return new AnimalDto(
                animal.getId(),
                animal.getUsername(),
                animal.getViewAnimal(),
                animal.getDateBorn(),
                animal.getGender(),
                animal.getNickName()
        );
    }
}
