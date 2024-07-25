public class A02_TaschenRechnerV1 {
    public static void main(String[] args) {
        int a = 5;
        int b = 7;
        double d = (double)a / b;

        System.out.println("Erste Variable: " + a);
        System.out.println("Zweite Variable: " + b);
        System.out.println(a +" + " + b +" = " + (a + b));
        System.out.println(a + " - " + b + " = " + (a - b));
        System.out.println(a + " * " + b + " = " + (a * b));
        System.out.println(a + " / " + b + " = " + d);
        System.out.println(a + " % " + b + " = " + (a%b));
    }
}
