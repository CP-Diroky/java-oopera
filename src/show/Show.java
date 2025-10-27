package show;

import person.Actor;
import person.Director;

import java.util.ArrayList;

public class Show {
    private String title;
    private int duration;
    private Director director;
    private ArrayList<Actor> listOfActors = new ArrayList<>();

    public Show(String title, int duration) {
        this.title = title;
        this.duration = duration;
    }

    public void addActor(ArrayList<Actor> listOfNewActors, int actorNumber) {
        if (listOfActors.contains(listOfNewActors.get(actorNumber - 1))) {
            System.out.println("Этот актёр уже есть в спектакле!");
            return;
        }
        listOfActors.add(listOfNewActors.get(actorNumber - 1));
    }

    public void replaceActor(ArrayList<Actor> listOfNewActors,int replacedActorNumber, int actorNumber) {
        listOfActors.remove(replacedActorNumber - 1);
        if (listOfActors.contains(listOfNewActors.get(actorNumber - 1))) {
            System.out.println("Этот актёр уже есть в спектакле!");
            return;
        }
        listOfActors.add(listOfNewActors.get(actorNumber - 1));
        System.out.println("Актёр заменен!");

    }

    public Director getDirector() {
        if (director == null) {
            System.out.println("Вы не добавили режиссёра!");
        }
        return director;
    }

    public ArrayList<Actor> getListOfActors() {
        return listOfActors;
    }

    public void setDirector(ArrayList<Director> listOfNewDirectors, int directorNumber) {
        this.director = listOfNewDirectors.get(directorNumber - 1);
        System.out.println("Режиссёр добавлен в спектакль!");

    }

    @Override
    public String toString() {
        return "{" +
                " Название: " + title +
                ", продолжительность: " + duration +
                " минут }";
    }
}
