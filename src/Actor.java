import java.util.Objects;

public class Actor extends Person {
    private double height; // Рост в см

    public Actor(String name, String surName, Genders gender, double height) {
        super(name, surName, gender);
        this.height = height;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Actor actor = (Actor) o;
        return (Objects.equals(getName(), actor.getName()) && Objects.equals(getSurName(), actor.getSurName())
        && height == actor.height);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(height);
    }

    @Override
    public String toString() {
        return "Актёр: " + getName() + " " + getSurName() + " (рост = " + height +")";
    }
}
