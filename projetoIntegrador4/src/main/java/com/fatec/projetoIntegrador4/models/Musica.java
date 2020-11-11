package com.fatec.projetoIntegrador4.models;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Musica {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @ManyToOne()
    @JoinColumn(name = "artista_id", referencedColumnName = "id")
    private Artista artista;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "musica_id", referencedColumnName = "id")
    private List<Top20> top20s;


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

    public Artista getArtista() {
        return artista;
    }

    public void setArtista(Artista artista) {
        this.artista = artista;
    }

    public List<Top20> getTop20s() {
        return top20s;
    }

    public void setTop20s(List<Top20> top20s) {
        this.top20s = top20s;
    }
}
