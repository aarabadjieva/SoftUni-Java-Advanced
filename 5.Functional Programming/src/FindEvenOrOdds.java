import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class FindEvenOrOdds {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] limits = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
        String evenOrOdd = scanner.nextLine();
        Predicate<Integer> isEven = e->e%2==0;
        System.out.println(Arrays.toString(IntStream
                .rangeClosed(limits[0], limits[1])
                .filter(evenOrOdd.equals("even") ? isEven::test : value -> !isEven.test(value))
                .toArray())
                .replace("[","")
                .replace(",","")
                .replace("]",""));
    }
}
