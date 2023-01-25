package com.core.services;

import com.core.converters.AnimalConverter;
import com.core.dtos.AnimalDto;
import com.core.entities.Animal;
import com.core.exceptions.ResourceNotFoundException;
import com.core.repositories.AnimalsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class AnimalsService {

    private final AnimalConverter animalConverter;
    private final AnimalsRepository animalsRepository;

    public List<AnimalDto> findByUserName (String name) {
        List<Animal> list = animalsRepository.findByUserName(name);
        List<AnimalDto> dtoList = list.stream().map(animalConverter::entityToDto).toList();
        return dtoList;
    }

    public AnimalDto findById(Long id) {
        Animal animal = animalsRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Image not found."));
        AnimalDto animalDto = animalConverter.entityToDto(animal);
        return animalDto;
    }

    public void delAnimalById(Long id) {
        animalsRepository.deleteById(id);
    }

    public Animal createNewAnimal(Animal animal){
        return animalsRepository.save(animal);
    }

    public Animal save(Animal animal){
        return animalsRepository.save(animal);
    }
}
