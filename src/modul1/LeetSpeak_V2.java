package modul1;

import java.util.Hashtable;
import java.util.Scanner;

public class LeetSpeak_V2 {
    public static void main(String[] args) {
        Hashtable<Character,Character> hashtable = new Hashtable<>();
        char[] alphabet = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};
        char[] letter = {'@', '8', '(', 'D', '3', 'F', '6', '#', '!', 'J', 'K', '1', 'M', 'N', '0', 'P', 'Q', 'R', '$', '7', 'U', 'V', 'W', 'X', 'Y', '2'};

        StringBuilder newText = new StringBuilder();

        for(int i=0; i< alphabet.length; i++){
            hashtable.put(alphabet[i], letter[i]);
        }

        Scanner sc = new Scanner(System.in);
        System.out.println("Geben Sie bitte einen Text:");
        String text = sc.nextLine().toUpperCase();
        char[] symbol = text.toCharArray();

        for(int i=0; i< symbol.length; i++){
            if(hashtable.containsKey(symbol[i])){
                symbol[i] = hashtable.get(symbol[i]);
            }
            newText.append(symbol[i]);
        }
        System.out.println(newText);
    }
}
