package show;

import person.Person;



public class Ballet extends MusicalShow {
    private Person choreographer;

    public Ballet(String title, int duration, Person musicAuthor,
                  String librettoText, Person choreographer) {
        super(title, duration, musicAuthor, librettoText);
        this.choreographer = choreographer;
    }

    public Person getChoreographer() {
        return choreographer;
    }

    public void setChoreographer(Person choreographer) {
        this.choreographer = choreographer;
    }
}
