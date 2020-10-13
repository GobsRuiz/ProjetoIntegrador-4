package com.fatec.projetoIntegrador4.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.Length;

@Entity
public class MusicRequest {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank 
    @Length(min = 5, max = 50)
    private String name;

    @NotBlank
    @Length(min = 5, max = 50)
    private String city;

    @NotBlank
    @Length(min = 2, max = 50)
    private String music;

    @NotBlank
    @Length(min = 10, max = 300)
    private String message;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getMusic() {
        return music;
    }

    public void setMusic(String music) {
        this.music = music;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
