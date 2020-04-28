import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class ThePartyReservationFilterModule {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> names = Arrays.stream(scanner.nextLine().split("\\s+"))
                .collect(Collectors.toList());
        String line = scanner.nextLine();
        List<Predicate> predicates = new ArrayList<>();
        Map<String, List<String>> conditions = new LinkedHashMap<>();
        while (!line.equals("Print")){
            String[] tokens = line.split(";");
            String filter = tokens[1];
            String stringOrDigit = tokens[2];
            if (tokens[0].equals("Add filter")){
                conditions.putIfAbsent(filter,new ArrayList<>());
                conditions.get(filter).add(stringOrDigit);
            }else {
                    conditions.get(filter).remove(stringOrDigit);
            }
            line = scanner.nextLine();
        }
        for (String filter:conditions.keySet()
             ) {
            switch (filter){
                case "Starts with":
                    for (String string:conditions.get(filter)
                         ) {
                        Predicate<String> predicate = s->s.startsWith(string);
                        predicates.add(predicate);
                    }
                    break;
                case "Ends with":
                    for (String string:conditions.get(filter)
                    ) {
                        Predicate<String> predicate = s->s.endsWith(string);
                        predicates.add(predicate);
                    }
                    break;case "Contains":
                    for (String string:conditions.get(filter)
                    ) {
                        Predicate<String> predicate = s->s.contains(string);
                        predicates.add(predicate);
                    }
                    break;
                case "Length":
                    for (String string:conditions.get(filter)
                    ) {
                        Predicate<String> predicate = s->s.length()==Integer.parseInt(string);
                        predicates.add(predicate);
                    }
                    break;

            }
        }
        names = names.stream().filter(s->{
            boolean isValid = true;
            for (Predicate pred:predicates
                 ) {
                if (pred.test(s)){
                    isValid = false;
                }
            }
            return isValid;
        }
        ).collect(Collectors.toList());
        System.out.println(String.join(" ", names));
    }
}
