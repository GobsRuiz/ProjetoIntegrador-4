package com.fatec.projetoIntegrador4.models;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Equipe {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Size(min=3, max=50)
    private String name;

    @NotNull
    private String funcao;

    private String funcao_autor;

    private String path;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "equipe_id", referencedColumnName = "id")
    private List<Programacao> programacaoes;

    @OneToOne(mappedBy = "equipe", cascade = CascadeType.ALL)
    private Autor autor;

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

    public String getFuncao() {
        return funcao;
    }

    public void setFuncao(String funcao) {
        this.funcao = funcao;
    }

    public Autor getAutor() {
        return autor;
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
    }

    public List<Programacao> getProgramacaoes() {
        return programacaoes;
    }

    public void setProgramacaoes(List<Programacao> programacaoes) {
        this.programacaoes = programacaoes;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getFuncao_autor() {
        return funcao_autor;
    }

    public void setFuncao_autor(String funcao_autor) {
        this.funcao_autor = funcao_autor;
    }
}
