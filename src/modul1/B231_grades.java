package modul1;

import java.util.Scanner;

public class B231_grades {
    public static void main(String[] args) {
        int grade = 0;
        Scanner sc = new Scanner(System.in);
        while (grade<1 || grade>5) {
            System.out.println("Geben Sie bitte eine Note zwischen 1 und 5:");
            grade = sc.nextInt();
            if(grade<1 || grade>5)
                System.out.println("Die Noten müssen zwischen 1 und 5 liegen");
        }
        if(grade==1)
            System.out.println("Sehr gut");
        else if (grade==2)
            System.out.println("Gut");
        else if (grade==3)
            System.out.println("Befriedigend");
        else if (grade==4)
            System.out.println("Genügend");
        else if (grade==5)
            System.out.println("Nicht Gengügend");
    }
}
