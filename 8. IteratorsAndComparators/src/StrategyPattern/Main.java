package StrategyPattern;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        Set<Person> byName = new TreeSet<>(new ComparatorPeopleByNames());
        Set<Person> byAge = new TreeSet<>(new ComparatorPeopleByAge());
        while (n-->0){
            String[] data = scanner.nextLine().split("\\s+");
            String name = data[0];
            int age = Integer.parseInt(data[1]);
            Person person = new Person(name,age);
            byName.add(person);
            byAge.add(person);
        }
        for (Person person:byName
             ) {
            System.out.println(person.getName()+" "+person.getAge());
        }
        for (Person person:byAge
        ) {
            System.out.println(person.getName()+" "+person.getAge());
        }
    }
}
