import java.util.Arrays;
import java.util.Scanner;

public class WrongMeasurments {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size = Integer.parseInt(scanner.nextLine());
        int matrix[][] = new int[size][size];
        for (int i = 0; i < size; i++) {
            int[] input = Arrays.stream(scanner.nextLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            matrix[i] = input;
        }
        int[] coordinates = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int wrongValue = matrix[coordinates[0]][coordinates[1]];

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == wrongValue) {
                    int left = 0;
                    int right = 0;
                    int up = 0;
                    int down = 0;
                    int sum = 0;
                    if (i - 1 >= 0 && matrix[i - 1][j] != wrongValue) {
                        up = matrix[i - 1][j];
                    }
                    if (i + 1 < size && matrix[i + 1][j] != wrongValue) {
                        down = matrix[i + 1][j];
                    }
                    if (j - 1 >= 0 && matrix[i][j - 1] != wrongValue) {
                        left = matrix[i][j - 1];
                    }
                    if (j + 1 <matrix[0].length && matrix[i][j + 1] != wrongValue) {
                        right = matrix[i][j + 1];
                    }
                    sum = left + right + up + down;
                    System.out.print(sum + " ");
                } else {
                    System.out.print(matrix[i][j] + " ");
                }
            }
            System.out.println();
        }
    }
}
