package FamilyTree;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String personToFind = scanner.nextLine();
        Map<String, Person> familyTree = new LinkedHashMap<>();
        List<Person> people = new ArrayList<>();
        String line = scanner.nextLine();
        List<String> relations = new ArrayList<>();
        while (!line.equals("End")){
            String[] data = line.split("\\s-\\s");
            if (data.length==2){
               relations.add(line);
            }else {
                String[] personInfo = line.split("\\s");
                String personName = personInfo[0] + " " + personInfo[1];
                String personBirthday = personInfo[2];
                Person person1 = new Person();
                person1.setName(personName);
                person1.setBirthday(personBirthday);
                people.add(person1);
            }
            line = scanner.nextLine();
        }
        for (String relation:relations
             ) {
            String[]data = relation.split(" - ");
            if (!data[0].contains("/")&&!data[1].contains("/")){
                String parentName = data[0];
                String childName = data[1];
                Person parent = new Person();
                Person child = new Person();
                for (Person person: people
                     ) {
                    if (person.getName().equals(parentName)){
                        parent = person;
                    }
                }
                for (Person person:people
                     ) {
                    if (person.getName().equals(childName)){
                        child = person;
                    }
                }
                parent.getChildren().add(child);
                child.getParents().add(parent);
            }else if (!data[0].contains("/")&&data[1].contains("/")){
                String parentName = data[0];
                String childBirthday = data[1];
                Person parent = new Person();
                Person child = new Person();
                for (Person person: people
                ) {
                    if (person.getName().equals(parentName)){
                        parent = person;
                    }
                }
                for (Person person:people
                ) {
                    if (person.getBirthday().equals(childBirthday)){
                        child = person;
                    }
                }
                parent.getChildren().add(child);
                child.getParents().add(parent);
            }else if (data[0].contains("/")&&!data[1].contains("/")){
                String parentBirthday = data[0];
                String childName = data[1];
                Person parent = new Person();
                Person child = new Person();
                for (Person person: people
                ) {
                    if (person.getBirthday().equals(parentBirthday)){
                        parent = person;
                    }
                }
                for (Person person:people
                ) {
                    if (person.getName().equals(childName)){
                        child = person;
                    }
                }
                parent.getChildren().add(child);
                child.getParents().add(parent);
            }else if (data[0].contains("/")&&data[1].contains("/")){
                String parentBirthday = data[0];
                String childBirthday = data[1];
                Person parent = new Person();
                Person child = new Person();
                for (Person person: people
                ) {
                    if (person.getBirthday().equals(parentBirthday)){
                        parent = person;
                    }
                }
                for (Person person:people
                ) {
                    if (person.getBirthday().equals(childBirthday)){
                        child = person;
                    }
                }
                parent.getChildren().add(child);
                child.getParents().add(parent);
            }
        }
        if (personToFind.contains("/")){
            for (Person person: people
                 ) {
                if (person.getBirthday().equals(personToFind)){
                    System.out.println(person.getName() + " " + person.getBirthday());
                    System.out.println("Parents:");
                    for (Person parent:person.getParents()
                         ) {
                        System.out.println(parent.getName() + " " + parent.getBirthday());
                    }
                    System.out.println("Children:");
                    for (Person child:person.getChildren()
                         ) {
                        System.out.println(child.getName() + " " + child.getBirthday());
                    }
                }
            }
        }else {
            for (Person person: people
            ) {
                if (person.getName().equals(personToFind)){
                    System.out.println(person.getName() + " " + person.getBirthday());
                    System.out.println("Parents:");
                    for (Person parent:person.getParents()
                    ) {
                        System.out.println(parent.getName() + " " + parent.getBirthday());
                    }
                    System.out.println("Children:");
                    for (Person child:person.getChildren()
                    ) {
                        System.out.println(child.getName() + " " + child.getBirthday());
                    }
                }
            }
        }
    }
}
