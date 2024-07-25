public class A00_HelloWorld {
    public static void main(String[] args) {
        int a=7;
        int b=3;
        System.out.println(a);
        System.out.println("a ist " + a);
        System.out.println(a+b);
        System.out.println("Ergebnis " +(a+b));
        System.out.println(b);
        b++;
        System.out.println(b);

        int z1 = 10;
        int z2;
        while (z1 > -10) {
            for (z2 = 1; z2 < 10; z2 = z2 * 2) {
                System.out.println(z1 + "/" + z2);
            }
            z1 = z1  - z2;
            System.out.println(z1);
        }
    }
}
