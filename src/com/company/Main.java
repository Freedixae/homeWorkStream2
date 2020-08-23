package com.company;

import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {
        Collection<Person> persons = Arrays.asList(
                new Person("Jack", "Evans", 16, Sex.MAN, Education.SECONDARY),
                new Person("Connor", "Young", 23, Sex.MAN, Education.FURTHER),
                new Person("Emily", "Harris", 42, Sex.WOMEN, Education.HIGHER),
                new Person("Harry", "Wilson", 20, Sex.MAN, Education.HIGHER),
                new Person("George", "Davies", 35, Sex.MAN, Education.FURTHER),
                new Person("Samuel", "Adamson", 40, Sex.MAN, Education.HIGHER),
                new Person("John", "Brown", 44, Sex.MAN, Education.HIGHER),
                new Person("Avril", "Lavigne", 35, Sex.WOMEN, Education.HIGHER),
                new Person("Taylor", "Swift", 30, Sex.WOMEN, Education.HIGHER),
                new Person("Billie", "Eilish", 17, Sex.WOMEN, Education.ELEMENTARY));

        Stream<Person> underagePerson = persons.stream();
        System.out.println(underagePerson.filter(x -> x.getAge() < 18).count() + "\n");

        Stream<Person> conscriptPerson = persons.stream();
        conscriptPerson.filter(x -> x.getAge() > 18 && x.getAge() < 27)
                .filter(x -> x.getSex() != Sex.WOMEN)
                .map(Person::getFamily)
                .collect(Collectors.toList())
                .forEach(System.out::println);
        System.out.println();

        Stream<Person> workerPersonMan = persons.stream();
        workerPersonMan.filter(x-> x.getEducation() == Education.HIGHER)
                .filter(x-> x.getSex() == Sex.MAN && x.getAge() > 18 && x.getAge() < 65 ||
                        x.getSex() == Sex.WOMEN && x.getAge() > 18 && x.getAge() < 60)
                .sorted(Comparator.comparing(Person::getFamily))
                .map(Person::getFamily)
                .collect(Collectors.toList())
                .forEach(System.out::println);
    }
}