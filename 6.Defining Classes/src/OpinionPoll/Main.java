package OpinionPoll;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int count = Integer.parseInt(scanner.nextLine());
        List<Person> persons = IntStream.rangeClosed(1,count).boxed()
                .map(line-> scanner.nextLine().split("\\s+"))
                .map(info -> {
                    Person person = new Person(info[0],Integer.parseInt(info[1]));
                    return person;
                }).collect(Collectors.toList());
        persons.stream().sorted(Comparator.comparing(Person::getName)).filter(p->p.getAge()>30)
                .forEach(p-> System.out.printf("%s - %d%n",p.getName(),p.getAge()));
    }
}
