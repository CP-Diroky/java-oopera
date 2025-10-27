import person.Actor;
import person.Director;
import person.Genders;
import person.Person;
import show.Ballet;
import show.Opera;
import show.Show;

import java.util.Scanner;
import java.util.ArrayList;

public class Theatre {
    public static void main(String[] args) {
        // В данном классе реализовано меню приложения

        System.out.println("Поехали!");
        while (true) {
            System.out.println("Что хотите сделать?");
            System.out.println("1 - Создать актёра");
            System.out.println("2 - Создать режиссёра");
            System.out.println("3 - Создать спектакль");
            System.out.println("4 - Добавить актёра в спектакль");
            System.out.println("5 - Добавить режиссёра в спектакль");
            System.out.println("6 - Заменить актёра в спектакле");
            System.out.println("7 - Распечатать текст либретто");
            System.out.println("8 - Распечатать информацию о режиссёре спектакля");
            System.out.println("9 - Распечатать список актёров");
            System.out.println("0 - Завершить программу");
            int command = scanner.nextInt();
            switch (command) {
                case 1:
                    addNewActor();
                    break;
                case 2:
                    addNewDirector();
                    break;
                case 3:
                    createShow();
                    break;
                case 4:
                    addActorToShow(listOfNewActors);
                    break;
                case 5:
                    addDirectorToShow(listOfNewDirectors);
                    break;
                case 6:
                    replaceActorInShow(listOfNewActors);
                    break;
                case 7:
                    printLibrettoText();
                    break;
                case 8:
                    printDirectorInfo();
                    break;
                case 9:
                    printActorsList();
                    break;
                case 0:
                    System.out.println("Программа завершена!");
                    return;
                default:
                    System.out.println("Неверная команда!");
            }
        }
    }

    /* Тут создаются списки: Есть список всех доступных актёров, режиссёров и спектаклей. Соответственно можно
       создавать бесконечное количество актёров, режиссёров и спектаклей. Спектакли делятся на обычные, оперные и балет.
       Актёров из списка можно распределять в спектакли. Режиссёр у спектакля может быть только один.
       Выбор актёров, режиссёров и спектаклей осуществляется через их номера по спискам
    */
    static Scanner scanner = new Scanner(System.in);
    static ArrayList<Actor> listOfNewActors = new ArrayList<>();
    static ArrayList<Director> listOfNewDirectors = new ArrayList<>();
    static ArrayList<Show> listOfShows = new ArrayList<>();
    static ArrayList<Opera> listOfOperas = new ArrayList<>();
    static ArrayList<Ballet> listofBallet = new ArrayList<>();


    static void addNewActor() { // метод по созданию актёра
        System.out.println("Введите имя актёра:");
        String name = scanner.next();
        System.out.println("Введите фамилию актёра:");
        String surName = scanner.next();
        System.out.println("Введите пол актёра, MALE если мужской, FEMALE если женский");
        Genders gender = Genders.valueOf(scanner.next());
        System.out.println("Введите рост человека в см:");
        int height = scanner.nextInt();
        Actor actor = new Actor(name, surName, gender, height);
        if (listOfNewActors.contains(actor)) {
            System.out.println("Такой актер уже есть!");
            return;
        } else {
            listOfNewActors.add(actor);
            System.out.println("Актёр добавлен!");
        }
    }

    static void addNewDirector() { // метод по созданию режиссёра
        System.out.println("Введите имя режиссёра:");
        String name = scanner.next();
        System.out.println("Введите фамилию режиссёра:");
        String surName = scanner.next();
        System.out.println("Введите пол режиссёра, MALE если мужской, FEMALE если женский");
        Genders gender = Genders.valueOf(scanner.next());
        System.out.println("Сколько спектаклей поставил данный режиссёр?");
        int numberOfShows = scanner.nextInt();
        Director director = new Director(name, surName, gender, numberOfShows);
        if (listOfNewDirectors.contains(director)) {
            System.out.println("Такой режиссёр уже есть!");
            return;
        } else {
            listOfNewDirectors.add(director);
            System.out.println("Режиссёр добавлен!");
        }
    }

