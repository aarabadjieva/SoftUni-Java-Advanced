import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Function;

public class SumNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] numbers = scanner.nextLine().split(", ");
        Function<String, Integer> toInt = Integer::parseInt;
        int count = 0;
        int sum = Arrays.stream(numbers).map(toInt).reduce(0,(a,b)->a+b);
        System.out.println("Count = " + numbers.length);
        System.out.println("Sum = " + sum);
    }
}
