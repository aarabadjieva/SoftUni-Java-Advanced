import java.util.Scanner;
import java.util.StringJoiner;

public class ThronRacers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size = Integer.parseInt(scanner.nextLine());
        char[][] matrix = new char[size][];
        for (int row = 0; row < size; row++) {
            matrix[row] = scanner.nextLine().toCharArray();
        }
        int[] first = new int[2];
        int[] second = new int[2];
        for (int row = 0; row < size; row++) {
            for (int col = 0; col < matrix[0].length; col++) {
                if (matrix[row][col]=='f'){
                    first[0] = row;
                    first[1] = col;
                }
                if (matrix[row][col]=='s'){
                    second[0] = row;
                    second[1] = col;
                }
            }
        }
        boolean firstIsAlive = true;
        boolean secondIsAlive = true;

        while (firstIsAlive&&secondIsAlive){
            String[] move = scanner.nextLine().split("\\s+");
            String firstMove = move[0];
            String secondMove = move[1];
            first = checkBoundaries(firstMove,first,matrix);
            if (matrix[first[0]][first[1]]!='s'){
                matrix[first[0]][first[1]]='f';
                second = checkBoundaries(secondMove,second,matrix);
                if (matrix[second[0]][second[1]]!='f'){
                    matrix[second[0]][second[1]]='s';
                }else {
                    secondIsAlive = false;
                    matrix[second[0]][second[1]] = 'x';
                }
            }else {
                firstIsAlive = false;
                matrix[first[0]][first[1]]='x';
            }
        }
        printMatrix(matrix);
    }

    private static void printMatrix(char[][] matrix) {
        for (int row = 0; row < matrix.length; row++) {
            StringJoiner joiner = new StringJoiner("");
            for (int col = 0; col < matrix[0].length; col++) {
                joiner.add(String.valueOf(matrix[row][col]));
            }
            System.out.println(joiner);
        }
    }

    public static int[] checkBoundaries(String firstMove, int[] first, char[][] matrix){
        switch (firstMove){
            case "up":
                if (first[0]-1>=0){
                    first[0] = first[0]-1;
                }else {
                    first[0] = matrix.length-1;
                }
                break;
            case "down":
                if (first[0]+1<matrix.length){
                    first[0] = first[0]+1;
                }else {
                    first[0] = 0;
                }
                break;
            case "left":
                if (first[1]-1>=0){
                    first[1] = first[1]-1;
                }else {
                    first[1] = matrix[0].length-1;
                }
                break;
            case "right":
                if (first[1]+1<matrix[0].length){
                    first[1] = first[1]+1;
                }else {
                    first[1] = 0;
                }
                break;
        }
        return first;
    }
}
