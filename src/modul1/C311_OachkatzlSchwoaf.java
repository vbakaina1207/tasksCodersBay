package modul1;

import java.util.Scanner;

public class C311_OachkatzlSchwoaf {
    public static void main(String[] args) {
        int nummer = 1;

        while (nummer<101){
            if(nummer%3==0 && nummer%5==0)
                System.out.println("OachkatzlSchwoaf(" + nummer + ")! ");
            else if (nummer%3==0) {
                System.out.println("Oachkatzl(" + nummer + ")! ");
            } else if (nummer%5==0) {
                System.out.println("Schwoaf(" + nummer + ")! ");
            } else System.out.println(nummer);
            nummer++;
        }
    }
}
