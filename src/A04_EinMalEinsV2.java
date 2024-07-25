import java.util.Scanner;

import static java.lang.Integer.parseInt;

public class A04_EinMalEinsV2 {
    public static void main(String[] args) {
        int b = 1;
        Scanner myObj = new Scanner(System.in);
        System.out.println("Welche Reihe soll ausgegeben werden?");
        int a = myObj.nextInt();

        System.out.println(b + " * " + a + " = " + (a * b++));
        System.out.println(b + " * " + a + " = " + (a * b++));
        System.out.println(b + " * " + a + " = " + (a * b++));
        System.out.println(b + " * " + a + " = " + (a * b++));
        System.out.println(b + " * " + a + " = " + (a * b++));
        System.out.println(b + " * " + a + " = " + (a * b++));
        System.out.println(b + " * " + a + " = " + (a * b++));
        System.out.println(b + " * " + a + " = " + (a * b++));
        System.out.println(b + " * " + a + " = " + (a * b++));
        System.out.println(b + " * " + a + " = " + (a * b++));

        myObj.close();
    }
}
