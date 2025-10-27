package show;

import person.Person;



public class Opera extends MusicalShow {
    private int choirSize;

    public Opera(String title, int duration, Person musicAuthor,
                 String librettoText, int choirSize) {
        super(title, duration, musicAuthor, librettoText);
        this.choirSize = choirSize;
    }

    public int getChoirSize() {
        return choirSize;
    }

    public void setChoirSize(int choirSize) {
        this.choirSize = choirSize;
    }
}
