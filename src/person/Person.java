package person;

public class Person {
    protected String name;
    protected String surName;
    protected Genders gender;

    public Person(String name, String surName, Genders gender) {
        this.name = name;
        this.surName = surName;
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public String getSurName() {
        return surName;
    }

}
