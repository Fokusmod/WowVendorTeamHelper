package com.core.repositories;

import com.core.entities.Animal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AnimalsRepository extends JpaRepository<Animal, Long> {

    @Query("select p from Animal p where p.username = :name")
    List<Animal> findByUserName(String name);
    }