    static void createShow() { // метод по созданию спектакля
        System.out.println("Какой спектакль нужно поставить?");
        System.out.println("1 - обычный");
        System.out.println("2 - оперный");
        System.out.println("3 - балет");
        int showType = scanner.nextInt();

        switch (showType) {
            case 1:
                System.out.println("Введите название спектакля:");
                scanner.nextLine();
                String title = scanner.nextLine();
                System.out.println("Введите продолжительность спектакля в минутах:");
                int duration = scanner.nextInt();
                Show show = new Show(title, duration);
                listOfShows.add(show);
                System.out.println("Спектакль создан!");
                break;
            case 2:
                System.out.println("Введите название спектакля:");
                scanner.nextLine();
                title = scanner.nextLine();
                System.out.println("Введите продолжительность спектакля в минутах:");
                duration = scanner.nextInt();
                System.out.println("Введите имя автора музыки:");
                String name = scanner.next();
                System.out.println("Введите фамилию автора музыки:");
                String surName = scanner.next();
                System.out.println("Введите пол автора музыки, MALE если мужской, FEMALE если женский");
                Genders gender = Genders.valueOf(scanner.next());
                Person musicAuthor = new Person(name, surName, gender);
                System.out.println("Введите текст либретто:");
                scanner.nextLine();
                String librettoText = scanner.nextLine();
                System.out.println("Количество человек в хоре:");
                int choirSize = scanner.nextInt();
                Opera opera = new Opera(title, duration, musicAuthor, librettoText, choirSize);
                listOfOperas.add(opera);
                System.out.println("Спектакль создан!");
                break;
            case 3:
                System.out.println("Введите название спектакля:");
                scanner.nextLine();
                title = scanner.nextLine();
                System.out.println("Введите продолжительность спектакля в минутах:");
                duration = scanner.nextInt();
                System.out.println("Введите имя автора музыки:");
                name = scanner.next();
                System.out.println("Введите фамилию автора музыки:");
                surName = scanner.next();
                System.out.println("Введите пол автора музыки, MALE если мужской, FEMALE если женский");
                gender = Genders.valueOf(scanner.next());
                musicAuthor = new Person(name, surName, gender);
                System.out.println("Введите текст либретто:");
                scanner.nextLine();
                librettoText = scanner.nextLine();
                System.out.println("Введите имя хореографа");
                name = scanner.next();
                System.out.println("Введите фамилию хореографа");
                surName = scanner.next();
                System.out.println("Введите пол хореографа, MALE если мужской, FEMALE если женский");
                gender = Genders.valueOf(scanner.next());
                Person choreographer = new Person(name, surName, gender);
                Ballet ballet = new Ballet(title, duration, musicAuthor, librettoText, choreographer);
                listofBallet.add(ballet);
                System.out.println("Спектакль создан!");
                break;
            default:
                System.out.println("Неверный ввод команды!");
        }
    }

