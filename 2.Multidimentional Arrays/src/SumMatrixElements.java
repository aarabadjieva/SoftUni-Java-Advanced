import java.util.Arrays;
import java.util.Scanner;

public class SumMatrixElements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] dimentions = scanner.nextLine().split(", ");
        int rows = Integer.parseInt(dimentions[0]);
        int cols = Integer.parseInt(dimentions[1]);
        System.out.println(rows);
        System.out.println(cols);
        int sum = 0;
        int[][] matrix = new int[rows][cols];
        for (int row = 0; row < rows; row++) {
           sum += Arrays.stream(scanner.nextLine().split(", "))
                    .mapToInt(Integer::parseInt)
                    .sum();
        }
        System.out.println(sum);
    }
}
