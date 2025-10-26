import java.util.ArrayList;
import java.util.Scanner;

public class Ballet extends MusicalShow {
    private Person choreographer;

    public Ballet(String title, int duration, Scanner scanner, Person musicAuthor,
                  String librettoText, Person choreographer) {
        super(title, duration, scanner, musicAuthor, librettoText);
        this.choreographer = choreographer;
    }
}
