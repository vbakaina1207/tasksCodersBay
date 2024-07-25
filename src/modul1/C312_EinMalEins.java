package modul1;

public class C312_EinMalEins {
    public static void main(String[] args) {
        for (int i = 1; i<=10; i++) {
            for (int n = 1; n<=10; n++) {
                System.out.println(i + " * " + n + " = " + (i * n));
            }
            System.out.println();
            System.out.println((i+1)+"er Reihe:");
        }
    }
}
