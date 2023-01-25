package com.core.controllers;

import com.core.converters.AnimalConverter;
import com.core.dtos.AnimalDto;
import com.core.entities.Animal;
import com.core.services.AnimalsService;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@Data
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/animals")
public class AnimalsController {

    private final AnimalsService animalsService;
    private final AnimalConverter animalConverter;

    @GetMapping("/{id}")
    public AnimalDto getAnimalById(@PathVariable Long id) {
        return animalsService.findById(id);
    }

    @GetMapping("/foruser/{user}")
    public List<AnimalDto> getAllAnimals(@PathVariable String user) {
        return animalsService.findByUserName(user);
    }

    @PostMapping()
    public void createNewAnimal(@RequestBody AnimalDto animalDto){
        Animal animal = animalConverter.dtoToEntity(animalDto);
        animalsService.createNewAnimal(animal);
    }

    @PutMapping()
    public void updateAnimal(@RequestBody AnimalDto animalDto){
        Animal animal = animalConverter.dtoToEntity(animalDto);
        animalsService.save(animal);
    }

    @DeleteMapping("/{id}")
    public void delAnimal(@PathVariable Long id){
        animalsService.delAnimalById(id);
    }
}
