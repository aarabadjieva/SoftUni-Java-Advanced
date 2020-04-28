package Person;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Person> people = new ArrayList<>();
        String[] data = scanner.nextLine().split("\\s+");
        while (!data[0].equals("END")) {
            String name = data[0];
            int age = Integer.parseInt(data[1]);
            String town = data[2];
            Person person = new Person(name, age, town);
            people.add(person);
            data = scanner.nextLine().split("\\s+");
        }
        int equalCounter = 0;
        int nonEqualCounter = 0;
        int index = Integer.parseInt(scanner.nextLine());
       if (index>=0&&index<people.size()){
            for (int i = 0; i < people.size(); i++) {
                int compare = people.get(index).compareTo(people.get(i));
                if (compare == 0) {
                    equalCounter++;
                } else {
                    nonEqualCounter++;
                }
            }
        }
        if (equalCounter > 1) {
            System.out.println(equalCounter + " " + nonEqualCounter + " " + people.size());
        }else {
            System.out.println("No matches");
        }
    }
}
