import java.util.Scanner;

public class B01_CleanThisV1 {
    public static void main(String[] args) {
        boolean withAdult = true;
        int age = 6;
        boolean VIP = false;
            if (age >= 18) {
                System.out.println("Grünes Band");
            } else if (age >= 16) {
                System.out.println("Gelbes Band");
            } else if (age>=4 && withAdult) {
                System.out.println("Rotes Band");
            } else {
                System.out.println("Kein Zutritt");
            }
            if (VIP && ((withAdult && age>=4) || age>=16)) {
                System.out.println("Goldenes Band dazu!");
            }
            else if (age>=16 || (withAdult && age>=4)){
                System.out.println("Kein goldenes Band dazu!");
            }
    }
}
