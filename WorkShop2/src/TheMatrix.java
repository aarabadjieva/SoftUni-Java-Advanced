import java.util.Arrays;
import java.util.Scanner;

public class TheMatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] sizes = Arrays.stream(scanner.nextLine().split("\\s"))
                .mapToInt(Integer::parseInt).toArray();
        int rows = sizes[0];
        int cols = sizes[1];
        String[][] matrix = new String[rows][cols];
        for (int row = 0; row < rows; row++) {
            matrix[row] = scanner.nextLine().split(" ");
        }
        String fillChar = scanner.nextLine();
        int[] start = Arrays.stream(scanner.nextLine().split("\\s"))
                .mapToInt(Integer::parseInt).toArray();
        int startRow = start[0];
        int startCol = start[1];
        String startChar = matrix[startRow][startCol];
        matrixFill(matrix,startRow,startCol,fillChar,startChar);
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[0].length; col++) {
                System.out.print(matrix[row][col]);
            }
            System.out.println();
        }
    }

    private static void matrixFill(String[][] matrix, int startRow, int startCol, String fillChar,String startChar) {
        if (!isInRange(matrix,startCol,startRow)||!matrix[startRow][startCol].equals(startChar)){
            return;
        }
        matrix[startRow][startCol] = fillChar;
        matrixFill(matrix,startRow+1,startCol,fillChar,startChar);
        matrixFill(matrix,startRow-1,startCol,fillChar,startChar);
        matrixFill(matrix,startRow,startCol+1,fillChar,startChar);
        matrixFill(matrix,startRow,startCol-1,fillChar,startChar);
    }

    private static boolean isInRange(String[][] matrix, int startCol, int startRow) {
        return startRow>=0&&startRow<matrix.length&&startCol>=0&&startCol<matrix[0].length;
    }
}
