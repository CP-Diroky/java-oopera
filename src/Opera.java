import java.util.ArrayList;
import java.util.Scanner;

public class Opera extends MusicalShow {
    private int choirSize;

    public Opera(String title, int duration, Scanner scanner, Person musicAuthor,
                 String librettoText, int choirSize) {
        super(title, duration,scanner, musicAuthor, librettoText);
        this.choirSize = choirSize;
    }
}
