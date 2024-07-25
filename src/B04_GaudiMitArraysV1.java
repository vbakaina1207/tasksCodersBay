import java.util.Arrays;
import java.util.Random;

public class B04_GaudiMitArraysV1 {
    public static void main(String[] args) {
        int[] a = {1,2,3,4,5,6,7,8,9,0};
        boolean[] c = new boolean[10];
        Random r = new Random();
        int[] b = new int[100];
        for (int x = 0; x < b.length; x++) {
            b[x] = r.nextInt(101);
            System.out.println(b[x]);
        }
        System.out.println(Arrays.toString(c));
        c[0] = true;
        for (int i = 2; i < c.length; i+=2) {
             c[i] = true;
            //System.out.println(c[i]);
        }
        System.out.println(Arrays.toString(c));


    }

}