    static void addActorToShow(ArrayList<Actor> listOfNewActors) { // метод по добавлению актёра в спектакль
        System.out.println("Выберите тип спектакля");
        System.out.println("1 - обычный");
        System.out.println("2 - оперный");
        System.out.println("3 - балет");
        int showType = scanner.nextInt();
        switch (showType) {
            case 1:
                if (listOfShows.isEmpty()) {
                    System.out.println("Добавьте спектакль!");
                    return;
                } else if (listOfNewActors.isEmpty()) {
                    System.out.println("Вы не создали ни одного актёра!");
                    return;
                }
                System.out.println("Выберите номер спектакля:");
                for (int i = 0; i < listOfShows.size(); i++) {
                    System.out.print("Спектакль под номером " + (i + 1) + ": " + listOfShows.get(i));
                    System.out.println();
                }
                int showNumber = scanner.nextInt();
                if ((showNumber - 1) > listOfShows.size() || (showNumber - 1) < 0) {
                    System.out.println("Неверный номер!");
                    return;
                }

                System.out.println("Введите номер актёра, которого хотите добавить");
                for (int i = 0; i < listOfNewActors.size(); i++) {
                    System.out.print("№ " + (i + 1) + ": " + listOfNewActors.get(i));
                    System.out.println();
                }
                int actorNumber = scanner.nextInt();
                if ((actorNumber - 1) > listOfNewActors.size() || (actorNumber - 1) < 0) {
                    System.out.println("Неверный номер!");
                    return;
                }
                listOfShows.get(showNumber - 1).addActor(listOfNewActors, actorNumber);
                System.out.println("Актёр добавлен в спектакль!");
                break;
            case 2:
                if (listOfOperas.isEmpty()) {
                    System.out.println("Добавьте спектакль!");
                    return;
                } else if (listOfNewActors.isEmpty()) {
                    System.out.println("Вы не создали ни одного актёра!");
                    return;
                }
                System.out.println("Выберите номер оперы:");
                for (int i = 0; i < listOfOperas.size(); i++) {
                    System.out.print("Опера под номером " + (i + 1) + ": " + listOfOperas.get(i));
                    System.out.println();
                }
                showNumber = scanner.nextInt();
                if ((showNumber - 1) > listOfOperas.size() || (showNumber - 1) < 0) {
                    System.out.println("Неверный номер!");
                    return;
                }


                System.out.println("Введите номер актёра, которого хотите добавить");
                for (int i = 0; i < listOfNewActors.size(); i++) {
                    System.out.print("№ " + (i + 1) + ": " + listOfNewActors.get(i));
                    System.out.println();
                }
                actorNumber = scanner.nextInt();
                if ((actorNumber - 1) > listOfNewActors.size() || (actorNumber - 1) < 0) {
                    System.out.println("Неверный номер!");
                    return;
                }
                listOfOperas.get(showNumber - 1).addActor(listOfNewActors, actorNumber);
                System.out.println("Актёр добавлен в оперу!");
                break;
            case 3:
                if (listofBallet.isEmpty()) {
                    System.out.println("Добавьте спектакль!");
                    return;
                } else if (listOfNewActors.isEmpty()) {
                    System.out.println("Вы не создали ни одного актёра!");
                    return;
                }
                System.out.println("Выберите номер балета:");
                for (int i = 0; i < listofBallet.size(); i++) {
                    System.out.print("Балет под номером " + (i + 1) + ": " + listofBallet.get(i));
                    System.out.println();
                }
                showNumber = scanner.nextInt();
                if ((showNumber - 1) > listofBallet.size() || (showNumber - 1) < 0) {
                    System.out.println("Неверный номер!");
                    return;
                }


                System.out.println("Введите номер актёра, которого хотите добавить");
                for (int i = 0; i < listOfNewActors.size(); i++) {
                    System.out.print("№ " + (i + 1) + ": " + listOfNewActors.get(i));
                    System.out.println();
                }
                actorNumber = scanner.nextInt();
                if ((actorNumber - 1) > listOfNewActors.size() || (actorNumber - 1) < 0) {
                    System.out.println("Неверный номер!");
                    return;
                }
                listofBallet.get(showNumber - 1).addActor(listOfNewActors, actorNumber);
                System.out.println("Актёр добавлен в балет!");
                break;
            default:
                System.out.println("Неверный ввод команды!");
        }
    }

