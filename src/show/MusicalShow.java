package show;

import person.Person;



public class MusicalShow extends Show {
    private Person musicAuthor;
    private String librettoText;

    public MusicalShow(String title, int duration, Person musicAuthor,
                       String librettoText) {
        super(title, duration);
        this.musicAuthor = musicAuthor;
        this.librettoText = librettoText;
    }


    public String getLibrettoText() {
        return librettoText;
    }


}
