import java.util.ArrayList;
import java.util.Scanner;

public class RPGV1 {
    public static void main(String[] args) {
        String[][] choices = {
                // {parentID, ID, choiceTxt, resultTxt, moveToID }
                {"-1", "0", "", "Du stehst in einer Bar."},

                {"0", "1", "Geh in die Wildnis", "Du bist in der Wildnis angekommen."},
                {"0", "2", "Trink ein Getränk", "Du lässt dir ein Getränk schmecken", "0"},

                {"1", "3", "Kämpf gegen das Monster", "Das Monster ist ein harter Gegner, aber du besiegst es.", "1"},
                {"1", "4", "Lauf vor dem Monster davon", "Du läufst wie ein Feigling zurück zur Bar.", "0"},
        };
        int currentChoice = 0;
        ArrayList<Integer> viableChoices = new ArrayList<>();
        boolean isGame = true;
        int moveToID = -2;
        boolean isContains = false;

        Scanner sc = new Scanner(System.in);
        while (isGame) {
            for (int i = 0; i < choices.length; i++) {
                if (currentChoice == Integer.parseInt(choices[i][1])) {
                    if (choices[i].length == 5) {
                        moveToID = Integer.parseInt(choices[i][4]);
                    }
                    else {
                        moveToID = -1;
                    }
                    System.out.println();
                    System.out.printf("%-25s \n", choices[i][3]);
                    if(Integer.parseInt(choices[i][0]) == moveToID)
                        continue;
                    System.out.println("-------------------------------");
                } else if (currentChoice == Integer.parseInt(choices[i][0]) ) {
                    System.out.printf("%-3s %-25s \n", choices[i][1], choices[i][2]);
                    if (!viableChoices.contains(Integer.parseInt(choices[i][1])))
                        viableChoices.add(Integer.parseInt(choices[i][1]));
                }
            }
            if (moveToID > -1) {
                for (int j = 0; j < choices.length; j++) {
                    if(moveToID == Integer.parseInt(choices[j][1])) {
                        System.out.println();
                        System.out.printf("%-25s \n", choices[j][3]);
                        System.out.println("-------------------------------");
                    }
                    if (Integer.parseInt(choices[j][0]) == moveToID) {
                        System.out.printf("%-3s %-25s \n", choices[j][1], choices[j][2]);
                        viableChoices.add(Integer.parseInt(choices[j][1]));
                    }
                }
            }

            System.out.println("-------------------------------");
            isContains = false;
            while (!isContains) {
                System.out.println("Was willst du als nächstes tun?");
                currentChoice = sc.nextInt();
                if (viableChoices.contains(currentChoice))
                    isContains = true;
                else {
                    System.out.println("Sie haben eine nicht vorhandene Option ausgewählt. Bitte wiederholen Sie Ihre Auswahl.");
                    isContains = false;
                }
            }
            viableChoices.clear();
        }
    }
}
