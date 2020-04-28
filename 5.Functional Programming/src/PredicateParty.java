import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.BiFunction;
import java.util.stream.Collectors;

public class PredicateParty {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> names = Arrays.stream(scanner.nextLine().split("\\s+"))
                .collect(Collectors.toList());
        String line = scanner.nextLine();
        BiFunction<List<String>, String, List<String>> removeEnd = (list, string)-> list.stream().filter(name->!name.endsWith(string)).collect(Collectors.toList());
        BiFunction<List<String>, String, List<String>> removeStart = (list, string)-> list.stream().filter(name->!name.startsWith(string)).collect(Collectors.toList());
        while (!line.equals("Party!")){
            String[] cmd = line.split("\\s+");
            names = StartEndOrLenght(names, cmd);
            line = scanner.nextLine();
        }
        names = names.stream().sorted().collect(Collectors.toList());
        if (names.size()>0){
            System.out.println(String.join(", ",names) + " are going to the party!");
        }else {
            System.out.println("Nobody is going to the party!");
        }

    }

    private static List<String> StartEndOrLenght(List<String> names, String[] cmd) {
        BiFunction <List<String>, String, List<String>> removeStart = (list, string) ->
                list.stream().filter(name -> !name.startsWith(string)).collect(Collectors.toList());
        BiFunction <List<String>, String, List<String>> removeEnd = (list, string) ->
                list.stream().filter(name -> !name.endsWith(string)).collect(Collectors.toList());
        BiFunction <List<String>, Integer, List<String>> removeLenght = (list, length) ->
                list.stream().filter(name -> name.length()>length).collect(Collectors.toList());
        BiFunction<List<String>, String, List<String>> doubleStart = (list, string) -> {
            List<String> goingPeople = new ArrayList<>();
            for (String name:list
            ) {
                if (name.startsWith(string)){
                    goingPeople.add(name);
                }
                goingPeople.add(name);
            }
            return goingPeople;
        };
        BiFunction<List<String>, String, List<String>> doubleEnd = (list, string) -> {
            List<String> goingPeople = new ArrayList<>();
            for (String name:list
            ) {
                if (name.endsWith(string)){
                    goingPeople.add(name);
                }
                goingPeople.add(name);
            }
            return goingPeople;
        };
        BiFunction<List<String>, Integer, List<String>> doubleLength = (list, length) -> {
            List<String> goingPeople = new ArrayList<>();
            for (String name:list
            ) {
                if (name.length()==length){
                    goingPeople.add(name);
                }
                goingPeople.add(name);
            }
            return goingPeople;
        };
        switch (cmd[0]){
            case "Remove":
                if (cmd[1].equals("StartsWith")){
                    names = removeStart.apply(names,cmd[2]);
                }else if (cmd[1].equals("EndsWith")){
                    names = removeEnd.apply(names,cmd[2]);
                }else {
                    int length = Integer.parseInt(cmd[2]);
                    names = removeLenght.apply(names, length);
                }
                break;
            case "Double":
                if (cmd[1].equals("StartsWith")){
                    names = doubleStart.apply(names,cmd[2]);
                }else if (cmd[1].equals("EndsWith")){
                    names = doubleEnd.apply(names,cmd[2]);
                }else {
                    int length = Integer.parseInt(cmd[2]);
                    names = doubleLength.apply(names, length);
                }
                break;
        }
        return names;
    }


}
