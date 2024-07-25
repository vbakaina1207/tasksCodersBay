package modul5;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Personenverwaltung {
    public enum Sex {
        MALE,
        FEMALE
    }
    public class Address {
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
    public class Person{
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

    }

    public class Management {
         private List<Person> listPerson;

         public Management () {
             this.listPerson = new ArrayList<>();
         }

         public void createPerson(String firstName, String lastName) {
             Person person = new Person(firstName, lastName);
             listPerson.add(person);
         }

        public void createPerson (String firstName, String lastName, Sex sex, String dob) {
            Person person = new Person(firstName, lastName, sex, dob);
            listPerson.add(person);
        }

        public void createPerson (String firstName, String lastName, Sex sex, String dob, Address address) {
            Person person = new Person(firstName, lastName, sex, dob, address);
            listPerson.add(person);
        }

        public void removePerson (int index) {
             if(index >=0 && index < listPerson.size() )
                 listPerson.remove(index);
        }
    }

    public  void main(String[] args) {
        Management managmentInstanz = new Management();
        Management managmentCodersbay = new Management();
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

    }
}


