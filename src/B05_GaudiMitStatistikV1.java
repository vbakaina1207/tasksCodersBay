public class B05_GaudiMitStatistikV1 {
    public static void main(String[] args) {
        String text = "Unter #Handy finden sich 6 große Anbieter, 2 davon sind aber die besten!";
        char[] symbol = text.toCharArray();
        int sumZahl = 0;
        int sumUpper = 0;
        int sumLower = 0;
        int sumSymbol = 0;
        for (int i = 0; i < symbol.length; i++) {
            if (symbol[i]>='0' && symbol[i]<='9') {
                sumZahl++;
            } else if (symbol[i]>=65 && symbol[i]<=90) {
                sumUpper++;
            } else if (symbol[i]>=97 && symbol[i]<=122) {
                sumLower++;
            } else sumSymbol++;
        }
        System.out.println("Content: " + text);
        System.out.println("Großbuchstaben: " + sumUpper);
        System.out.println("Kleinbuchstaben:" + sumLower);
        System.out.println("Zahlen: " + sumZahl);
        System.out.println("Sonstige Zeichen: " + sumSymbol);
    }
}
