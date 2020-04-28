import java.util.Scanner;

public class BombField {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size = Integer.parseInt(scanner.nextLine());
        String[] cmd = scanner.nextLine().split(",");
        String[][] field = new String[size][size];
        int[] startingPosition = new int[2];
        int bombCount = 0;
        for (int row = 0; row < size; row++) {
            String[] line = scanner.nextLine().split("\\s+");
            for (int col = 0; col < size; col++) {
                field[row][col] = line[col];
                if (field[row][col].equals("s")) {
                    startingPosition[0] = row;
                    startingPosition[1] = col;
                } else if (field[row][col].equals("B")) {
                    bombCount++;
                }
            }
        }
        int positionRow = startingPosition[0];
        int positionCol = startingPosition[1];
        for (int i = 0; i < cmd.length; i++) {
            String currentCmd = cmd[i];
            switch (currentCmd) {
                case "up":
                    if (positionRow - 1 >= 0 && positionRow - 1 < size) {
                        positionRow = positionRow - 1;
                    }
                    break;
                case "down":
                    if (positionRow + 1 < size) {
                        positionRow = positionRow + 1;
                    }
                    break;
                case "right":
                    if (positionCol + 1 < size) {
                        positionCol = positionCol + 1;
                    }
                    break;
                case "left":
                    if (positionCol - 1 >= 0 && positionCol - 1 < size) {
                        positionCol = positionCol - 1;
                    }
                    break;
            }
            String box = field[positionRow][positionCol];
            switch (box) {
                case "B":
                    field[positionRow][positionCol] = "+";
                    System.out.println("You found a bomb!");
                    bombCount--;
                    if (bombCount == 0) {
                        System.out.println("Congratulations! You found all bombs!");
                        return;
                    }
                    break;
                case "e":
                    System.out.printf("END! %d bombs left on the field%n", bombCount);
                    return;
            }
        }
        System.out.printf("%d bombs left on the field. Sapper position: (%d,%d)", bombCount, positionRow, positionCol);
    }
}
