import java.util.Arrays;
import java.util.Scanner;

public class MaximumSum2x2 {
    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        String[] sizes = scanner.nextLine().split(", ");
        int rows = Integer.parseInt(sizes[0]);
        int cols = Integer.parseInt(sizes[1]);
        int[][] matrix = matrixreader(rows, cols);
        int maxSum = 0;
        int[] maxElements = new int[4];
        for (int i = 0; i < rows - 1; i++) {
            for (int j = 0; j < cols - 1; j++) {
                int currentSum = matrix[i][j] + matrix[i][j + 1] +
                        matrix[i + 1][j] + matrix[i + 1][j + 1];
                if (currentSum > maxSum) {
                    maxSum = currentSum;
                    maxElements[0] = matrix[i][j];
                    maxElements[1] = matrix[i][j + 1];
                    maxElements[2] = matrix[i + 1][j];
                    maxElements[3] = matrix[i + 1][j + 1];
                }
            }
        }
        System.out.println(maxElements[0] + " " + maxElements[1]);
        System.out.println(maxElements[2] + " " + maxElements[3]);
        System.out.println(maxSum);
    }

    private static int[][] matrixreader(int rows, int cols) {
        int[][] matrix = new int[rows][cols];
        for (int row = 0; row < rows; row++) {
            int[] numbers = Arrays.stream(scanner.nextLine().split(", "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            for (int col = 0; col < cols; col++) {
                matrix[row][col] = numbers[col];
            }
        }
        return matrix;
    }
}
