package ava.java_school.java_se_04.task4;

import java.io.Serializable;
import java.util.*;

public class FilmsAndActors implements Serializable{
    private Map<String, List<String>> filmActorMap;

    public FilmsAndActors() {
        filmActorMap = new HashMap<>();
    }

    public FilmsAndActors(Map<String, List<String>> filmActorMap) {
        this.filmActorMap = filmActorMap;
    }

    public void addFilms(String ...filmsName){
        for (String film : filmsName) {
            if(!this.filmActorMap.containsKey(film))
                this.filmActorMap.put(film, new ArrayList<>());
        }

    }

    public void addActorsToFilm(String filmName, String ...actors){
        if(this.filmActorMap.containsKey(filmName)){
            this.filmActorMap.get(filmName).addAll(Arrays.asList(actors));
        } else {
            System.err.printf("Нет данных о фильме %s", filmName);
        }
    }

    public void removeFilm(String filmName){
        this.filmActorMap.remove(filmName);
    }

    public void removeActorsFromFilm(String filmName, String ...actors){
        if(this.filmActorMap.containsKey(filmName)){
            this.filmActorMap.get(filmName).removeAll(Arrays.asList(actors));
        } else {
            System.err.printf("Нет данных о фильме %s", filmName);
        }
    }

    public void print(){
        for (String film : filmActorMap.keySet()) {
            System.out.printf("Фильм: %s\nАктеры:\n%s\n\n",film, this.filmActorMap.get(film).toString());
        }
    }

}
