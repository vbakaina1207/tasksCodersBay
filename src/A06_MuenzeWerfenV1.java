import java.util.Random;

public class A06_MuenzeWerfenV1 {
    public static void main(String[] args) {
        Random r = new Random();

        boolean kopf = r.nextBoolean(); // zufälliger Wert von true oder false

        if (kopf) {
            System.out.println("Die Münze ist auf Kopf gelandet – ich gewinne.");
        } else {
            System.out.println("Die Münze ist auf Kopf gelandet – ich gewinne.");
        }
    }
}
