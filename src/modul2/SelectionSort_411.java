package modul2;

import java.util.Arrays;

public class SelectionSort_411 {
    public static void main(String[] args) {
        int[] items = {7,18,9,4,17,2,14,8};
//funktioniert besser, wenn das Array stark unsortiert ist
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

        System.out.println(Arrays.toString((items)));

    }
}
