import java.util.Arrays;
import java.util.Scanner;

public class DiagonalDifference {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int rows = Integer.parseInt(scanner.nextLine());
        int[][] matrix = new int[rows][];
        for (int row = 0; row < rows; row++) {
            int[] input = Arrays.stream(scanner.nextLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            matrix[row] = input;
        }
        int firstDiagonalSum = 0;
        int secondDiagonalSum = 0;
        for (int i = 0; i < rows; i++) {
            firstDiagonalSum += matrix[i][i];
            secondDiagonalSum += matrix[i][rows-1-i];
        }
        System.out.println(Math.abs(firstDiagonalSum - secondDiagonalSum));
    }
}
