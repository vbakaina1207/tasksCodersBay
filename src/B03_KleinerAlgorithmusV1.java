public class B03_KleinerAlgorithmusV1 {
    public static void main(String[] args) {
        int a = 1;
        int b = 1;
        int c = 0;
        for (int i=1; i<=5; i++) {
            c = a + b;
            System.out.println(a +" + " + b + " = " + c);
            a = b;
            b = c;
        }
    }
}
