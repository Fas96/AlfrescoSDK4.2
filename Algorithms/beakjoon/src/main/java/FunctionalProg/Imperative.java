package FunctionalProg;

import java.util.ArrayList;
import java.util.List;

import static FunctionalProg.Imperative.Gender.FEMALE;
import static FunctionalProg.Imperative.Gender.MALE;

public class Imperative {
    public static void main(String[] args) {
        List<Person> people=List.of(new Person("Fas",MALE),new Person("Nasa",FEMALE));
        List<Person> females= new ArrayList<>();
        for (Person person : people) {
//            System.out.println(person);
            if(FEMALE.equals(person.gender)){
                females.add(person);
            }
        }
        System.out.println(females);

    }
    static class Person{
        private final String name;
        private final Gender gender;

        Person(String name, Gender gender) {
            this.name = name;
            this.gender = gender;
        }

        @Override
        public String toString() {
            return "Person{" +
                    "name='" + name + '\'' +
                    ", gender=" + gender +
                    '}';
        }
    }
    public enum Gender{
        MALE,FEMALE,OTHER
    }
}
