package modul1;

import java.util.Scanner;

public class B211_PropertieOfANumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int nummer;
        int myNummer = 8;
        System.out.println("Meiner Glückszahl ist " + myNummer);
        System.out.println("Geben Sie die Nummer ein:");
        nummer = sc.nextInt();
        if(nummer%2 == 0)
            System.out.println("Die nummer ist gerade");
        else
            System.out.println("Die nummer ist umgerade");
        if (nummer%10 == 0)
            System.out.println("Die nummer ist eine runde Zahl");
        else
            System.out.println("Die nummer ist keine runde Zahl");
        if (myNummer == nummer)
            System.out.println(" Deiner Zahl entspricht meiner Glückszahl: " + nummer + " = " + myNummer);
        else
            System.out.println(" Deiner Zahl entspricht nict meiner Glückszahl: " + nummer + " <> " + myNummer);
        if(nummer>9 && nummer<100)
            System.out.println("Die Zahl " + nummer + " ist zweistellig");
        else
            System.out.println("Die Zahl " + nummer + " ist nicht zweistellig");
    }
}
