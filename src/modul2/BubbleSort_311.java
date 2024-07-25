package modul2;

import java.util.Arrays;

public class BubbleSort_311 {
    public static void main(String[] args) {
        int max;
        int[] arr = {7,18,9,4,17,2,14,8};

        /*Man startet also mit der ersten Zahl und vergleicht diese dann mit ihrem direkten Nachbarn
        nach dem Sortierkriterium. Sollten beide Elemente nicht in der richtigen Reihenfolge sein, werden
        sie ganz einfach miteinander vertauscht. Danach wird direkt das nächste Paar miteinander verglichen,
        bis die gesamte Liste einmal durchlaufen wurde. Die Phase wird so oft wiederholt,
        bis der gesamte Array vollständig sortiert ist.*/

        System.out.println((Arrays.toString((arr))));
        for (int n = arr.length - 1; n >= 0; n--) {
            for (int i = 0; i<n; i++) {
                if (arr[i] > arr[i+1]) {
                    max = arr[i];
                    arr[i] = arr[i+1];
                    arr[i+1] = max;
                }
            }
        }

        System.out.println((Arrays.toString((arr)) ));

    }
}
