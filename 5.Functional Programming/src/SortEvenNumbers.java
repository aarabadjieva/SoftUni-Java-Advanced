import java.util.*;
import java.util.stream.Collectors;

public class SortEvenNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> numbers =  Arrays.stream(scanner.nextLine().split(",\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        numbers = numbers.stream().filter(e-> e%2==0).collect(Collectors.toList());
        System.out.println(String.join(",",numbers.toString().replace("[","").replace("]","")));
        numbers = numbers.stream().sorted(Integer::compare).collect(Collectors.toList());
        System.out.println(String.join(",",numbers.toString().replace("[","").replace("]","")));
    }
}
