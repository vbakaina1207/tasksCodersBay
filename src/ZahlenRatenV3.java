import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class ZahlenRatenV3 {
    public static void main(String[] args) {
        int lvl = -1;

        Scanner sc = new Scanner(System.in);

        while (lvl!=0 ) {
            while (lvl < 0 || lvl > 4) {
                System.out.println("Auf welhem Niveau möchtest du spielen? (1, 2, 3 oder 4 spielen will oder mit 0 abbrechen)");
                lvl = sc.nextInt();
                if (lvl < 0 || lvl > 4) {
                    System.out.println("Die Niveauzahl muss im Berich von 1 bis 4 liegen. Treffen Sie Ihre Wahl bitte noch einmal.");
                }
            }
            if (lvl == 1) {
                lvl = lvl1 ();
            } else if (lvl == 2) {
                lvl = lvl2 ();
            } else if (lvl == 3) {
                lvl = lvl3 ();
            } else if (lvl == 4) {
                lvl = lvl4 ();
            }
        }
    }

    private  static int lvl1 () {
        Random r = new Random();
        int num = r.nextInt(101);
        int maxVersuche = 9;
        int versuche = 0;
        int input = -1;
        boolean isNewGame = false;
        boolean isWinn = true;
        int level = 0;
        int gros  = 100;
        int klein = 0;

        Scanner sc = new Scanner(System.in);
        while(input < 0 || input > 100) {
            System.out.println("Rate eine Zahl zwischen 0 b1s 100.");
            input = sc.nextInt();
            if (input < 0 || input > 100)
                System.out.println("Die Zahl muss im Berich von 0 bis 100 liegen. Treffen Sie Ihre Wahl bitte noch einmal.");
        }

        while (versuche <= maxVersuche && input != num) {
            versuche++;
            if (input != num) {
                if (versuche < 9)
                    System.out.println("Sie haben noch " + (maxVersuche - versuche) + " von " + maxVersuche + " Versuchen übrig.");
                if (input < num && versuche < 9) {
                    klein = input;
                    System.out.println("Zahl zu klein. Nocheinmal:");
                    System.out.println("Probieren Sie bitte mit "+ (input + gros)/2 + " oder andere Zahl  zwischen "+input+" und "+ gros);
                    input = sc.nextInt();
                } else if (input > num && versuche < 9) {
                    gros  = input;
                    System.out.println("Zahl zu gros. Nocheinmal:");
                    System.out.println("Probieren Sie bitte mit " + (klein + input)/2 + " oder andere Zahl zwischen "+klein+" und "+ input) ;
                    input = sc.nextInt();
                    while(input<0 || input>100) {
                        if (input < 0 || input > 100)
                            System.out.println("Die Zahl muss im Berich von 0 bis 100 liegen. Treffen Sie Ihre Wahl bitte noch einmal.");
                        System.out.println("Nocheinmal:");
                        input = sc.nextInt();
                    }
                }
                if (versuche == 9 ) {
                    isWinn = false;
                    System.out.println("Sie haben noch " + (maxVersuche - versuche) + " von " + maxVersuche + " Versuchen übrig.");
                    System.out.println("Du verlierst!");
                }
            }
        }
        if (isWinn) {
            System.out.println("Erraten mit " + versuche + " Versuchen.");
            System.out.println("Möchtest du nocheinmal schpielen?  (false oder true)");
            isNewGame = sc.nextBoolean();
            if (isNewGame) {
                level = -1;
            }
            else if (!isNewGame)
                level = 0;
        }
        return level;
    }

    private  static int lvl2 () {
        Random r = new Random();
        int num = r.nextInt(101);
        int maxVersuche = 9;
        int versuche = 0;
        int input = -1;
        boolean isNewGame = false;
        boolean isWinn = true;
        int level = 0;
        int diff = 0;

        Scanner sc = new Scanner(System.in);
        while(input < 0 || input > 100) {
            System.out.println("Rate eine Zahl zwischen 0 b1s 100.");
            input = sc.nextInt();
            if (input < 0 || input > 100)
                System.out.println("Die Zahl muss im Berich von 0 bis 100 liegen. Treffen Sie Ihre Wahl bitte noch einmal.");
        }
        while (versuche <= maxVersuche && input != num) {
            versuche++;
            if (input != num) {
                if (versuche < 9) {
                    diff = Math.abs(num - input);
                    System.out.println("Sie haben noch " + (maxVersuche - versuche) + " von " + maxVersuche + " Versuchen übrig.");
                    if( diff > 20)
                        System.out.println("Zahl ist weit weg. Zahl >20 daneben");
                    else if (diff >= 11)
                        System.out.println("Zahl ist nicht ganz so weit weg“: zwischen 11 und 20 daneben");
                    else if(diff >= 4)
                        System.out.println("Zahl ist relativ nahe: zwischen 4 und 10 daneben");
                    else if(diff >= 1)
                        System.out.println("Zahl ist fast da: zwischen 1 und 3 daneben.");
                    System.out.println("Nocheinmal:");
                    input = sc.nextInt();
                    while(input<0 || input>100) {
                        if (input < 0 || input > 100)
                            System.out.println("Die Zahl muss im Berich von 0 bis 100 liegen. Treffen Sie Ihre Wahl bitte noch einmal.");
                        System.out.println("Nocheinmal:");
                        input = sc.nextInt();
                    }
                }
                if (versuche == 9 ) {
                    isWinn = false;
                    System.out.println("Sie haben noch " + (maxVersuche - versuche) + " von " + maxVersuche + " Versuchen übrig.");
                    System.out.println("Du verlierst!");
                }
            }
        }
        if (isWinn) {
            System.out.println("Erraten mit " + versuche + " Versuchen.");
            System.out.println("Möchtest du nocheinmal schpielen? (false oder true)");
            isNewGame = sc.nextBoolean();
            if (isNewGame) {
                level = -1;
            }
            else if (!isNewGame)
                level = 0;
        }
        return level;
    }

    private  static int lvl3 () {
        Random r = new Random();
        int secretNumber = r.nextInt(101);
        int versuche = 0;
        int guess = -1;
        boolean isNewGame = false;
        boolean isWinn = true;
        int level = 0;
        boolean isComp = false;
        int max  = 100;
        int min = 0;
        boolean isZugComp = false;
        boolean isZug = false;
        String nameGamer = "";
        ArrayList<Integer> listeSchpieler1 = new ArrayList<>();
        ArrayList<Integer> listeSchpieler2 = new ArrayList<>();

        Scanner sc = new Scanner(System.in);

        isComp = r.nextBoolean();
        System.out.println("======================");
        System.out.println("------- New game -----");
        System.out.println("======================");
        if(isComp) {
            System.out.println("\u001B[34m Der Computer spielt zuerst.");
            guess = r.nextInt(101);
            listeSchpieler1.add(guess);
            isZugComp = true;
        }
        else {
            System.out.println("\u001B[34m Du spielt zuerst.");
            guess = numberCheck(guess,  " Rate eine Zahl zwischen 0 b1s 100.");
            listeSchpieler2.add(guess);
            isZug=true;
        }
        nameGamer = nameGamer(isZug, isZugComp);
        System.out.printf(" %s schlage %d vor\n", nameGamer, guess);
        System.out.printf(" %s hat(hast) solche Tipps bereits gegeben: %s \n", nameGamer, isZugComp? listeSchpieler1 : listeSchpieler2);
        while (guess != secretNumber) {
            versuche++;
            if (guess != secretNumber) {
                if (guess < secretNumber) {
                    if(min < guess)
                        min = guess;
                    System.out.println("\u001B[31m Feedback: Zahl zu klein. Nocheinmal bitte:");
                } else if (guess > secretNumber) {
                    if (max > guess)
                        max = guess;
                    System.out.println("\u001B[31m Feedback: Zahl zu gros. Nocheinmal:");
                }
                if (isZug) {
                    guess = (min + max)/2;
                    System.out.printf("\u001B[34m Der Computer schlage %d vor\n", guess);
                    listeSchpieler1.add(guess);
                } else if (isZugComp) {
                    guess = sc.nextInt();
                    guess = numberCheck(guess, "");
                    listeSchpieler2.add(guess);
                }
                System.out.println("\u001B[33m Probieren Sie bitte mit " + (min + max)/2 + " oder andere Zahl  zwischen "+ min +" und "+ max);
                nameGamer = nameGamer(isZugComp, isZug);
                System.out.printf("\u001B[33m %s (hat)hast solche Tipps bereits gegeben: %s \n",nameGamer, isZugComp? listeSchpieler2 : listeSchpieler1);
                isZug = !isZug;
                isZugComp = !isZugComp;
            }
        }
        if (isWinn) {
            System.out.println("\u001B[36m WINN!!!");
            System.out.println("\u001B[36m Erraten mit " + versuche + " Versuchen.");
            System.out.println("\u001B[35m Möchtest du nocheinmal schpielen? (false oder true)");
            isNewGame = sc.nextBoolean();
            if (isNewGame) {
                level = -1;
            }
            else if (!isNewGame)
                level = 0;
        }
        return level;
    }

    private  static int lvl4 () {
        Random r = new Random();
        int secretNumber = r.nextInt(101);
        int versuche = 0;
        int guess = -1;
        boolean isNewGame = false;
        boolean isWinn = true;
        int level = 0;
        boolean isComp = false;
        int max  = 100;
        int min = 0;
        boolean isZugComp = false;
        boolean isZug = false;
        int diff = 0;
        String nameGamer = "";
        int from = 0;
        int to = 100;
        int rand = -1;
        ArrayList<Integer> guessList = new ArrayList<>();
        ArrayList<Integer> listeSchpieler1 = new ArrayList<>();
        ArrayList<Integer> listeSchpieler2 = new ArrayList<>();
        ArrayList<Integer> randomList = new ArrayList<>();


        Scanner sc = new Scanner(System.in);
        isComp = r.nextBoolean();
        System.out.println("\u001B[35m ============================================");
        System.out.println("\u001B[35m ------------------ New game ----------------");
        System.out.println("\u001B[35m ============================================");
        if(isComp) {
            System.out.println("\u001B[34m Der Computer spielt zuerst.");
            guess = r.nextInt(101);
            listeSchpieler1.add(guess);
            isZugComp = true;
        }
        else {
            System.out.println("\u001B[34m Du spielt zuerst.");
            guess = numberCheck(guess,  " Rate eine Zahl zwischen 0 b1s 100.");
            listeSchpieler2.add(guess);
            isZug=true;
        }
        nameGamer = nameGamer(isZug, isZugComp);
        System.out.printf(" %s schlage %d vor\n", nameGamer, guess);
        System.out.printf(" %s hat(hast) solche Tipps bereits gegeben: %s \n", nameGamer, isZugComp? listeSchpieler1 : listeSchpieler2);
        for(int i = 0; i<=100; i++) {
            guessList.add(i);
        }

        while (guess != secretNumber) {
            versuche++;
            if (guess != secretNumber) {
                diff = Math.abs(secretNumber - guess);
                if( diff > 20) {
                    System.out.println("\u001B[34m Zahl ist weit weg. Zahl >20 daneben");
                    min = guess - 20;
                    max = guess + 20;
                    for(int i = min; i<= max; i++) {
                        guessList.remove(Integer.valueOf(i));
                    }
                }
                else {
                    if (diff >= 11) {
                        System.out.println("\u001B[34m Zahl ist nicht ganz so weit weg“: zwischen 11 und 20 daneben");
                        min = guess - 20;
                        max = guess + 20;
                        from = guess - 11;
                        to = guess + 11;
                    } else if (diff >= 4) {
                        System.out.println("\u001B[35m Zahl ist relativ nahe: zwischen 4 und 10 daneben");
                        min = guess - 10;
                        max = guess + 10;
                        from = guess - 4;
                        to = guess + 4;
                    } else if (diff >= 1) {
                        System.out.println("\u001B[36m Zahl ist fast da: zwischen 1 und 3 daneben.");
                        min = guess - 3;
                        max = guess + 3;
                        from = guess - 1;
                        to = guess + 1;
                    }
                    for(int i = 0; i< min; i++) {
                        guessList.remove(Integer.valueOf(i));
                    }
                    for(int i = max+1; i<= 100; i++) {
                        guessList.remove(Integer.valueOf(i));
                    }
                    for(int i = from+1; i< to; i++) {
                        guessList.remove(Integer.valueOf(i));
                    }
                }
                guessList.remove((Integer.valueOf(guess)));
                randomList = randomNummer(guessList);
                System.out.println("\u001B[33m Probieren Sie bitte mit " + randomList + " von " );
                System.out.println(guessList);
                if (isZug) {
                    int randomIndex = r.nextInt(randomList.size());
                    guess = randomList.get(randomIndex);
                    System.out.printf("\u001B[34m Der Computer schlage %d vor\n", guess);
                    listeSchpieler1.add(guess);
                } else if (isZugComp) {
                    System.out.println("\u001B[31m Nocheinmal bitte:");
                    guess = sc.nextInt();
                    guess = numberCheck(guess, "");
                    listeSchpieler2.add(guess);
                }
                nameGamer = nameGamer(isZugComp, isZug);
                System.out.printf("\u001B[33m %s (hat)hast solche Tipps bereits gegeben: %s \n",nameGamer, isZugComp? listeSchpieler2 : listeSchpieler1);
                isZug = !isZug;
                isZugComp = !isZugComp;
            }
        }
        if (isWinn) {
            System.out.println("\u001B[36m WINN!!!");
            System.out.println("\u001B[36m Erraten mit " + versuche + " Versuchen.");
            System.out.println("\u001B[35m Möchtest du nocheinmal schpielen? (false oder true)");
            isNewGame = sc.nextBoolean();
            if (isNewGame) {
                level = -1;
            }
            else if (!isNewGame)
                level = 0;
        }
        return level;
    }

    private  static int  numberCheck (int guess,  String guessText) {
        Scanner sc = new Scanner(System.in);
        while(guess < 0 || guess > 100){
            if (!guessText.equals(""))
                System.out.println(guessText);
            if (guess < 0 || guess > 100)
                System.out.println("Die Zahl muss im Berich von 0 bis 100 liegen. Treffen Sie Ihre Wahl bitte noch einmal.");
            guess = sc.nextInt();
        }
        return guess;

    }

    private static String nameGamer (boolean isZugComp, boolean isZug) {
        String nameGamer = "";
        if (isZug)
            nameGamer = "Der Computer";
        else if (isZugComp)
            nameGamer = "Du";
        return  nameGamer;
    }

    private static ArrayList<Integer> randomNummer (ArrayList<Integer> zahlen) {
        Random r = new Random();
        int rand = 0;
        int next ;
        int [] fromTo = new int[2];
        int from ;
        int to = 0;
        ArrayList<int[]> areaFromTo = new ArrayList<>();
        ArrayList<Integer> guessList = new ArrayList<>();

        from = zahlen.get(Integer.valueOf(0));
        for(int i = 0; i< zahlen.size()-1; i++) {
            to = zahlen.get(Integer.valueOf(i));
            next = zahlen.get(Integer.valueOf(i+1));
            if(next != to + 1 || to == zahlen.get(Integer.valueOf(zahlen.size()-1))) {
                fromTo[0] = from;
                fromTo[1] = to;
                areaFromTo.add(new int[]{from, to});
                from = zahlen.get(Integer.valueOf(i+1));
            }
        }
        fromTo[0] = from;
        fromTo[1] = to+1;
        if (from == zahlen.get(Integer.valueOf(zahlen.size()-1)))
            fromTo[1] = from;
        areaFromTo.add(fromTo);

        for(int[] guess : areaFromTo) {
            rand = (guess[0]+guess[1])/2;
            guessList.add(rand);
        }
        return guessList;
    }
}
