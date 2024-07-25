package modul2;

import java.util.Arrays;

public class InsertionSort_211 {
    public static void main(String[] args) {
// bei kleiner oder schon teilweise vorsortierten Eingabemengen sehr effizient arbeitet
         int[] nummer = {5,2,9,4,8,0, 2} ;
         int temp;
         int j; // unsorted
        //erste ja bereits als sortiert gilt
       for(int i = 1; i<nummer.length; i++){
           temp = nummer[i];
           j=i;
           // Element nach links verschieben, bis es an der richtigen Position ist
           while (j>0 && nummer[j-1]> temp){
               nummer[j] = nummer[j - 1];
               j --;
           }
           nummer[j] = temp;
       }
        System.out.println(Arrays.toString(nummer));
    }
}
