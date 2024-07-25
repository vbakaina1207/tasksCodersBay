import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class C02_CyberSecurityV1 {
    public static void main(String[] args) {

        String symbolText = "ABCabc012!";
        char symbols[] = symbolText.toCharArray();
        ArrayList<String> combos = new ArrayList<>();
        String pw = "";
        int tries = 0;
        Random r = new Random();

        for (int i = 0; i < 4; i++) {
            int index = r.nextInt(0, symbols.length);
            pw += symbols[index];
        }
        System.out.println(pw + " password1");
        //pw = "" + symbols[r.nextInt(symbols.length)] + symbols[r.nextInt(symbols.length)] + symbols[r.nextInt(symbols.length)] + symbols[r.nextInt(symbols.length)];

// generate the combinations

        for (int i = 0; i < symbols.length ; i++) {
            for (int j = 0; j < symbols.length ; j++) {
                for (int k = 0; k < symbols.length ; k++) {
                    for (int l = 0; l < symbols.length ; l++) {
                        String pwCombo = "" + symbols[i] + symbols[j] + symbols[k] + symbols[l];
                        combos.add(pwCombo);
                        System.out.println(pwCombo);

                    }
                }
            }
        }


        System.out.println("Sie haben " + combos.size() + " Versuche unternommen.");
        System.out.println(pw + " - original pass. ");

        do {
            tries++;
            if (combos.get(tries).equals(pw))
                System.out.println("Sie haben " + tries + " Versuche gebraucht, um das Password zu erraten!" +"\n" + pw + " - original pass. " + "\n" +  combos.get(tries) + " - knacken pass. ");
        } while (!combos.get(tries).equals(pw));

        // randomly generate a password until it matches
        tries = 0;
        int min = 0;
        int max = 0;
        String pwGuess = "";
        int summa = 0;

        for(int i=0; i<=1000; i++) {
            pwGuess = "" + symbols[r.nextInt(symbols.length)] + symbols[r.nextInt(symbols.length)] + symbols[r.nextInt(symbols.length)] + symbols[r.nextInt(symbols.length)];
            for(String pwToGuess : combos) {
                tries++;
                if (pwGuess.equals(pwToGuess)) {
                    System.out.println("Password: " + pwToGuess + "\n" + "Found it: " + pwToGuess + " == " + pwGuess + "\n" + "Took " + tries + " guesses");
                    if(min==0) min = tries;
                    if (min > tries)
                        min = tries;
                    else if(max < tries)
                        max = tries;
                    summa+=tries;
                }
            }
            tries = 0;
        }
        int avr = summa/1000;
        System.out.println("On average took " +  avr + " guesses each time. Best case was " + min + " guesses, worst case was "+ max +" guesses.");
    }
}
