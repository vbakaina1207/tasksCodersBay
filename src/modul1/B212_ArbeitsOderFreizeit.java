package modul1;

import java.time.LocalTime;
import java.util.Scanner;

import static java.time.LocalTime.parse;

public class B212_ArbeitsOderFreizeit {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        LocalTime start = LocalTime.of(8, 0, 0);
        LocalTime stop = LocalTime.of(15, 30, 0);
        LocalTime startPause = LocalTime.of(12, 0, 0);
        LocalTime stopPause = LocalTime.of(12, 30, 0);
        int hour = -1;
        int minute = -1;
        while (hour<0 || hour>23) {
            System.out.println("Geben Sie bitte Stunden zwischen 0 und 23:");
            hour = sc.nextInt();
            if (hour<0 || hour>23)
                System.out.println("Die Stunden müssen zwischen 0 und 23 liegen");
        }
        while (minute<0 || minute>60){
            System.out.println("Geben Sie bitte Minuten zwischen 0 und 59:");
            minute = sc.nextInt();
            if(minute<0 || minute>59)
                System.out.println("Die Minuten müssen zwischen 0 und 59 liegen");
        }
         if(hour>-1 && hour < 24 && minute > -1 && minute < 60) {
             LocalTime workTime = LocalTime.of(hour, minute, 0);
             Boolean isNowInRange = ((!workTime.isBefore(start)) && workTime.isBefore(startPause)) || (!workTime.isBefore(stopPause) && workTime.isBefore(stop));

             //SimpleDateFormat displayFormat = new SimpleDateFormat("HH:mm");
             //SimpleDateFormat parseFormat = new SimpleDateFormat("hh:mm a");
             if (isNowInRange)
                 System.out.println("Die Zeit " + workTime + " entspricht der Arbeitszeit");
             else
                 System.out.println("Die Zeit " + workTime + "  entspricht nicht der Arbeitszeit");
         }
        //System.out.println(displayFormat.format(workTime));
        //System.out.println(parseFormat.format(workTime));

    }
}
