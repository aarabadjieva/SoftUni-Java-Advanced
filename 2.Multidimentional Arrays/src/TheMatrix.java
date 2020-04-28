import java.util.Arrays;
import java.util.Scanner;

public class TheMatrix {
    static Scanner scanner = new Scanner(System.in);
    private static String matrix[][];
    private static String symbol;
    private static String startChar;
    private static int[]sizes;

    public static void main(String[] args) {
        sizes = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        readMatrix();
        symbol = scanner.nextLine();
        int[]coordinates = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        int startRow = coordinates[0];
        int startCol = coordinates[1];
        startChar = matrix[startRow][startCol];
        visitCell(startRow,startCol);
        printMatrix(matrix);
    }

    private static void visitCell(int row, int col) {
        if (!inRange(row,col)||!matrix[row][col].equals(startChar)){
            return;
        }
        matrix[row][col] = symbol;
        visitCell(row+1,col);
        visitCell(row-1,col);
        visitCell(row,col-1);
        visitCell(row,col+1);
    }

    private static boolean inRange(int row, int col) {
        return row>=0&&row<matrix.length&&col>=0&&col<matrix[0].length;
    }

    private static void printMatrix(String[][] matrix) {
        for (String[]row:matrix
             ) {
            System.out.println(String.join("",row));
        }
    }

    private static void readMatrix(){
        int rows = sizes[0];
        int cols = sizes[1];
        matrix = new String[rows][cols];
        for (int row = 0; row < rows; row++) {
            matrix[row]=scanner.nextLine().split("\\s+");
        }
    }

}
