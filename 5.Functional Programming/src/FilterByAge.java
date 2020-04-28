import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class FilterByAge {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int count = Integer.parseInt(scanner.nextLine());
        Map<String, Integer> persons = new LinkedHashMap<>();
        while (count-- > 0) {
            String[] infoForPerson = scanner.nextLine().split(",\\s+");
            String name = infoForPerson[0];
            int age = Integer.parseInt(infoForPerson[1]);
            persons.put(name, age);
        }
        String condition = scanner.nextLine();
        int ageToCompare = Integer.parseInt(scanner.nextLine());
        String format = scanner.nextLine();
        Predicate<Integer> isYonger = e -> e < ageToCompare;
        Consumer<Map.Entry<String, Integer>> printName = e-> System.out.println(e.getKey());
        Consumer<Map.Entry<String, Integer>> printAge = e-> System.out.println(e.getValue());
        Consumer<Map.Entry<String, Integer>> printNameAndAge = e-> System.out.println(e.getKey() + " - " + e.getValue());

            persons.entrySet().stream()
                    .filter(condition.equals("younger") ? e->isYonger.test(e.getValue())
                            : e->!isYonger.test(e.getValue())).forEach(format.endsWith("name") ? printName : format.equals("age") ? printAge : printNameAndAge);
    }
}
