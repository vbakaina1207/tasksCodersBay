package modul1;

import com.sun.jdi.Value;

import java.util.ArrayList;
import java.util.Scanner;

public class C321_Maximum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> nummerList = new ArrayList<>();
        int inputNummer = Integer.MIN_VALUE;
        String input = "";
        char[] symbol = input.toCharArray();
        int max;
        boolean isNummer = true;

        max = inputNummer;
        while (!"q".equals(input.toLowerCase())) {
            System.out.println("Geben Sie bitte nexte Zahl:");
            input = sc.nextLine();
            symbol = input.toCharArray();

            for (int i=0; i<symbol.length && isNummer; i++) {
                if (symbol[i] < 48 || symbol[i] > 57) {
                        if(!(symbol[0] == 43 || symbol[0] == 45 )) {
                        System.out.println("Sie geben keine Zahl.");
                        isNummer = false;
                    }
                }
            }
            if (isNummer){
                inputNummer = Integer.parseInt(input);
                nummerList.add(inputNummer);
                if (inputNummer > max)
                    max = inputNummer;
            }
            isNummer = true;
        }
        System.out.println("das Maximum von " + nummerList + " ist " + max) ;
    }


}
