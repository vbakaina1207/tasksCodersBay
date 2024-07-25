import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class C03_MineSweeperV1 {
    public static void main(String[] args) {
        int[][] map = new int[10][10];
        int mapCount = 0;

        Random r = new Random();
        Scanner myObj = new Scanner(System.in);
        String coordinates = "";
        int count = 0;
        int x = 0;
        int y = 0;
        int input = -1;
        String[][] mapNew =  new String[map.length][map[0].length];

        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                map[i][j] = r.nextInt(4);
                mapNew[i][j] = String.valueOf(map[i][j]);
                if (map[i][j] == 0)
                    mapCount++;
            }
        }

        int gebiet = 100 - mapCount;
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
        while (input != 0) {
            map(mapNew);
            double procent = 100*(double)count/(double)gebiet;
            System.out.println("Du hast " + count + "/" + gebiet +" ("+ String.format("%2.2f",procent) +"%) des nicht verminten Gebiets auf Minen gecheckt");
            System.out.println("Es bleiben noch " + mapCount + " Minen versteckt.");
            if (input != 0)
                System.out.println("Wo willst du nach Minen suchen?");

            coordinates = myObj.nextLine();
            char[] xy = coordinates.toCharArray();
            x = Integer.parseInt(String.valueOf(xy[1]));
            y = xy[0] - 65;
            input = map[x][y];

            if (input == 0) {
                mapNew[x][y] = "*";
                map(mapNew);
                System.out.println("Du hast " + count + "/" + gebiet +" ("+ String.format("%2.2f",procent) +"%) des nicht verminten Gebiets auf Minen gecheckt");
                System.out.println("Es bleiben noch " + mapCount + " Minen versteckt.");
                System.out.println("Das... war eine Mine. Du hast leider verloren.");
            } else {
                mapNew[x][y] = "-";
                count++;
            }
        }
    }

    public static void map (String[][]mapNew) {
        System.out.printf(" %-1s      %-2s | %-2s | %-2s | %-2s | %-2s | %-2s | %-2s | %-2s | %-2s | %-2s   %n", "", "A", "B", "C", " D", "E", "F", "G", "H", "I", "J");
        System.out.println("----------------------------------------------------");
        for (int i = 0; i < mapNew.length; i++) {
            for (int j = 0; j < mapNew[i].length; j++) {
                if (j == 0)
                    System.out.printf(" %-1s    ", i);
                if(mapNew[i][j].equals("*") || mapNew[i][j].equals("-"))
                    System.out.printf(" [%-1s] ", mapNew[i][j]);
                else
                    System.out.printf(" %-2s ", "[ ]");
            }
            System.out.println();
        }

    }
}
