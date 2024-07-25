public class B02_PseudoCode {
    public static void main(String[] args) {

        int n =33; // zahl zum überprüfen obs Primzahl ist;

        boolean primzahl = true; // ob es Primzahl ist, wir gehen von true aus

        //for (int k = 1; k <= n/2; k++) { //denn eine Zahl ist nicht durch mehr als
                                            // die Hälfte ihrer selbst teilbar
        for (int k = 2; k <= Math.sqrt(n)&& primzahl; k++) { //da ein größer Faktor von n ein Vielfaches
                                            // eines kleineren Faktors sein muss, der bereits geprüft wurde
            if (n%k == 0 ) // keine Primzahl -> beende innere for-Schleife

                primzahl = false;

        }
        if (primzahl)
            System.out.println("Ist Primzahl");
        else
            System.out.println("Ist keine Primzahl");

    }
}
