import java.util.Random;
import java.util.Scanner;

public class A11_MuenzeWerfenV3 {
    public static void main(String[] args) {
        Random r = new Random();
        boolean kopf;
        int sumKopf = 0;
        int sumZahl = 0;
        int countAll;
        Scanner sc = new Scanner(System.in);

        /* bis der Benutzer eine sinnvolle Zahl eingibt */
        do {
            System.out.println("Wie oft soll die Münze geworfen werden (ungerade Zahl 1-10)?");
            countAll = sc.nextInt();
        } while ((countAll<1 || countAll>10) || countAll%2==0);

        sc.close();

        for (int i = 1; i <= countAll; i++) {
            kopf = r.nextBoolean();
            if (kopf) {
                System.out.println("Werfe Münze… Kopf!");
                sumKopf++;
            } else {
                System.out.println("Werfe Münze… Zahl!");
                sumZahl++;
            }
        }
        System.out.println("Summe Kopf: " + sumKopf);
        System.out.println("Summe Zahl: " + sumZahl);
        if (sumZahl < sumKopf) {
            System.out.println("ich gewinne.");
        } else  if (sumZahl > sumKopf){
            System.out.println("Stefan gewinnt.");
        }
    }
}
