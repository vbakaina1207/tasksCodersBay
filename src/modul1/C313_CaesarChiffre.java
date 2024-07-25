package modul1;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class C313_CaesarChiffre {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random r = new Random();
        System.out.println("Geben Sie bitte einen Text: ");
        String text = sc.nextLine();
        char[] symbol = text.toCharArray();
        int shift = 3;// r.nextInt(27);
        StringBuilder newText = new StringBuilder();
        int newPos = 0;

        for (int i=0;i<symbol.length; i++){
            if(symbol[i] !=' ') {
                if (symbol[i]>=65 && symbol[i]<=90) {
                    if ((symbol[i] + shift)>90) {
                        newPos = (symbol[i] + shift) % 90;
                        symbol[i] = (char) (newPos + 64);
                    }
                    else
                        symbol[i] += shift;
                } else if (symbol[i]>=97 && symbol[i]<=122) {
                    if ((symbol[i] + shift)>122) {
                        newPos = (symbol[i] + shift) % 122;
                        symbol[i] = (char) (newPos + 96);
                    } else
                        symbol[i] += shift;
                }
            }
            newText.append(symbol[i]);
        }
        System.out.println("Der Schlüssel ist " + shift);
        System.out.println("verschlüsselten String ist \n"+newText);
    }
}
