import java.lang.reflect.Array;
import java.util.*;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public class ReverseAndExclude {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Integer> numbers = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toCollection(ArrayList::new));
        int n = Integer.parseInt(scanner.nextLine());
        BiFunction<ArrayList<Integer>, Integer, ArrayList<Integer>> reverseAndExclude = ((list, num) -> {
            Collections.reverse(list);
            return list.stream().filter(e -> e % n != 0).collect(Collectors.toCollection(ArrayList::new));
        });
        Consumer<Integer> printer = e -> System.out.print(e + " ");
        reverseAndExclude.apply(numbers, n).forEach(printer);
    }
}
