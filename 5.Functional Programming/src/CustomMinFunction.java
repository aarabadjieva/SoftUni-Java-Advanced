import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Function;

public class CustomMinFunction {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] numbers = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
        System.out.println(findMin.apply(numbers));
    }
    private static Function<int[], Integer> findMin = ints -> {
        int min = Integer.MAX_VALUE;
        for (int num: ints
             ) {
            if (num<=min){
                min = num;
            }
        }
        return min;
    };
}