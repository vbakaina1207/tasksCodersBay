import java.util.Random;
import java.util.Scanner;

public class A13_MuenzeWerfenV4 {
    public static void main(String[] args) {
        Random r = new Random();
        boolean kopf;
        int sumKopf = 0;
        int sumAllKopf = 0;
        int sumZahl = 0;
        int sumAllZahl = 0;
        int countAll = 0;
        int werfen = 0;
        boolean result = false;
        int werfenAll = 0;

        Scanner sc = new Scanner(System.in);

        /* Das Ganze geht so lange weiter, bis bei der Frage zu der Zufriedenheit „true“ eingegeben wird.*/

        do {

            /* wirf eine Münze, bis die Gesamtzahl ungerade wird */

            while (werfen < 1 || werfen > 10 || werfenAll % 2 == 0) {
                System.out.println("Wie oft soll die Münze geworfen werden (ungerade Zahl 1-10),Insgesamt ungerade?");
                werfen = sc.nextInt();
                werfenAll = countAll + werfen;
                if (werfen < 11 && werfen > 0 && werfenAll % 2 != 0)
                    countAll += werfen;
            }

            /* man wirft werfen-mal eine Münze */

            for (int i = 1; i <= werfen; i++) {
                kopf = r.nextBoolean();
                if (kopf) {
                    System.out.println("Werfe Münze… Kopf!");
                    sumKopf++;
                } else {
                    System.out.println("Werfe Münze… Zahl!");
                    sumZahl++;
                }
            }
            sumAllKopf += sumKopf;
            sumAllZahl += sumZahl;
            System.out.println("Summe Kopf: " + sumKopf);
            System.out.println("Summe Zahl: " + sumZahl);
            System.out.println("Bist du mit dem Ergebnis zufrieden?");
            result = sc.nextBoolean();
            werfen = 0;  // setz die Anzahl der Würfe zurück
        } while (!result);

        if (sumZahl < sumKopf) {
            System.out.println("ich gewinne.");
        } else  if (sumZahl > sumKopf){
            System.out.println("Stefan gewinnt.");
        }
        sc.close();
    }
}
