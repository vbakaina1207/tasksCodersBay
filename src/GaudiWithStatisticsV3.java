import java.util.Arrays;
import java.util.Random;

public class GaudiWithStatisticsV3 {
    public static void main(String[] args) {
        Random r = new Random();
        double avr = 0;
        int count = 0;
        int summa = 0;

        /* selection sort */

        int[] items = new int[100];
        for (int x = 0; x < items.length; x++) {
            items[x] = r.nextInt(101);
        }
        System.out.println(Arrays.toString((items)));
        for (int i = 0; i<items.length; i++) {
            int indexMin = i;
            for (int j = i + 1; j < items.length; j++) {
                if (items[j] < items[indexMin]) {
                    indexMin = j;
                }
            }
            int temporary = items[i];
            items[i] = items[indexMin];
            items[indexMin] = temporary;
        }

        System.out.println("Aufsteigend sortiert:");
        System.out.println(Arrays.toString((items)) + " selection sort");
        System.out.println("Arithmetisches Mittel:");

        /* Bubble sort */

        int max;
        int[] arr = new int[100];
        for (int x = 0; x < arr.length; x++) {
            arr[x] = r.nextInt(101);
        }
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

        System.out.println((Arrays.toString((arr)) + " Bubble sort"));

    }
}
