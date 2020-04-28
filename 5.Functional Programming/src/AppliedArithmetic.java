import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.UnaryOperator;

public class AppliedArithmetic {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] numbers = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
        String operator = scanner.nextLine();
        UnaryOperator<int[]> add = arr->Arrays.stream(arr).map(e->++e).toArray();
        UnaryOperator<int[]> multiply = arr->Arrays.stream(arr).map(e->e*2).toArray();
        UnaryOperator<int[]> subtract = arr->Arrays.stream(arr).map(e->--e).toArray();
        Consumer<int[]> print = arr-> Arrays.stream(arr).forEach(e-> System.out.print(e+" "));
        while (!operator.equals("end")){
            switch (operator){
                case "add":
                   numbers = add.apply(numbers);
                    break;
                case "multiply":
                    numbers = multiply.apply(numbers);
                    break;
                case "subtract":
                    numbers = subtract.apply(numbers);
                    break;
                case "print":
                    print.accept(numbers);
                    System.out.println();
                    break;
            }
            operator = scanner.nextLine();
        }

    }
}
