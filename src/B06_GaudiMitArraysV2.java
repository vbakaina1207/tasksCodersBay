import java.lang.reflect.Array;
import java.util.Arrays;

public class B06_GaudiMitArraysV2 {
    public static void main(String[] args) {
        //String text = "Unter #Handy finden sich 6 große Anbieter, 2 davon sind aber die besten!";
        String text = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        char[] symbol = text.toCharArray();
        int howMuch = -3;
        char[] symbolTemp = new char[Math.abs(howMuch)];
        int m = 0;
        char elem ;
        char temp;

        if (howMuch >= 0) {
            for (int i=0; i<howMuch; i++){
                symbolTemp[i] = symbol[i];
            }
            for(int i=0; i<symbol.length-howMuch;i++) {
                symbol[i] = symbol[i+howMuch];
            }
            for (int j = symbol.length-howMuch; j < symbol.length; j++) {
                        symbol[j] = symbolTemp[m];
                        m++;
            }
            System.out.println(Arrays.toString(symbol) + " - 1");

        } else
        if (howMuch < 0) {
            //howMuch= Math.abs(howMuch);
            for (int i=0; i<Math.abs(howMuch); i++){
                symbolTemp[i] = symbol[symbol.length-Math.abs(howMuch)+i];
            }
            for (int i = symbol.length-1; i >=Math.abs(howMuch) ; i--) {
                symbol[i] = symbol[i-Math.abs(howMuch)];
            }
            for (int j = 0; j < Math.abs(howMuch); j++) {
                symbol[j] = symbolTemp[m];
                m++;
            }
            System.out.println(Arrays.toString(symbol)+ " - 2");
        }




    String text1 =  "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        char[] original = text1.toCharArray();
        char[] tempArr = new char[original.length];
        int newPos;

        if (howMuch >= 0) {

            for(int i=0; i<original.length;i++) {
                newPos = (howMuch+i)%original.length;
                tempArr[newPos] = original[i] ;
            }
            System.out.println(Arrays.toString(tempArr)+" - 3");
        } else

        if (howMuch < 0) {

            for(int i=original.length-1; i>=0;i--) {
                newPos = (original.length + howMuch+i)%original.length;
                tempArr[newPos] = original[i] ;
            }
            System.out.println(Arrays.toString(tempArr)+ " - 4");
        }

        String text2 ="ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        char[] symbol2  = text2.toCharArray();

        if (howMuch >= 0) {
            for (int i = 0; i < symbol2.length - howMuch; i++) {
                symbol2[i] += howMuch;
            }
            for (int i = symbol2.length - 1; i >= symbol2.length - howMuch; i--) {
                symbol2[i] -= 26 - howMuch;
            }
            System.out.println(Arrays.toString(symbol2) + " - 5 ");
        } else if (howMuch<0) {
            howMuch = -howMuch;
            for(int i=symbol2.length-1; i>= howMuch; i--){
                symbol2[i] -= howMuch;
            }

            for(int i = 0; i<howMuch ; i++){
                symbol2[i] += 26 - howMuch;
            }
            System.out.println(Arrays.toString(symbol2)+ " - 6");
        }

    }
}
