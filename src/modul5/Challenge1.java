package modul5;

import java.util.ArrayList;
import java.util.Scanner;

public class Challenge1 {
    public static void main(String[] args) {
        ArrayList<Integer> items = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        String input = "";
        int nummer = 0;
        int max = Integer.MIN_VALUE;
        int temp = 0;

        char [] charNummer = input.toCharArray();
        while(!input.toLowerCase().equals("q")) {
            boolean isNummer = true;
            System.out.println("Geben Sie bitte die Zahl. (q ist der Ausgang)");
            input = sc.nextLine();
            charNummer = input.toLowerCase().toCharArray();
            for (int i = 0; i < charNummer.length && isNummer; i++) {
                if(charNummer[i] < 48 || charNummer[i] > 57) {
                    if(!(charNummer[0] == 43 || charNummer[0] == 45 )) {
                        if(charNummer[i]!='q')
                            System.out.println("Sie geben keine Zahl");
                        isNummer = false;
                    }
                }
            }
            if (isNummer) {
                nummer = Integer.valueOf(input);
                items.add(nummer);
                if(nummer > max)
                    max = nummer;
            }
        }
        System.out.println("---------------");
        for(int i = 0; i < items.size(); i++){
            if(items.get(i) == max)
                System.out.println(items.get(i) + " < == Höchstzahle");
            else
                System.out.println(items.get(i));
        }
        System.out.println("---------------");
    }
}
