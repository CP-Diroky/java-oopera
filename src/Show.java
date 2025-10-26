import java.util.ArrayList;
import java.util.Scanner;

public class Show {
    private String title;
    private int duration;
    private Director director;
    private ArrayList<Actor> listOfActors = new ArrayList<>();
    private Scanner scanner;

    public Show(String title, int duration, Scanner scanner) {
        this.title = title;
        this.duration = duration;
        this.scanner = scanner;
    }

    void addActor(ArrayList<Actor> listOfNewActors) {
        if (listOfNewActors.isEmpty()) {
            System.out.println("Вы не создали ни одного актёра!");
            return;
        }
        System.out.println("Введите номер актёра, которого хотите добавить");
        for (int i = 0; i < listOfNewActors.size(); i++) {
            System.out.print("№ " + (i + 1) + ": " + listOfNewActors.get(i));
            System.out.println();
        }
        int selectedNumber = scanner.nextInt();
        if ((selectedNumber - 1) > listOfNewActors.size() || (selectedNumber - 1) < 0) {
            System.out.println("Неверный номер!");
            return;
        } else if (listOfActors.contains(listOfNewActors.get(selectedNumber - 1))) {
            System.out.println("Этот актёр уже есть в спектакле!");
            return;
        }
        listOfActors.add(listOfNewActors.get(selectedNumber - 1));
    }

    void replaceActor(ArrayList<Actor> listOfNewActors) {
        if (listOfNewActors.isEmpty()) {
            System.out.println("Вы не создали ни одного актёра!");
            return;
        } else if (listOfActors.isEmpty()) {
            System.out.println("В спектакле нет ни одного актёра!");
            return;
        }
        System.out.println("Выберите номер актёра которого хотите заменить");
        for (int i = 0; i < listOfActors.size(); i++) {
            System.out.print("№ " + (i + 1) + ": " + listOfActors.get(i));
            System.out.println();
        }
        int numberOfReplacedActor = scanner.nextInt();
        if ((numberOfReplacedActor - 1) > listOfActors.size() || (numberOfReplacedActor - 1) < 0) {
            System.out.println("Неверный номер!");
            return;
        }
        listOfActors.remove(numberOfReplacedActor - 1);

        System.out.println("Введите номер актёра, которого хотите добавить");
        for (int i = 0; i < listOfNewActors.size(); i++) {
            System.out.print("№ " + (i + 1) + ": " + listOfNewActors.get(i));
            System.out.println();
        }
        int selectedNumber = scanner.nextInt();
        if ((selectedNumber - 1) > listOfNewActors.size() || (selectedNumber - 1) < 0) {
            System.out.println("Неверный номер!");
            return;
        } else if (listOfActors.contains(listOfNewActors.get(selectedNumber - 1))) {
            System.out.println("Этот актёр уже есть в спектакле!");
            return;
        }
        listOfActors.add(listOfNewActors.get(selectedNumber - 1));
        System.out.println("Актёр заменен!");

    }

    public Director getDirector() {
        if (director == null) {
            System.out.println("Вы не добавили режиссёра!");
        }
        return director;
    }

    public ArrayList<Actor> getListOfActors() {
        if (listOfActors.isEmpty()) {
            System.out.println("Вы не добавили ни одного актёра в спектакль!");
        }
        return listOfActors;
    }

    public void setDirector(ArrayList<Director> listOfNewDirectors) {
        if (listOfNewDirectors.isEmpty()) {
            System.out.println("Вы не добавили ни одного режиссёра!");
            return;
        }
        System.out.println("Введите номер режиссёра, которого хотите добавить");
        for (int i = 0; i < listOfNewDirectors.size(); i++) {
            System.out.print("№ " + (i + 1) + ": " + listOfNewDirectors.get(i));
            System.out.println();
        }
        int selectedNumber = scanner.nextInt();
        if ((selectedNumber - 1) > listOfNewDirectors.size() || (selectedNumber - 1) < 0) {
            System.out.println("Неверный номер!");
            return;
        }
        this.director = listOfNewDirectors.get(selectedNumber - 1);
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
