package modul5;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Personenverwaltung2 {
    public enum Sex {
        MALE,
        FEMALE
    }
    public static class Address {
        private int postNummer;
        private String city;
        private  String street;
        private  String houseNum;

        public Address(int postNummer, String city, String street, String houseNum) {
            this.postNummer = postNummer;
            this.city = city;
            this.street = street;
            this.houseNum  = houseNum;
        }
    }
    public static class Person{
        private String firstName;
        private String lastName;
        private Sex sex;
        private String dob;
        private Address address ;

        public Person (String firstName, String lastName, Sex sex, String dob, Address address) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.sex = sex;
            this.dob = dob;
            this.address = address;
        }

        public Person (String firstName, String lastName) {
            this.firstName = firstName;
            this.lastName = lastName;
        }
        public Person (String firstName, String lastName, Sex sex, String dob) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.sex = sex;
            this.dob = dob;
        }

        public String getFirstName(){
            return  firstName;
        }

        public String getLastName(){
            return  lastName;
        }

        public String getDob(){
            return  dob;
        }


    }

    public static class Managment {
        private List<Person> listPerson;

        public Managment () {
            this.listPerson = new ArrayList<>();
        }

        public void createPerson(String firstName, String lastName) {
            Person person = new Person(firstName, lastName);
            if (findPerson(firstName, lastName) == null)
                listPerson.add(person);
            else
                System.out.println("The person already exists");
        }

        public void createPerson (String firstName, String lastName, Sex sex, String dob) {
            Person person = new Person(firstName, lastName, sex, dob);
            if (findPerson(firstName, lastName, dob) == null)
                listPerson.add(person);
            else
                System.out.println("The person " + person.getFirstName() + " " + person.getLastName() + " " + person.getDob() + " already exists");
        }

        public void createPerson (String firstName, String lastName, Sex sex, String dob, Address address) {
            Person person = new Person(firstName, lastName, sex, dob, address);
            if (findPerson(firstName, lastName, dob) == null)
                listPerson.add(person);
            else
                System.out.println("The person already exists");
        }

        private Person findPerson (String firstName, String lastName, String dob) {
            for(Person person: listPerson) {
                if(person.getFirstName().equals(firstName) && person.getLastName().equals(lastName) && person.getDob().equals(dob))
                    return  person;
            }
            return  null;
        }

        private Person findPerson (String firstName, String lastName) {
            for(Person person: listPerson) {
                if(person.getFirstName().equals(firstName) && person.getLastName().equals(lastName))
                    return  person;
            }
            return  null;
        }
        public void removePerson (String firstName, String lastName, String dob) {
            Person person = findPerson(firstName, lastName, dob);
            if (person != null)
                listPerson.remove(person);
            else
                System.out.println("Person not found");
        }
    }

    public static void main(String[] args) {
        Managment managmentInstanz = new Managment();
        Managment managmentCodersbay = new Managment();
        Address exampleAddress = new Address(4202,"Hellmonsödt", "SomeStreet", "1b");
        Address exampleAddress2 = new Address(4202,"Hellmonsödt", "SchoolStreet", "3");
        Address addressCodersbay = new Address(4020,"Linz", "Peter-Behrens-Platz", "4");

        managmentInstanz.createPerson("Anna", "Ivanova", Sex.FEMALE, "2002-03-03", exampleAddress);
        managmentInstanz.createPerson("Boris", "Stoun");
        managmentInstanz.createPerson("Anna", "Ivanova", Sex.FEMALE, "2002-03-03");
        managmentInstanz.createPerson("Victor", "Ivanov", Sex.MALE, "1999.01.03", exampleAddress2);

        managmentCodersbay.createPerson("Viktoria", "Bakakina", Sex.FEMALE, "1982.07.12", addressCodersbay);
        managmentCodersbay.createPerson("Ivan", "Savonov");
        managmentCodersbay.createPerson("Ludmila", "Broun",  Sex.FEMALE, "2000.02.02");

        for (Person person :  managmentCodersbay.listPerson){
            System.out.println(person.getFirstName()+ " " + person.getLastName());
        }

    }
}


