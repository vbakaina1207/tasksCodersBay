import java.util.Scanner;

public class A10_TaschenrechnerV3 {
    public static void main(String[] args) {
        int a;
        int b;

        Scanner sc = new Scanner(System.in);
        char operator = 'k';

        while (operator != 'x') {

            System.out.println("Gib den Operator (+, -, *, /, %) ein. (x für Abbruch):");

            operator = sc.nextLine().charAt(0);

            if ((operator =='+') || (operator=='-') || (operator=='*') || (operator=='/') || (operator=='%'))  {
                System.out.println("Gib die erste Zahl ein:");
                a = sc.nextInt();
                System.out.println("Gib die zweite Zahl ein:");
                b = sc.nextInt();
                sc.nextLine();

                if (operator == '+') {
                    System.out.println(a + " + " + b + " = " + (a + b));
                }
                else if (operator == '-') {
                    System.out.println(a + " - " + b + " = " + (a - b));
                }
                else if (operator == '*') {
                    System.out.println(a + " * " + b + " = " + (a * b));
                }
                else if (operator == '/') {
                    System.out.println(a + " / " + b + " = " + (a / b));
                }
                else  {   //operator=='%'
                    System.out.println(a + " % " + b + " = " + (a % b));
                }


            } else if (operator!='x') {
                System.out.println("Dieser Operator ist falsch");
            }


        }

    }
}
