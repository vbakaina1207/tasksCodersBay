import java.util.Random;
import java.util.Scanner;

public class A09_MuenzeWerfenV2 {
    public static void main(String[] args) {
        Random r = new Random();
        boolean kopf;
        int sumKopf = 0;
        int sumZahl = 0;

        Scanner sc = new Scanner(System.in);
        System.out.println("Wie oft muss man eine Münze werfen?");
        int countAll = sc.nextInt();
        sc.close();
        //int countAll = 5;
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
            System.out.println("Ich gewinne- ich bekomme das Ticket.");
        } else  if (sumZahl > sumKopf){
            System.out.println("Stefan gewinnt.");
        } else {
            System.out.println("Unentschieden");
        }
    }
}
