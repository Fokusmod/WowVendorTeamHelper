package com.core.entities;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Entity
@Table(name = "animals")
@Data
@NoArgsConstructor
public class Animal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "username")
    private String username;

    @Column(name = "view_animal")
    private String viewAnimal;

    @Column(name = "date_born")
    private String dateBorn;

    @Column(name = "gender")
    private String gender;

    @Column(name = "nickname")
    private String nickName;

    @CreationTimestamp
    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @UpdateTimestamp
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    public Animal(Long id, String username, String viewAnimal, String dateBorn, String gender, String nickName) {
        this.id = id;
        this.username = username;
        this.viewAnimal = viewAnimal;
        this.dateBorn = dateBorn;
        this.gender = gender;
        this.nickName = nickName;
    }
}
