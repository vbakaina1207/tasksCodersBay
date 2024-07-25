import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class B08_KinoVerwaltungV1 {
    public static void main(String[] args) {
        String[][] films = {
                {"1", "Batman", "20:15", "1", "2"},
                {"2", "Matrix", "22:00", "3", "3"},
                {"3", "Matrix2", "17:00", "2", "0"}
        };
        int summa = 0;
        int numFilm=-1;
        int curFilm = -1;
        int allTickets = 0;
        int curTicket = 0;
        int sumTicket = 0;
        int costTicket = 15;
        int rest = 0;
        boolean isFeller = true;
        ArrayList liste = new ArrayList();

        tabele( films);
        Scanner myObj = new Scanner(System.in);

        while (summa < 15) {
            System.out.println("Wie viel Geld hast du?");
            summa = myObj.nextInt();
            if (summa <= 0) {
                System.out.println("Der Geldbetrag darf keine negative Zahl sein.");
            } else if (summa < 15) {
                System.out.println("Sie haben nicht genug Geld.!");
            }
        }
        while (numFilm != 0) {
            if (isFeller) {
                System.out.println("Welchen (nicht ausgebuchten) Film möchtest du sehen? (0 zum abbrechen)");
                numFilm = myObj.nextInt();
                //String elemen = String.valueOf(numFilm);
                for (int i = 0; i < films.length; i++) {
                    curFilm = films[i][0].indexOf(String.valueOf(numFilm));
                    if (Integer.parseInt(films[i][0]) == numFilm) {
                        curFilm = i;
                        break;
                    }
                }
                if (curFilm >= 0) {
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
                            System.out.println("Du kaufst " + curTicket + " Tickets um " + curTicket * costTicket + "€ und hast jetzt noch " + String.format("%7.1f", (double)rest) + " €");
                            films[curFilm][4] = String.valueOf(Integer.parseInt(films[curFilm][4]) - curTicket);
                            while (curTicket > 0) {
                                liste.add(numFilm);
                                curTicket--;
                            }
                            System.out.println("Sie haben Tickets für folgende Filme gekauft:" + liste);

                            if (rest >= 15) {
                                tabele(films);
                                isFeller = true;
                            }
                            if (!isFeller || summa<=0) {
                                if (summa<=0) System.out.println("Sie haben nicht genug Geld.");
                                System.out.println("Drucken Sie bitte 0 zum abbrechen");
                                numFilm = myObj.nextInt();
                            }
                        } else
                            if (curTicket <= Integer.parseInt(films[curFilm][4]) && summa >= rest && rest<0) {
                            System.out.println("Sie haben mehr Tickets ausgewählt als Geld haben.");
                            isFeller = true;
                        } else
                            if (curTicket <= Integer.parseInt(films[curFilm][4]) && summa <= 0) {
                            System.out.println("Sie haben nicht genug Geld.");
                            isFeller = true;
                        } else
                            if (curTicket > Integer.parseInt(films[curFilm][4])) {
                            System.out.println("Sie haben mehr Tickets ausgewählt als verfügbar sind.");
                            isFeller = true;
                        }
                    } else if (allTickets == 0) {
                        curFilm = -1;
                        System.out.println("Alle Karten für diesen Film sind ausverkauft. Bitte wählen Sie einen anderen Film.");
                        isFeller = true;
                    }
                } else if (curFilm == -1 && numFilm != 0) {
                    System.out.println("Es gibt keinen solchen Film.");
                }
            }
        }

        System.out.println("Sie haben Tickets für folgende Filme gekauft:");
        System.out.println(liste);
        for (int j = 0; j < liste.size(); j++){
            for (int i = 0; i < films.length; i++) {
                if(String.valueOf(liste.get(j)).equals(films[i][0]))
                    System.out.println(films[i][1]);
            }
        }
    }

    private static void tabele(String[][] films) {
        System.out.println("Filmnr " + " Filmname   " + "   Uhrzeit  " + " Saal " + " Restplätze ");
        for (int i = 0; i < films.length; i++) {
            for (int j = 0; j < films[i].length; j++) {
                if (j == 4 ) {
                    if(Integer.parseInt(films[i][4]) == 0) {
                        System.out.println("ausgebucht");
                    }  else
                        System.out.println("verfügbar");
                } else
                    System.out.print(films[i][j] + "  " + "\t");
            }
            System.out.println();
        }
    }
}
