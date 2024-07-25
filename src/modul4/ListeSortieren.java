package modul4;

import java.util.ArrayList;
import java.util.Arrays;

import static java.util.Arrays.asList;

public class ListeSortieren {
    public static void main(String[] args) {
        ArrayList<Integer> items = new ArrayList<>(Arrays.asList(7, 18, 9, 4, 17, 2, 14, 8));
//funktioniert besser, wenn das Array stark unsortiert ist
        for (int i = 0; i < items.size(); i++) {
            int indexMin = i;
            for (int j = i + 1; j < items.size(); j++) {
                if (items.get(j) < items.get(indexMin)) {
                    indexMin = j;
                }
            }
            int temporary = items.get(i);
            items.set(i, items.get(indexMin));
            items.set(indexMin, temporary);
        }

        System.out.println((items));


    }
}