    static void addDirectorToShow(ArrayList<Director> listOfNewDirectors) { // метод добавления режиссёра в спектакль
        System.out.println("Выберите тип спектакля");
        System.out.println("1 - обычный");
        System.out.println("2 - оперный");
        System.out.println("3 - балет");
        int showType = scanner.nextInt();
        switch (showType) {
            case 1:
                if (listOfShows.isEmpty()) {
                    System.out.println("Добавьте спектакль!");
                    return;
                } else if (listOfNewDirectors.isEmpty()) {
                    System.out.println("Вы не добавили ни одного режиссёра!");
                    return;
                }
                System.out.println("Выберите номер спектакля:");
                for (int i = 0; i < listOfShows.size(); i++) {
                    System.out.print("Спектакль под номером " + (i + 1) + ": " + listOfShows.get(i));
                    System.out.println();
                }
                int showNumber = scanner.nextInt();
                if ((showNumber - 1) > listOfShows.size() || (showNumber - 1) < 0) {
                    System.out.println("Неверный номер!");
                    return;
                }


                System.out.println("Введите номер режиссёра, которого хотите добавить");
                for (int i = 0; i < listOfNewDirectors.size(); i++) {
                    System.out.print("№ " + (i + 1) + ": " + listOfNewDirectors.get(i));
                    System.out.println();
                }
                int directorNumber = scanner.nextInt();
                if ((directorNumber - 1) > listOfNewDirectors.size() || (directorNumber - 1) < 0) {
                    System.out.println("Неверный номер!");
                    return;
                }
                listOfShows.get(showNumber - 1).setDirector(listOfNewDirectors, directorNumber);
                break;
            case 2:
                if (listOfOperas.isEmpty()) {
                    System.out.println("Добавьте спектакль!");
                    return;
                } else if (listOfNewDirectors.isEmpty()) {
                    System.out.println("Вы не добавили ни одного режиссёра!");
                    return;
                }
                System.out.println("Выберите номер оперы:");
                for (int i = 0; i < listOfOperas.size(); i++) {
                    System.out.print("Опера под номером " + (i + 1) + ": " + listOfOperas.get(i));
                    System.out.println();
                }
                showNumber = scanner.nextInt();
                if ((showNumber - 1) > listOfOperas.size() || (showNumber - 1) < 0) {
                    System.out.println("Неверный номер!");
                    return;
                }


                System.out.println("Введите номер режиссёра, которого хотите добавить");
                for (int i = 0; i < listOfNewDirectors.size(); i++) {
                    System.out.print("№ " + (i + 1) + ": " + listOfNewDirectors.get(i));
                    System.out.println();
                }
                directorNumber = scanner.nextInt();
                if ((directorNumber - 1) > listOfNewDirectors.size() || (directorNumber - 1) < 0) {
                    System.out.println("Неверный номер!");
                    return;
                }
                listOfOperas.get(showNumber - 1).setDirector(listOfNewDirectors, directorNumber);
                break;
            case 3:
                if (listofBallet.isEmpty()) {
                    System.out.println("Добавьте спектакль!");
                    return;
                } else if (listOfNewDirectors.isEmpty()) {
                    System.out.println("Вы не добавили ни одного режиссёра!");
                    return;
                }
                System.out.println("Выберите номер балета:");
                for (int i = 0; i < listofBallet.size(); i++) {
                    System.out.print("Балет под номером " + (i + 1) + ": " + listofBallet.get(i));
                    System.out.println();
                }
                showNumber = scanner.nextInt();
                if ((showNumber - 1) > listofBallet.size() || (showNumber - 1) < 0) {
                    System.out.println("Неверный номер!");
                    return;
                }


                System.out.println("Введите номер режиссёра, которого хотите добавить");
                for (int i = 0; i < listOfNewDirectors.size(); i++) {
                    System.out.print("№ " + (i + 1) + ": " + listOfNewDirectors.get(i));
                    System.out.println();
                }
                directorNumber = scanner.nextInt();
                if ((directorNumber - 1) > listOfNewDirectors.size() || (directorNumber - 1) < 0) {
                    System.out.println("Неверный номер!");
                    return;
                }
                listofBallet.get(showNumber - 1).setDirector(listOfNewDirectors, directorNumber);
                break;
            default:
                System.out.println("Неверный ввод команды!");
        }
    }

