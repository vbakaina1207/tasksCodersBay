import java.util.Scanner;

public class A08_BetrunkenV2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Wie alt bist du?");
        int age = sc.nextInt();
        System.out.println("Hast du deinen Führerschein dabei?");
        boolean fuhrerschein = sc.nextBoolean();
        System.out.println("Wie viel Bier hast du getrunken?");
        int beer = sc.nextInt();
        System.out.println("Wie viel Shots hast du getrunken?");
        int shots = sc.nextInt();
        sc.close();
        int drink = beer + shots;

        if ((age < 17 || !fuhrerschein) || (age < 19 && drink > 0) || (age >= 19 && drink > 2))  {
            System.out.println("Du darfst Auto nicht fahren");
        } else {
            System.out.println("Du darfst Auto  fahren");
        }
    }


}
