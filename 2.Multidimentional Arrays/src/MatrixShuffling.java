import java.util.Arrays;
import java.util.Scanner;

public class MatrixShuffling {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] size = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int rows = size[0];
        int cols = size[1];
        String[][] matrix = new String[rows][cols];
        matrix = readMatrix(rows,scanner,matrix);
        String[] cmd = scanner.nextLine().split(" ");
        while (!cmd[0].equals("END")){
            boolean isValid = checkCmd(cmd,rows,cols);
            if (isValid){
                int row1 = Integer.parseInt(cmd[1]);
                int col1 = Integer.parseInt(cmd[2]);
                int row2 = Integer.parseInt(cmd[3]);
                int col2 = Integer.parseInt(cmd[4]);
                matrix = swapMatrix(matrix, row1, col1,row2,col2);
                printMatrix(matrix);
            }else{
                System.out.println("Invalid input!");
            }
            cmd = scanner.nextLine().split(" ");
        }
    }

    private static void printMatrix(String[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[0].length; col++) {
                System.out.print(matrix[row][col] + " ");
            }
            System.out.println();
        }
    }

    private static String[][] swapMatrix(String[][] matrix, int row1, int col1, int row2, int col2) {
        String temp = matrix[row1][col1];
        matrix[row1][col1] = matrix[row2][col2];
        matrix[row2][col2] = temp;
        return matrix;
    }

    private static boolean checkCmd(String[] cmd, int rows, int cols) {
        if(cmd.length<5||cmd.length>5){
            return false;
        }else if (!cmd[0].equals("swap")){
            return false;
        }else if (Integer.parseInt(cmd[1])<0||Integer.parseInt(cmd[1])>=rows||Integer.parseInt(cmd[2])<0
                ||Integer.parseInt(cmd[2])>=cols||Integer.parseInt(cmd[3])<0|| Integer.parseInt(cmd[3])>=rows
                ||Integer.parseInt(cmd[4])<0||Integer.parseInt(cmd[4])>=cols){
            return false;
        }
        return true;
    }

    private static String[][] readMatrix(int rows, Scanner scanner, String[][] matrix) {
        for (int row = 0; row < rows; row++) {
            String[] input = scanner.nextLine().split(" ");
            matrix[row] = input;
        }
        return matrix;
    }
}