    static void replaceActorInShow(ArrayList<Actor> listOfNewActors) { // метод замены актёра
        System.out.println("Выберите тип спектакля");
        System.out.println("1 - обычный");
        System.out.println("2 - оперный");
        System.out.println("3 - балет");
        int showType = scanner.nextInt();
        switch (showType) {
            case 1:
                if (listOfShows.isEmpty()) {
                    System.out.println("Добавьте спектакль!");
                    return;
                } else if (listOfNewActors.isEmpty()) {
                    System.out.println("Вы не создали ни одного актёра!");
                    return;
                }
                System.out.println("Выберите номер спектакля:");
                for (int i = 0; i < listOfShows.size(); i++) {
                    System.out.print("Спектакль под номером " + (i + 1) + ": " + listOfShows.get(i));
                    System.out.println();
                }
                int showNumber = scanner.nextInt();
                if ((showNumber - 1) > listOfShows.size() || (showNumber - 1) < 0) {
                    System.out.println("Неверный номер!");
                    return;
                }
                if (listOfShows.get(showNumber - 1).getListOfActors().isEmpty()) {
                    System.out.println("В этом спектакле нет ни одного актёра!");
                    return;
                }
                System.out.println("Выберите номер актёра которого хотите заменить");
                for (int i = 0; i < listOfShows.get(showNumber - 1).getListOfActors().size(); i++) {
                    System.out.print("№ " + (i + 1) + ": " + listOfShows.get(showNumber - 1).getListOfActors().get(i));
                    System.out.println();
                }
                int replacedActorNumber = scanner.nextInt();


                System.out.println("Введите номер актёра, которого хотите добавить");
                for (int i = 0; i < listOfNewActors.size(); i++) {
                    System.out.print("№ " + (i + 1) + ": " + listOfNewActors.get(i));
                    System.out.println();
                }
                int actorNumber = scanner.nextInt();
                if ((actorNumber - 1) > listOfNewActors.size() || (actorNumber - 1) < 0) {
                    System.out.println("Неверный номер!");
                    return;
                }

                listOfShows.get(showNumber - 1).replaceActor(listOfNewActors, replacedActorNumber, actorNumber);
                break;
            case 2:
                if (listOfOperas.isEmpty()) {
                    System.out.println("Добавьте спектакль!");
                    return;
                } else if (listOfNewActors.isEmpty()) {
                    System.out.println("Вы не создали ни одного актёра!");
                    return;
                }
                System.out.println("Выберите номер спектакля:");
                for (int i = 0; i < listOfOperas.size(); i++) {
                    System.out.print("Спектакль под номером " + (i + 1) + ": " + listOfOperas.get(i));
                    System.out.println();
                }
                showNumber = scanner.nextInt();
                if ((showNumber - 1) > listOfOperas.size() || (showNumber - 1) < 0) {
                    System.out.println("Неверный номер!");
                    return;
                }
                if (listOfOperas.get(showNumber - 1).getListOfActors().isEmpty()) {
                    System.out.println("В этом спектакле нет ни одного актёра!");
                    return;
                }
                System.out.println("Выберите номер актёра которого хотите заменить");
                for (int i = 0; i < listOfOperas.get(showNumber - 1).getListOfActors().size(); i++) {
                    System.out.print("№ " + (i + 1) + ": " + listOfOperas.get(showNumber - 1).getListOfActors().get(i));
                    System.out.println();
                }
                replacedActorNumber = scanner.nextInt();


                System.out.println("Введите номер актёра, которого хотите добавить");
                for (int i = 0; i < listOfNewActors.size(); i++) {
                    System.out.print("№ " + (i + 1) + ": " + listOfNewActors.get(i));
                    System.out.println();
                }
                actorNumber = scanner.nextInt();
                if ((actorNumber - 1) > listOfNewActors.size() || (actorNumber - 1) < 0) {
                    System.out.println("Неверный номер!");
                    return;
                }

                listOfOperas.get(showNumber - 1).replaceActor(listOfNewActors, replacedActorNumber, actorNumber);
                break;
            case 3:
                if (listofBallet.isEmpty()) {
                    System.out.println("Добавьте спектакль!");
                    return;
                } else if (listOfNewActors.isEmpty()) {
                    System.out.println("Вы не создали ни одного актёра!");
                    return;
                }
                System.out.println("Выберите номер спектакля:");
                for (int i = 0; i < listofBallet.size(); i++) {
                    System.out.print("Спектакль под номером " + (i + 1) + ": " + listofBallet.get(i));
                    System.out.println();
                }
                showNumber = scanner.nextInt();
                if ((showNumber - 1) > listofBallet.size() || (showNumber - 1) < 0) {
                    System.out.println("Неверный номер!");
                    return;
                }
                if (listofBallet.get(showNumber - 1).getListOfActors().isEmpty()) {
                    System.out.println("В этом спектакле нет ни одного актёра!");
                    return;
                }
                System.out.println("Выберите номер актёра которого хотите заменить");
                for (int i = 0; i < listofBallet.get(showNumber - 1).getListOfActors().size(); i++) {
                    System.out.print("№ " + (i + 1) + ": " + listofBallet.get(showNumber - 1).getListOfActors().get(i));
                    System.out.println();
                }
                replacedActorNumber = scanner.nextInt();


                System.out.println("Введите номер актёра, которого хотите добавить");
                for (int i = 0; i < listOfNewActors.size(); i++) {
                    System.out.print("№ " + (i + 1) + ": " + listOfNewActors.get(i));
                    System.out.println();
                }
                actorNumber = scanner.nextInt();
                if ((actorNumber - 1) > listOfNewActors.size() || (actorNumber - 1) < 0) {
                    System.out.println("Неверный номер!");
                    return;
                }

                listofBallet.get(showNumber - 1).replaceActor(listOfNewActors, replacedActorNumber, actorNumber);
                break;
            default:
                System.out.println("Неверный ввод команды!");
        }
    }

