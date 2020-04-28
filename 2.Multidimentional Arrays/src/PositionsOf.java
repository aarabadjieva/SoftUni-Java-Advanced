import java.util.Scanner;

public class PositionsOf {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] dimentions = scanner.nextLine().split(" ");
        int rows = Integer.parseInt(dimentions[0]);
        int cols = Integer.parseInt(dimentions[1]);

        int[][] matrix = new int[rows][cols];
        for (int row = 0; row < rows; row++) {
            String[] numbers = scanner.nextLine().split(" ");
            for (int col = 0; col < numbers.length; col++) {
                matrix[row][col] = Integer.parseInt(numbers[col]);
            }
        }
        int number = Integer.parseInt(scanner.nextLine());
        boolean exist = false;
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (matrix[row][col] == number) {
                    exist = true;
                    System.out.println(row + " " + col);
                }
            }
        }
        if (!exist){
            System.out.println("not found");
        }
    }
}
