import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ListOfPredicates {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int limit = Integer.parseInt(scanner.nextLine());
        List<Integer> numbers = IntStream
        .rangeClosed(1, limit)
        .boxed()
        .collect(Collectors.toList());
        List<Integer> dividers = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        BiFunction<List<Integer>,List<Integer>, List<Integer>> findDivided = (list1, list2) ->{
            List<Integer> useful = new ArrayList<>();
            for (int num:list1
                 ) {
                boolean isDividable = true;
                for (Integer integer : list2) {
                    if (num % integer != 0) {
                        isDividable = false;
                    }
                }
                if (isDividable){
                    useful.add(num);
                }
            }
            return useful;
        };
        List<Integer> usefulNumbers = findDivided.apply(numbers,dividers);
        usefulNumbers.stream().forEach(e-> System.out.print(e+" "));
    }
}
