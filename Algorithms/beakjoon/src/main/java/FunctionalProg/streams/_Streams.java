package FunctionalProg.streams;

import FunctionalProg.Imperative;

import java.util.List;
import java.util.stream.Collectors;

import static FunctionalProg.Imperative.Gender.FEMALE;
import static FunctionalProg.Imperative.Gender.MALE;


public class _Streams {
    public static void main(String[] args) {
        List<Person> people = List.of(
                new Person("A", FEMALE),
                new Person("B", MALE),
                new Person("C", FEMALE),
                new Person("D", MALE),
                new Person("E", FEMALE),
                new Person("F", FEMALE)
        );

        people.stream().map(e->e.name).collect(Collectors.toSet()).forEach(System.out::println);

    }
    static class Person{
        private final String name;
        private final Imperative.Gender gender;

        Person(String name, Imperative.Gender gender) {
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
    enum Gender{
        MALE,FEMALE,OTHER
    }
}