    static void printLibrettoText() { // печать текста либретто
        System.out.println("Выберите оперу или балет:");
        System.out.println("1 - опера");
        System.out.println("2 - балет");
        int showType = scanner.nextInt();
        switch (showType) {
            case 1:
                if (listOfOperas.isEmpty()) {
                    System.out.println("Добавьте спектакль!");
                    return;
                }
                System.out.println("Выберите номер оперы:");
                for (int i = 0; i < listOfOperas.size(); i++) {
                    System.out.print("Опера под номером " + (i + 1) + ": " + listOfOperas.get(i));
                    System.out.println();
                }
                int showNumber = scanner.nextInt();
                if ((showNumber - 1) > listOfOperas.size() || (showNumber - 1) < 0) {
                    System.out.println("Неверный номер!");
                    return;
                }
                System.out.println(listOfOperas.get(showNumber - 1).getLibrettoText());
                break;
            case 2:
                if (listofBallet.isEmpty()) {
                    System.out.println("Добавьте спектакль!");
                    return;
                }
                System.out.println("Выберите номер балета:");
                for (int i = 0; i < listofBallet.size(); i++) {
                    System.out.print("Балет под номером " + (i + 1) + ": " + listofBallet.get(i));
                    System.out.println();
                }
                showNumber = scanner.nextInt();
                if ((showNumber - 1) > listofBallet.size() || (showNumber - 1) < 0) {
                    System.out.println("Неверный номер!");
                    return;
                }
                System.out.println(listofBallet.get(showNumber - 1).getLibrettoText());
                break;
            default:
                System.out.println("Неверный ввод команды!");
        }
    }

