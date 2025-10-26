import java.util.Objects;

public class Director extends Person {
    private int numberOfShows;

    public Director(String name, String surName, Genders gender,int numberOfShows) {
        super(name, surName, gender);
        this.numberOfShows = numberOfShows;
    }



    @Override
    public String toString() {
        return "Режиссёр: " + getName()+ " " + getSurName() +", количество поставленных спектаклей: " + numberOfShows;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Director director = (Director) o;
        return (Objects.equals(getName(), director.getName()) && Objects.equals(getSurName(), director.getSurName()) &&
                numberOfShows == director.numberOfShows);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(numberOfShows);
    }
}
