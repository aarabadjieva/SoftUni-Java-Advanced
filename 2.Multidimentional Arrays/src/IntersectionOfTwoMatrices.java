import com.sun.source.tree.ArrayAccessTree;

import java.util.Arrays;
import java.util.Scanner;

public class IntersectionOfTwoMatrices {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int rows = Integer.parseInt(scanner.nextLine());
        int cols = Integer.parseInt(scanner.nextLine());
        char[][] first = new char[rows][cols];
        char[][] second = new char[rows][cols];
        for (int row = 0; row < rows; row++) {
            String[] input = scanner.nextLine().split(" ");
            for (int col = 0; col < input.length; col++) {
                first[row][col] = input[col].charAt(0);
            }
        }
        for (int row = 0; row < rows; row++) {
            String[] input = scanner.nextLine().split(" ");
            for (int col = 0; col < input.length; col++) {
                second[row][col] = input[col].charAt(0);
            }
        }
        char[][] result = new char[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (first[i][j] == second[i][j]){
                    result[i][j] = first[i][j];
                }else {
                    result[i][j] = '*';
                }
                System.out.print(result[i][j] + " ");
            }
            System.out.println();
        }
    }
}
