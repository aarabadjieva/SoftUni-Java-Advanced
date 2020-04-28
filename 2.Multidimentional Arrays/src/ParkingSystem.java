import java.util.Arrays;
import java.util.Scanner;

public class ParkingSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] sizes = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int rows = sizes[0];
        int cols = sizes[1];
        char[][] parkingLot = new char[rows][cols];
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (col==0){
                    parkingLot[row][col] = ' ';
                }else {
                    parkingLot[row][col] = 'o';
                }
            }
        }
        String input = scanner.nextLine();
        while (!input.equals("stop")){
            int[] desiredSpot = Arrays.stream(input.split(" "))
                    .mapToInt(Integer::parseInt).toArray();
            int moves = 1;
            int entryRow = desiredSpot[0];
            int row = desiredSpot[1];
            int col = desiredSpot[2];
            int firstSteps = Math.abs(entryRow-row);
            moves+=firstSteps;
            boolean foundFreeSpot = false;
            if (parkingLot[row][col]=='o'){
                parkingLot[row][col]='x';
                foundFreeSpot = true;
            }else if (parkingLot[row][col]=='x'){
                int closerLeft = Integer.MAX_VALUE;
                int closerRight = Integer.MAX_VALUE;
                for (int i = col-1; i >0 ; i--) {
                    if (parkingLot[row][i]=='o'){
                        closerLeft = i;
                        foundFreeSpot = true;
                        break;
                    }
                }
                for (int i = col+1; i <parkingLot[row].length ; i++) {
                    if (parkingLot[row][i]=='o'){
                        closerRight = i;
                        foundFreeSpot = true;
                        break;
                    }
                }
                if (foundFreeSpot) {
                    if (Math.abs(col - closerLeft) <= closerRight - col) {
                        col = closerLeft;
                    } else {
                        col = closerRight;
                    }
                    parkingLot[row][col] = 'x';
                }
            }
            moves+=col;
            if (foundFreeSpot){
                System.out.println(moves);
            }else {
                System.out.printf("Row %d full%n",row);
            }
            input = scanner.nextLine();
        }
    }
}
