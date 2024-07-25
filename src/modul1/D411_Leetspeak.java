package modul1;

import java.util.Arrays;
import java.util.Scanner;

public class D411_Leetspeak {
    public static void main(String[] args) {
        char[] alphabet = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};
        char[] letter = {'@', '8', '(', 'D', '3', 'F', '6', '#', '!', 'J', 'K', '1', 'M', 'N', '0', 'P', 'Q', 'R', '$', '7', 'U', 'V', 'W', 'X', 'Y', '2'};
        StringBuilder newText = new StringBuilder();

        Scanner sc = new Scanner(System.in);
        System.out.println("Geben Sie bitte einen Text:");
        String text = sc.nextLine().toUpperCase();
        char[] symbol = text.toCharArray();
        for (int i =0; i< symbol.length; i++){
            for (int j =0; j< alphabet.length; j++){
                if(symbol[i] == alphabet[j]){
                    symbol[i] = letter[j];
                }
            }
            newText.append(symbol[i]);
        }
        System.out.println(newText);
    }
}
