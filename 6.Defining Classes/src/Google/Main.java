package Google;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        Map<String, Person> people = new LinkedHashMap<>();
        while (!line.equals("End")){
            String[] info = line.split("\\s+");
            String name = info[0];
            people.putIfAbsent(name,new Person(name));
            switch (info[1]){
                case "company":
                    String companyName = info[2];
                    String department = info[3];
                    double salary = Double.parseDouble(info[4]);
                    Company company = new Company(companyName,department,salary);
                    people.get(name).setCompany(company);
                    break;
                case "pokemon":
                    if (people.get(name).getPokemons()==null){
                        people.get(name).setPokemons(new ArrayList<>());
                    }
                    String pokemonName = info[2];
                    String type = info[3];
                    Pokemon pokemon = new Pokemon(pokemonName, type);
                    people.get(name).getPokemons().add(pokemon);
                    break;
                case "parents":
                    if (people.get(name).getParents()==null){
                        people.get(name).setParents(new ArrayList<>());
                    }
                    String parentName = info[2];
                    String birthday = info[3];
                    Parent parent = new Parent(parentName, birthday);
                    people.get(name).getParents().add(parent);
                    break;
                case "children":
                    if (people.get(name).getChildren()==null){
                        people.get(name).setChildren(new ArrayList<>());
                    }
                    String childName = info[2];
                    birthday = info[3];
                    Child child = new Child(childName,birthday);
                    people.get(name).getChildren().add(child);
                    break;
                case "car":
                    String model = info[2];
                    String speed = info[3];
                    Car car = new Car(model, speed);
                    people.get(name).setCar(car);
                    break;
            }
            line = scanner.nextLine();
        }
        String person = scanner.nextLine();
        System.out.println(person);
        System.out.println("Company:");
        if (people.get(person).getCompany()!=null){
            System.out.print(people.get(person).getCompany().toString());
        }
        System.out.println("Car:");
        if (people.get(person).getCar()!=null){
            System.out.print(people.get(person).getCar().toString());
        }
        System.out.println("Pokemon:");
        if (people.get(person).getPokemons()!=null){
            for (Pokemon pokemon: people.get(person).getPokemons()
                 ) {
                System.out.print(pokemon.toString());
            }
        }
        System.out.println("Parents:");
        if (people.get(person).getParents()!=null){
            for (Parent parent: people.get(person).getParents()
            ) {
                System.out.print(parent.toString());
            }
        }
        System.out.println("Children:");
        if (people.get(person).getChildren()!=null){
            for (Child child: people.get(person).getChildren()
            ) {
                System.out.print(child.toString());
            }
        }
    }
}
