import java.util.Arrays;
import java.util.Scanner;

public class MatrixOfPalindromes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] sizes = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int rows = sizes[0];
        int cols = sizes[1];
        String[][] matrix = new String[rows][cols];
        String palindrome = "";
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                char first = 'a';
                char second = 'a';
                first+=row;
                second+=row+col;
                palindrome = first+""+second+""+first;
                matrix[row][col] = palindrome;
            }
        }
        printMatrix(matrix);
    }
    private static void printMatrix(String[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[0].length; col++) {
                System.out.print(matrix[row][col] + " ");
            }
            System.out.println();
        }
    }
}
