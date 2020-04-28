import java.util.Arrays;
import java.util.Scanner;

public class Sneaking {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int rows = Integer.parseInt(scanner.nextLine());
        char[][] room = new char[rows][];
        for (int i = 0; i < rows; i++) {
            room[i] = scanner.nextLine().toCharArray();
        }
        int[] sam = new int[2];
        int[] nicoladze = new int[2];
        for (int row = 0; row < room.length; row++) {
            for (int col = 0; col < room[0].length; col++) {
                if (room[row][col] == 'S') {
                    sam[0] = row;
                    sam[1] = col;
                    room[row][col] = '.';
                }
                if (room[row][col] == 'N') {
                    nicoladze[0] = row;
                    nicoladze[1] = col;
                }
            }
        }
        char[] directions = scanner.nextLine().toCharArray();
        boolean samIsAlive = true;
        boolean nicoladzeIsAlive = true;
        for (int i = 0; i <= directions.length; i++) {

            room = moveEnemies(room);
            samIsAlive = isSamAlive(room,sam,samIsAlive);
            if (!samIsAlive) {
                break;
            }
            room[sam[0]][sam[1]] = '.';
            switch (directions[i]) {
                case 'U':
                    sam[0] = sam[0] - 1;
                    break;
                case 'D':
                    sam[0] = sam[0] + 1;
                    break;
                case 'L':
                    sam[1] = sam[1] - 1;
                    break;
                case 'R':
                    sam[1] = sam[1] + 1;
                    break;
                    default:break;
            }

            if (room[sam[0]][sam[1]] == 'b' || room[sam[0]][sam[1]] == 'd') {
                room[sam[0]][sam[1]] = '.';
            } else if (sam[0] == nicoladze[0]) {
                room[nicoladze[0]][nicoladze[1]] = 'X';
                nicoladzeIsAlive = false;
                room[sam[0]][sam[1]] = 'S';
            }
            if (!nicoladzeIsAlive) {
                break;
            }
        }
        if (samIsAlive){
            room[sam[0]][sam[1]] = 'S';
            System.out.println("Nikoladze killed!");
            printMatrix(room);
        }else {
            System.out.printf("Sam died at %d, %d%n",sam[0],sam[1]);
            printMatrix(room);
        }

    }

    private static void printMatrix(char[][] room) {
        for (int row = 0; row < room.length; row++) {
            StringBuilder currentRow = new StringBuilder();
            for (int col = 0; col < room[0].length; col++) {
                String output = String.valueOf(room[row][col]);
                currentRow.append(output);
            }
            System.out.println(currentRow.toString());
        }
    }

    private static boolean isSamAlive(char[][] room, int[] sam, boolean samIsAlive) {
        for (int col = 0; col < room[0].length; col++) {
            switch (room[sam[0]][col]) {
                case 'b':
                    if (col <= sam[1]) {
                        samIsAlive = false;
                        room[sam[0]][sam[1]] = 'X';
                    }
                    break;
                case 'd':
                    if (col >= sam[1]) {
                        samIsAlive = false;
                        room[sam[0]][sam[1]] = 'X';
                    }
                    break;
            }
        }
        return samIsAlive;
    }

    private static char[][] moveEnemies(char[][] room) {
        for (int row = 0; row < room.length; row++) {
            for (int col = 0; col < room[0].length; col++) {
                switch (room[row][col]) {
                    case 'b':
                        if (col + 1 < room[row].length) {
                            room[row][col] = '.';
                            room[row][col + 1] = 'r';
                        } else {
                            room[row][col] = 'l';
                        }
                        break;
                    case 'd':
                        if (col - 1 >= 0) {
                            room[row][col] = '.';
                            room[row][col - 1] = 'l';
                        } else {
                            room[row][col] = 'r';
                        }
                        break;
                }
            }
        }
        for (int row = 0; row < room.length; row++) {
            for (int col = 0; col < room[0].length; col++) {
                if (room[row][col] == 'r') {
                    room[row][col] = 'b';
                } else if (room[row][col] == 'l') {
                    room[row][col] = 'd';
                }
            }
        }
        return room;
    }
}
