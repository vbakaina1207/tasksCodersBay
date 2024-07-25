import java.sql.Array;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class C06_MineSweeperV2 {
    public static void main(String[] args) {
        int[][] map = new int[10][10];
        int mineCount = 0;
        Random r = new Random(0);
        Scanner myObj = new Scanner(System.in);
        String coordinates = "";
        int count = 0;
        int x = 0;
        int y = 0;
        int input = -1;
        boolean isCorrect = false;
        char[] xy = new char[2];
        int inputInt = -1;

        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                map[i][j] = r.nextInt(-3, 1);
                if (map[i][j] ==0)
                    mineCount++;
            }
        }

        int area = 100 - mineCount;
        System.out.printf(" %-1s      %-2s | %-2s | %-2s | %-2s | %-2s | %-2s | %-2s | %-2s | %-2s | %-2s   %n", "", "A", "B", "C", "D", "E", "F", "G", "H", "I", "J");
        System.out.println("-------------------------------------------------------");

        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                if (j == 0)
                    System.out.printf(" %-1s    ", i);
                System.out.printf("| %-2s ", map[i][j]);
            }
            System.out.println();
        }
        System.out.println();
        while (input!=0 && mineCount != 0) {
            design(map);
            double procent = 100 * (double) count / (double) area;
            System.out.println("Du hast " + count + "/" + area + " (" + String.format("%2.2f", procent) + "%) des nicht verminten Gebiets auf Minen gecheckt");
            System.out.println("Es bleiben noch " + mineCount + " Minen versteckt.");

                while (!isCorrect ) {
                    if (input!=0) {
                        System.out.println("Wo willst du nach Minen suchen?");

                        coordinates = myObj.nextLine().toUpperCase();
                        xy = coordinates.toCharArray();
                        y = xy[0] - 65;
                        x = xy[1] - 48;
                    }
                        if (xy.length != 2 || (x < 0 || x > 9) || y < 0 || y > 9) {
                            System.out.println("Sie haben einen falschen Koordinatenwert eingegeben.\n Die Koordinaten müssen jeweils einen Buchstaben von A bis J und eine Zahl von 0 bis 9 enthalten.\n");
                        } else {
                            input = map[x][y];
                            if (input>0) {
                                System.out.println("Sie haben diese Koordinate bereits verwendet. Geben Sie eine andere Koordinate ein.");
                            }
                            else
                                isCorrect = true;
                        }

                }

            System.out.println("User input "+ y + "/" + x);
            inputInt = Integer.parseInt(String.valueOf(input));
            if (input==0) {
                mineCount--;
                map[x][y] = 1;
                design(map);
                System.out.println("Du hast " + count + "/" + area +" ("+ String.format("%2.2f",procent) +"%) des nicht verminten Gebiets auf Minen gecheckt");
                System.out.println("Es bleiben noch " + mineCount + " Minen versteckt.");
                System.out.println("Das... war eine Mine. Du hast leider verloren.");
            } else if (input<-1) {
                System.out.println("VAL "+ inputInt+ " -> " + (Math.abs(inputInt) -1));
                int shiftLeftX = x + inputInt + 1;
                if (shiftLeftX < 0)
                    shiftLeftX = 0;
                int shiftRightX = x - inputInt -1;
                if (shiftRightX > 9)
                    shiftRightX = 9;
                int shiftLeftY = y + inputInt + 1;
                if (shiftLeftY < 0)
                    shiftLeftY = 0;
                int shiftRightY = y - inputInt -1;
                if (shiftRightY > 9)
                    shiftRightY = 9;
                for (int i = shiftLeftX; i <= shiftRightX; i++) {
                    for (int j = shiftLeftY; j <= shiftRightY; j++) {
                        if (map[i][j]==0) {
                            map[i][j] = 1;
                            mineCount--;
                        } else if(map[i][j]<0){
                            map[i][j] = 2;
                            count++;
                        }
                    }
                }
            } else if (input==-1) {
                map[x][y] = 2;
                count++;
            }
            if (mineCount == 0)
                System.out.println("Du hast gewonnen!");
            isCorrect = false;
        }
    }

    public static void design (int[][]mapNew) {
        System.out.printf(" %-1s      %-2s | %-2s | %-2s | %-2s | %-2s | %-2s | %-2s | %-2s | %-2s | %-2s   %n", "", "A", "B", "C", " D", "E", "F", "G", "H", "I", "J");
        System.out.println("----------------------------------------------------");
        for (int i = 0; i < mapNew.length; i++) {
            for (int j = 0; j < mapNew[i].length; j++) {
                if (j == 0)
                    System.out.printf(" %-1s    ", i);
                if(mapNew[i][j]==1)
                    System.out.printf(" [%-1s] ", "*" );
                else if(mapNew[i][j]==2)
                    System.out.printf(" [%-1s] ","-");
                else
                    System.out.printf(" %-2s ", "[ ]");
            }
            System.out.println();
        }
    }
}