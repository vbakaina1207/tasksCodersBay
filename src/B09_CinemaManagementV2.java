import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class B09_CinemaManagementV2 {
    public static void main(String[] args) {
        String[][] films = {
                {"1", "Batman", "20:15", "1", "2"},
                {"2", "Matrix", "22:00", "3", "3"},
                {"3", "Matrix2", "17:00", "2", "0"}
        };

        String[][] snacks = {
                {"1", "Popcorn ", "1.00", "10"},
                {"2", "Chips ", "2.00", "15"},
                {"3", "Schokolade  ", "3.50", "20"},
        };

        String[][] active = {
                {"1", "Ticket kaufen"},
                {"2", "Snacks kaufen"},
                {"3", "Film ansehen"},
                {"4", "Snacks essen"},
                {"5", "Beim Gewinnspiel mitmachen (kostet 5€)"},
                {"6", "Kino verlassen"}
        };
        double summa = 0;
        int choice = -1;
        ArrayList<String> listeFilm = new ArrayList<>();
        ArrayList<String> listeSnaks = new ArrayList<>();

        Scanner myObj = new Scanner(System.in);
        while (summa < 15) {
            System.out.println("Wie viel Geld hast du?");
            summa = myObj.nextDouble();
            if (summa <= 0) {
                System.out.println("Der Geldbetrag darf keine negative Zahl sein.");
            } else if (summa < 15) {
                System.out.println("Sie haben nicht genug Geld.!");
            }
        }

        while (choice!=0 ) {
            while (choice < 0 || choice > 6) {
                System.out.println("Was willst du als nächstes tun? (Du hast noch " + String.format("%4.1f", summa) + " €)");
                activeTabele(active);
                choice = myObj.nextInt();
                if (choice < 0 || choice > 6)
                    System.out.println("Die Zahl muss im Berich von 1 bis 6 liegen. Treffen Sie Ihre Wahl bitte noch einmal.");
            }
            if (choice == 1) {
                summa = filmsKaufen(films, summa, listeFilm);
                choice= -1;
            } else if (choice == 2) {
                summa = snacks(snacks, summa, listeSnaks);
                choice= -1;
            } else if (choice == 3) {
                filmAnsehen(listeFilm, films);
                choice= -1;
            } else if (choice == 4) {
                snacksEssen(listeSnaks, snacks);
                choice= -1;
            } else if (choice == 5) {
                summa = gewinnspiel(summa);
                choice= -1;
            } else if (choice == 6) {
                choice = kinoVerlassen();

            }

        }
   }
    private static double filmsKaufen (String[][] films, double summa, ArrayList<String> liste){

        int numFilm=-1;
        int curFilm = -1;
        int allTickets = 0;
        int curTicket = 0;
        int costTicket = 15;
        double rest = 0;
        boolean isChoice = true;

        filmsTabele( films);

        Scanner myObj = new Scanner(System.in);

        while (numFilm != 0) {
                System.out.println("Welchen (nicht ausgebuchten) Film möchtest du sehen? (0 zum abbrechen)");
                numFilm = myObj.nextInt();
                for (int i = 0; i < films.length && isChoice; i++) {
                    if (Integer.parseInt(films[i][0]) == numFilm) {
                        curFilm = i;
                        System.out.println(curFilm + " curFilm " + numFilm + " numFilm");
                        isChoice = false;
                    }
                }
                if (curFilm >= 0 && numFilm > 0) {
                    allTickets = Integer.parseInt(films[curFilm][4]);
                    if (allTickets > 0) {
                        do {
                            System.out.println("Es sind noch " + films[curFilm][4] + " Tickets um jeweils 15€ dafür verfügbar. Wie viele möchtest du kaufen?");
                            curTicket = myObj.nextInt();
                            if (curTicket<=0)
                                System.out.println("Der Ticketsbetrag darf keine negative Zahl sein.");
                            } while( curTicket<=0);
                        rest = summa - curTicket * costTicket;
                        if (curTicket <= Integer.parseInt(films[curFilm][4]) && summa >= rest && rest>=0) {
                            summa = rest;
                            System.out.println("Du kaufst " + curTicket + " Tickets um " + curTicket * costTicket + "€ und hast jetzt noch " + String.format("%7.1f", rest) + " €");
                            films[curFilm][4] = String.valueOf(Integer.parseInt(films[curFilm][4]) - curTicket);
                            while (curTicket > 0) {
                                liste.add(String.valueOf(numFilm));
                                curTicket--;
                            }
                            System.out.println("Sie haben Tickets für folgende Filme gekauft:" + liste);
                            if (rest >= 15) {
                                filmsTabele(films);
                            }
                            if (summa<=0) {
                                if (summa<=0) System.out.println("Sie haben nicht genug Geld.");
                                System.out.println("Drucken Sie bitte 0 zum abbrechen");
                                numFilm = myObj.nextInt();
                            }
                        } else
                        if (curTicket <= Integer.parseInt(films[curFilm][4]) && summa >= rest && rest<0) {
                            System.out.println("Sie haben mehr Tickets ausgewählt als Geld haben.");
                        } else
                        if (curTicket <= Integer.parseInt(films[curFilm][4]) && summa < 15) {
                            System.out.println("Sie haben nicht genug Geld.");
                        } else
                        if (curTicket > Integer.parseInt(films[curFilm][4])) {
                            System.out.println("Sie haben mehr Tickets ausgewählt als verfügbar sind.");
                        }
                    } else if (allTickets == 0) {
                        curFilm = -1;
                        System.out.println("Alle Karten für diesen Film sind ausverkauft. Bitte wählen Sie einen anderen Film.");
                    }
                } else if (curFilm == -1 && numFilm != 0) {
                    System.out.println("Es gibt keinen solchen Film.");
                }

            isChoice = true;
        }

        System.out.println("Sie haben Tickets für folgende Filme gekauft:");
        System.out.println(liste);
        for (int j = 0; j < liste.size(); j++)
            for (int i = 0; i < films.length; i++) {
                if (String.valueOf(liste.get(j)).equals(films[i][0]))
                    System.out.println(films[i][1]);
            }

        return summa;
    }
    private static void filmsTabele(String[][] films) {
        System.out.printf("| %-3s | %-18s | %-10s | %-10s | %-18s |", "Filmnr", "Filmname", "Uhrzeit"," Saal", "Restplätze");
        System.out.println();
        System.out.println("-----------------------------------------------------------------------");
        for (int i = 0; i < films.length; i++) {
            for (int j = 0; j < films[i].length; j++) {
                if(j==0)
                    System.out.printf("| %-3s | " , films[i][j] );
                else if (j==1)
                    System.out.printf(" %-18s | " , films[i][j] );
                else if (j==2 || j==3)
                    System.out.printf(" %-10s | " , films[i][j] );
                else if (j == 4 ) {
                    if(Integer.parseInt(films[i][4]) == 0) {
                        System.out.printf( "%-18s |","ausgebucht");
                    }  else
                        System.out.printf("%-18s |","verfügbar");
                } else
                    System.out.print(films[i][j] + "  " + "\t");
            }
            System.out.println();
        }
        System.out.println("-----------------------------------------------------------------------");
    }

    private static void snacksTabele(String[][] active) {
        System.out.printf("| %-3s | %-18s | %-7s | %-17s |", "Nr ", "Snack", "Preis "," Auf lager?");
        System.out.println();
        System.out.println("-------------------------------------------------------");
        for (int i = 0; i < active.length; i++) {
            for (int j = 0; j < active[i].length; j++) {
                if(j==0)
                    System.out.printf("| %-3s | " , active[i][j] );
                else if (j==2)
                    System.out.printf("%8.2f |"	, Double.parseDouble(active[i][j]));
                else if (j==1)
                    System.out.printf("%-18s |"	, active[i][j]);
                else if (j == 3 ) {
                    if(Integer.parseInt(active[i][3]) == 0) {
                        System.out.printf("%-18s |"	,"  nicht auf Lager");
                    }  else
                        System.out.printf("%-18s |"	,"  auf Lager");
                }
            }
            System.out.println();
        }
        System.out.println("------------------------------------------------------");
    }

    private static void activeTabele(String[][] arr) {
        System.out.printf("| %-3s | %-38s |", "Nr ", "Activität");
        System.out.println();
        System.out.println("-----------------------------------------------");
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if(j==0)
                    System.out.printf("| %-3s | " , arr[i][j] );
                else if (j==1)
                    System.out.printf("%-38s |"	, arr[i][j]);

            }
            System.out.println();
        }
        System.out.println("-----------------------------------------------");
    }

    private static double snacks(String[][] snacks, double summa, ArrayList<String> selectedSnacks) {
        int numSnack = -1;
        int curSnack = -1;
        boolean isChoice = true;
        int allSnacks = 0;
        double rest = 0;
        int curNum = 0;

        snacksTabele(snacks);
        Scanner myObj = new Scanner(System.in);

        while (numSnack != 0) {
                System.out.println("Welchen (noch vorhandenen) Snack möchtest du kaufen? (0 zum abbrechen)?)");
                numSnack = myObj.nextInt();
                for (int i = 0; i < snacks.length && isChoice; i++) {
                    curSnack = snacks[i][0].indexOf(String.valueOf(numSnack));
                    if (Integer.parseInt(snacks[i][0]) == numSnack) {
                        curSnack = i;
                        isChoice = false;
                    }
            }
            if(curSnack >= 0){
                allSnacks = Integer.parseInt(snacks[curSnack][3]);
                System.out.println(allSnacks + " allSnacks");
                if (allSnacks > 0) {
                    do {
                        System.out.println("Es sind noch " + snacks[curSnack][3] + " "+ snacks[curSnack][1] +"  um jeweils " + snacks[curSnack][2]+ "€ dafür verfügbar. Wie viele möchtest du kaufen?");
                        curNum  = myObj.nextInt() ;
                        if (curNum<0)
                            System.out.println("Der Snacksbetrag darf keine negative Zahl sein.");
                    } while( curNum<0);
                    rest = summa - curNum * Double.parseDouble(snacks[curSnack][2]);
                    System.out.println(curNum + " curNum");
                    if (curNum <= Integer.parseInt(snacks[curSnack][3]) && summa >= rest && rest>=0) {
                        summa = rest;
                        System.out.println(Double.parseDouble(snacks[curSnack][2]));
                        System.out.println("Du kaufst " + curNum +  " " + snacks[curSnack][1] +" um " + String.format("%7.2f",  (curNum * Double.parseDouble(snacks[curSnack][2])))+ "€ und hast jetzt noch " + String.format("%7.2f", rest) + " €");
                        snacks[curSnack][3] = String.valueOf(Integer.parseInt(snacks[curSnack][3]) - curNum);
                        while (curNum > 0) {
                            selectedSnacks.add(String.valueOf(numSnack));
                            curNum--;
                        }
                        System.out.println("Sie haben " + snacks[curSnack][1] + " gekauft:" );
                        System.out.println(selectedSnacks);

                        if (rest >= 15) {
                            snacksTabele(snacks);
                        }
                        if (summa<=0) {
                            if (summa<=0) System.out.println("Sie haben nicht genug Geld.");
                            System.out.println("Drucken Sie bitte 0 zum abbrechen");
                            numSnack = myObj.nextInt();
                        }
                    } else
                    if (curNum <= allSnacks && summa >= rest && rest<0) {
                        System.out.println("Sie haben mehr Snackss ausgewählt als Geld haben.");
                    } else
                    if (curNum <= allSnacks && summa <= 0) {
                        System.out.println("Sie haben nicht genug Geld.");
                    } else
                    if (curNum > allSnacks) {
                        System.out.println("Sie haben mehr Snacks ausgewählt als verfügbar sind.");
                    }
                } else if (allSnacks == 0) {
                    System.out.println("Alle "  + " sind ausverkauft. Bitte wählen Sie einen anderen Snacks.");
                    curSnack = -1;
                }
            } else if (curSnack == -1 && numSnack != 0) {
                System.out.println("Es gibt keinen solchen Snack.");
            }
            isChoice = true;
        }

        System.out.println("Sie haben  folgende Snacks gekauft:" );
        System.out.println(selectedSnacks);

        return summa;
        }

    private static void filmAnsehen(ArrayList<String> listFilm, String[][] films){

        List<String> myUniqueList = new ArrayList<>(listFilm.stream().distinct().toList());

        Scanner myObj = new Scanner(System.in);
        int curFilm = -1;
        String nameFilm = "";
        int countFilm = 1;
        int countAll = 0;
        boolean isFilm = true;

        while (curFilm != 0) {
            System.out.println("Welchen Film (für den du noch ein Ticket hast) möchtest du sehen? (0 für abbrechen)?");
            for (int j = 0; j < myUniqueList.size(); j++) {
                for (int i = 0; i < films.length; i++) {
                    if (String.valueOf(myUniqueList.get(j)).equals(films[i][0]))
                        System.out.println(myUniqueList.get(j) + " " + films[i][1]);
                }
            }

            curFilm = myObj.nextInt();
            if (curFilm<0)
                System.out.println("Filmnummer darf nicht negativ sein");

            for (int i = 0; i < listFilm.size() && isFilm; i++) {
                if (listFilm.get(i).equals(String.valueOf(curFilm))) {
                    isFilm = false;
                }
            }
            if(isFilm) {
                if (curFilm!=0)  {
                    curFilm=-1;
                    System.out.println("Sie haben keine Eintrittskarte für diesen Film");
                }
            }

            for (int i = 0; i < films.length; i++) {
                if (String.valueOf(curFilm).equals(films[i][0])) {
                    nameFilm = films[i][1];
                }
            }
            isFilm=true;

            if (curFilm > 0) {
                while (countFilm > countAll) {
                    System.out.println("Wie oft werden Sie den Film heute sehen?");
                    for (int i = 0; i < listFilm.size(); i++) {
                        if (listFilm.get(i).equals(String.valueOf(curFilm))) {
                            for (int j = 0; j < films.length; j++) {
                                if (String.valueOf(listFilm.get(i)).equals(films[j][0])) {
                                    System.out.println(listFilm.get(i) + " " + films[j][1]);
                                    countAll++;
                                }
                            }
                        }
                    }

                    countFilm = myObj.nextInt();
                    if (countFilm < 0)
                        System.out.println("Das ist negative Zachl! ");
                    if (countFilm > countAll)
                        System.out.println("Du hast mehr Tickets gewonnen, als verfügbar sind.");

                }
                if (countFilm <= countAll && countFilm>=0) {
                    for (int i = 0; i < listFilm.size(); i++) {
                        if (listFilm.get(i).equals(String.valueOf(curFilm))) {
                            while (countFilm != 0) {
                                listFilm.remove(listFilm.get(i));
                                countFilm--;
                            }
                        }
                    }

                    int n = 0;
                    for (int i = 0; i < listFilm.size(); i++) {
                        if (listFilm.get(i).equals(String.valueOf(curFilm))) {
                            for (int j = 0; j < films.length; j++) {
                                if (String.valueOf(listFilm.get(i)).equals(films[j][0])) {
                                    System.out.println(listFilm.get(i) + " " + films[j][1]);
                                    n++;
                                }
                            }
                        }
                    }
                    System.out.print("Man kann den Film " + nameFilm + " Film so oft anschauen: ");
                    System.out.println(n);
                    if (n == 0) {
                        System.out.println("Für den Film " + nameFilm + " sind keine Tickets mehr verfügbar");
                        for (int j = 0; j < myUniqueList.size(); j++) {
                            if (String.valueOf(myUniqueList.get(j)).equals(String.valueOf(curFilm)))
                                myUniqueList.remove(j);
                        }
                    }
                    countFilm = 1;
                    countAll = 0;
                }

            }

        }

    }

    private static void snacksEssen(ArrayList<String> listSnacks, String[][] snacks){

        List<String> myUniqueList = new ArrayList<>(listSnacks.stream().distinct().toList());

        Scanner myObj = new Scanner(System.in);
        int curSnack = -1;
        String nameSnack = "";
        int countSnack = 1;
        int countAll = 0;
        boolean isSnack = true;

        while (curSnack != 0) {
            System.out.println("Welchen deiner Snacks willst du essen? (0 für abbrechen)?");
            for (int j = 0; j < myUniqueList.size(); j++) {
                for (int i = 0; i < snacks.length; i++) {
                    if (String.valueOf(myUniqueList.get(j)).equals(snacks[i][0]))
                        System.out.println(myUniqueList.get(j) + " " + snacks[i][1]);
                }
            }
            curSnack = myObj.nextInt();
            if (curSnack<0)
                System.out.println("Snacksnummer darf nicht negativ sein");

            for (int i = 0; i < listSnacks.size() && isSnack; i++) {
                if (listSnacks.get(i).equals(String.valueOf(curSnack))) {
                    isSnack = false;
                }
            }
            if(isSnack) {
                if (curSnack!=0)  {
                    curSnack=-1;
                    System.out.println("Sie haben keine Snacks diesen Art.");
                }
            }

            for (int i = 0; i < snacks.length; i++) {
                if (String.valueOf(curSnack).equals(snacks[i][0])) {
                    nameSnack = snacks[i][1];
                }
            }
            isSnack=true;

            if (curSnack > 0) {
                while (countSnack >= countAll){
                    System.out.println("Wie oft werden Sie den Snaks essen?");
                for (int i = 0; i < listSnacks.size(); i++) {
                    if (listSnacks.get(i).equals(String.valueOf(curSnack))) {
                        for (int j = 0; j < snacks.length; j++) {
                            if (String.valueOf(listSnacks.get(i)).equals(snacks[j][0])) {
                                System.out.println(listSnacks.get(i) + " " + snacks[j][1]);
                                countAll++;
                            }
                        }
                    }
                }

                countSnack = myObj.nextInt();
                if (countSnack < 0)
                    System.out.println("Das ist negative Zachl! ");
                if (countSnack > countAll)
                    System.out.println("Du hast mehr Snacks gewonnen, als verfügbar sind.");
            }
                if (countSnack < countAll && countSnack>=0) {
                    System.out.println("Du verspeist " + countSnack + " " + nameSnack + ". Mjam!");
                    for (int i = 0; i < listSnacks.size(); i++) {
                        if (listSnacks.get(i).equals(String.valueOf(curSnack))) {
                            while (countSnack != 0) {
                                listSnacks.remove(listSnacks.get(i));
                                countSnack--;
                            }
                        }
                    }

                    int n = 0;
                    for (int i = 0; i < listSnacks.size(); i++) {
                        if (listSnacks.get(i).equals(String.valueOf(curSnack))) {
                            for (int j = 0; j < snacks.length; j++) {
                                if (String.valueOf(listSnacks.get(i)).equals(snacks[j][0])) {
                                    System.out.println(listSnacks.get(i) + " " + snacks[j][1]);
                                    n++;
                                }
                            }
                        }
                    }
                    System.out.println("Du hast noch " + n + " " + nameSnack);
                    if (n == 0) {
                        System.out.println("Du hast die ganze " + nameSnack + " gegesen.");
                        for (int j = 0; j < myUniqueList.size(); j++) {
                            if (String.valueOf(myUniqueList.get(j)).equals(String.valueOf(curSnack)))
                                myUniqueList.remove(j);
                        }
                    }
                }
            }
            countSnack = 1;
            countAll = 0;
        }

    }

    private static double gewinnspiel(double summa){
        System.out.println("Du machst beim Gewinnspiel mit!");
        Random r = new Random();

        int num = r.nextInt(201);
        System.out.println("Deine Glückszahl ist: " + num);
        boolean isWin = false;
        int a = 1;
        int b = 1;
        int c = 0;
        if(num == 1 || num%10 == 0)  {
            summa += 20;
            System.out.println(num + " ist durch 10 teilbar! Du gewinnst 20€!");
            isWin = true;
        } else {
            while (num<=c && !isWin){
                c = a + b;
                if (num == c) {
                    System.out.println(a + " + " + b + " = " + c);
                    System.out.println(num + " ist eine Fibonacci-Nummer! Du gewinnst 20€!");
                    summa += 20;
                    isWin = true;
                }
                a = b;
                b = c;

            }
        }
        if(!isWin) {
            System.out.println(num + " ist KEINE Fibonacci-Nummer! Leider nicht gewonnen.");
            summa -= 5;
        }
        if (summa<=0)
            System.out.println("Sie haben kein Geld.");
        System.out.println("Sie haben " + summa + "€");
        return summa;
    }

    private  static int kinoVerlassen(){
        System.out.println("Du verlässt das Kino. Auf wiedersehen!");
        return  0;
    }
}

