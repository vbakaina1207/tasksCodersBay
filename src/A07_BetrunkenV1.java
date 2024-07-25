import java.util.Scanner;

public class A07_BetrunkenV1 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Wie viel Bier hast du getrunken?");
        int bear = sc.nextInt();
        System.out.println("Wie viel Shots hast du getrunken?");
        int shots = sc.nextInt();;
        int drink = bear + shots;

        if (drink == 0) {
            System.out.println("gar nicht betrunken");
        } else
            if (drink < 3) {
                System.out.println("leicht betrunken");
            } else
                if (bear <= 6 && shots == 0) {
                    System.out.println("Betrunken");
                } else {
                    System.out.println("Hoffnungslos betrunken");
                }
    }

}
