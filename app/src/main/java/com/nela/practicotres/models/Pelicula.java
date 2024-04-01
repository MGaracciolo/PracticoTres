package com.nela.practicotres.models;

import java.util.ArrayList;

public class Pelicula {
    private int foto;
    private String titulo;

    private String resenia;
    private String director;
    private String actores;

    public Pelicula( int foto, String titulo, String resenia, String director, String actores) {
        this.titulo = titulo;
        this.foto = foto;
        this.resenia = resenia;
        this.director = director;
        this.actores = actores;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getFoto() {
        return foto;
    }

    public void setFoto(int foto) {
        this.foto = foto;
    }

    public String getResenia() {
        return resenia;
    }

    public void setResenia(String resenia) {
        this.resenia = resenia;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getActores() {
        return actores;
    }

    public void setActores(String actores) {
        this.actores = actores;
    }
}
