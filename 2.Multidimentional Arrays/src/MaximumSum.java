import java.util.Arrays;
import java.util.Scanner;

public class MaximumSum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] size = readDimentons(scanner);
        int rows = size[0];
        int cols = size[1];
        int[][] matrix = new int[rows][cols];
        matrix = readMatrix(rows,scanner,matrix);
        int sum = 0;
        int maxSum = 0;
        int beginRow = 0;
        int beginCol = 0;
        for (int row = 0; row < rows-2; row++) {
            for (int col = 0; col < cols-2; col++) {
               sum = findMaxSum(matrix,row,col);
               if (sum>maxSum){
                   maxSum = sum;
                   beginRow = row;
                   beginCol = col;
               }
            }
        }
        int[][] maxMatrix = new int[3][3];
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                maxMatrix[row][col] = matrix[beginRow][beginCol];
                beginCol++;
            }
            beginRow++;
            beginCol = beginCol-3;
        }
        System.out.println("Sum = " + maxSum);
        printMatrix(maxMatrix);
    }

    private static int findMaxSum(int[][] matrix, int rows, int cols) {
        int sum = 0;
        for (int row = rows; row <rows+3 ; row++) {
            for (int col = cols; col < cols+3; col++) {
                sum += matrix[row][col];
            }
        }
        return sum;
    }

    private static void printMatrix(int[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[0].length; col++) {
                System.out.print(matrix[row][col] + " ");
            }
            System.out.println();
        }
    }
    private static int[][] readMatrix(int rows, Scanner scanner, int[][] matrix) {
        for (int row = 0; row < rows; row++) {
            int[] input = Arrays.stream(scanner.nextLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            matrix[row] = input;
        }
        return matrix;
    }

    private static int[] readDimentons(Scanner scanner) {
        int[] size = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        return size;
    }

}