    static void printDirectorInfo() { // вывод информации о режиссёре спектакля
        System.out.println("Выберите тип спектакля");
        System.out.println("1 - обычный");
        System.out.println("2 - оперный");
        System.out.println("3 - балет");
        int showType = scanner.nextInt();
        switch (showType) {
            case 1:
                if (listOfShows.isEmpty()) {
                    System.out.println("Добавьте спектакль!");
                    return;
                }
                System.out.println("Выберите номер спектакля:");
                for (int i = 0; i < listOfShows.size(); i++) {
                    System.out.print("Спектакль под номером " + (i + 1) + ": " + listOfShows.get(i));
                    System.out.println();
                }
                int showNumber = scanner.nextInt();
                if ((showNumber - 1) > listOfShows.size() || (showNumber - 1) < 0) {
                    System.out.println("Неверный номер!");
                    return;
                }
                System.out.println(listOfShows.get(showNumber - 1).getDirector());

                break;
            case 2:
                if (listOfOperas.isEmpty()) {
                    System.out.println("Добавьте спектакль!");
                    return;
                }
                System.out.println("Выберите номер оперы:");
                for (int i = 0; i < listOfOperas.size(); i++) {
                    System.out.print("Опера под номером " + (i + 1) + ": " + listOfOperas.get(i));
                    System.out.println();
                }
                showNumber = scanner.nextInt();
                if ((showNumber - 1) > listOfOperas.size() || (showNumber - 1) < 0) {
                    System.out.println("Неверный номер!");
                    return;
                }
                System.out.println(listOfOperas.get(showNumber - 1).getDirector());
                break;
            case 3:
                if (listOfOperas.isEmpty()) {
                    System.out.println("Добавьте спектакль!");
                    return;
                }
                System.out.println("Выберите номер балета:");
                for (int i = 0; i < listofBallet.size(); i++) {
                    System.out.print("Балет под номером " + (i + 1) + ": " + listofBallet.get(i));
                    System.out.println();
                }
                showNumber = scanner.nextInt();
                if ((showNumber - 1) > listofBallet.size() || (showNumber - 1) < 0) {
                    System.out.println("Неверный номер!");
                    return;
                }
                System.out.println(listofBallet.get(showNumber - 1).getDirector());
                break;
            default:
                System.out.println("Неверный ввод команды!");
        }
    }

    static void printActorsList() { // вывод списка актёров выбранного спектакля
        System.out.println("Выберите тип спектакля");
        System.out.println("1 - обычный");
        System.out.println("2 - оперный");
        System.out.println("3 - балет");
        int showType = scanner.nextInt();
        switch (showType) {
            case 1:
                if (listOfShows.isEmpty()) {
                    System.out.println("Добавьте спектакль!");
                    return;
                }
                System.out.println("Выберите номер спектакля:");
                for (int i = 0; i < listOfShows.size(); i++) {
                    System.out.print("Спектакль под номером " + (i + 1) + ": " + listOfShows.get(i));
                    System.out.println();
                }
                int showNumber = scanner.nextInt();
                if ((showNumber - 1) > listOfShows.size() || (showNumber - 1) < 0) {
                    System.out.println("Неверный номер!");
                    return;
                }
                System.out.println(listOfShows.get(showNumber - 1).getListOfActors());

                break;
            case 2:
                if (listOfOperas.isEmpty()) {
                    System.out.println("Добавьте спектакль!");
                    return;
                }
                System.out.println("Выберите номер оперы:");
                for (int i = 0; i < listOfOperas.size(); i++) {
                    System.out.print("Опера под номером " + (i + 1) + ": " + listOfOperas.get(i));
                    System.out.println();
                }
                showNumber = scanner.nextInt();
                if ((showNumber - 1) > listOfOperas.size() || (showNumber - 1) < 0) {
                    System.out.println("Неверный номер!");
                    return;
                }
                System.out.println(listOfOperas.get(showNumber - 1).getListOfActors());
                break;
            case 3:
                if (listofBallet.isEmpty()) {
                    System.out.println("Добавьте спектакль!");
                    return;
                }
                System.out.println("Выберите номер балета:");
                for (int i = 0; i < listofBallet.size(); i++) {
                    System.out.print("Балет под номером " + (i + 1) + ": " + listofBallet.get(i));
                    System.out.println();
                }
                showNumber = scanner.nextInt();
                if ((showNumber - 1) > listofBallet.size() || (showNumber - 1) < 0) {
                    System.out.println("Неверный номер!");
                    return;
                }
                System.out.println(listofBallet.get(showNumber - 1).getListOfActors());
                break;
            default:
                System.out.println("Неверный ввод команды!");
        }
    }


}








