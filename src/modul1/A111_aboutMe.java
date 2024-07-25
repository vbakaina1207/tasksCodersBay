package modul1;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class A111_aboutMe {
    public static void main(String[] args) {
        int age = 47;
        String firstName = "Viktoriia";
        String lastName = "Bakakina";
        String sex = "woman";
        Date dateOfBirth = new Date (76, Calendar.JULY,12);
        DateFormat formatter = new SimpleDateFormat("dd.MM.yyyy");
        double avg = 4.9;
        boolean isMarried = true;

        System.out.println("My name is " + firstName + " " + lastName + ".");
        System.out.println("I'm " + age + ".");
        System.out.println("I'm a " + sex + ".");
        System.out.printf("I was born "+ (formatter.format(dateOfBirth)) + ".%n");
        if(isMarried)
            System.out.println("I'm married.");
        else
            System.out.println("I'm single.");
        System.out.println("Average score on a 5-point scale, where 5 is the highest score and 1 is the lowest: "+ String.format("%.2f",avg));
    }


}
