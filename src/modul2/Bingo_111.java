package modul2;

import java.util.ArrayList;
import java.util.Random;

public class Bingo_111 {
    public static void main(String[] args) {
        int[][] card = new int[5][5];
        Random r = new Random();
        ArrayList<Integer> nummer = new ArrayList<>();
        int tmp = 0;
        boolean isValid = false;

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < card.length; j++) {
                while (!isValid) {
                    tmp = r.nextInt(16) + i * 15;
                    if (!nummer.contains(tmp)) {
                        nummer.add(tmp);
                        isValid = true;
                    }
                }
                card[j][i]= tmp;
                isValid = false;
            }
        }

        System.out.printf("\u001B[32m | %-4s | %-4s | %-4s | %-4s | %-4s | %n", "B", "I", "N", "G", "O");
        System.out.println("---------------------------------------");
        for (int i = 0; i < card.length; i++) {
            for (int j = 0; j < card[i].length; j++) {
                if(i == 2 && j == 2)
                    System.out.printf(" | \u001B[31m%-1s", "free");
                else
                    System.out.printf("\u001B[36m | %-4s", card[i][j]);
            }
            System.out.println(" |");
        }
    }
}
