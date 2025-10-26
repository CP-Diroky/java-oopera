import java.util.ArrayList;
import java.util.Scanner;

public class MusicalShow extends Show {
    private Person musicAuthor;
    private String librettoText;

    public MusicalShow(String title, int duration, Scanner scanner, Person musicAuthor,
                       String librettoText) {
        super(title, duration,scanner);
        this.musicAuthor = musicAuthor;
        this.librettoText = librettoText;
    }


    public String getLibrettoText() {
        return librettoText;
    }


}
