import java.util.Arrays;
import java.util.Scanner;

public class ReverseMatrixDiagonals {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] sizes = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int rows = sizes[0];
        int cols = sizes[1];
        int[][] matrix = new int[rows][cols];
        for (int row = 0; row < rows; row++) {
            matrix[row] = Arrays.stream(scanner.nextLine().split(" "))
                    .mapToInt(Integer::parseInt).toArray();
        }
        int diagonalsCount = rows + cols - 1;
        while (diagonalsCount > 0) {
            for (int col = matrix[0].length - 1; col >= 0; col--) {
                int currentCol = col;
                int currentRow = matrix.length - 1;
                for (int row = 0; row < rows; row++) {
                    if (currentCol < matrix[0].length) {
                        System.out.print(matrix[currentRow][currentCol] + " ");
                    }
                    currentCol++;
                    currentRow--;
                }
                System.out.println();
                diagonalsCount--;
            }
            for (int row = rows - 2; row >= 0; row--) {
                int currentCol = 0;
                for (int i = row; i >= 0; i--) {
                    if (currentCol<matrix[0].length){
                        System.out.print(matrix[i][currentCol] + " ");
                    }
                    currentCol++;
                }
                System.out.println();
                diagonalsCount--;
            }
        }
    }
}

