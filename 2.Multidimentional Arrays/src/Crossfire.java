import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Crossfire {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] sizes = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int rows = sizes[0];
        int cols = sizes[1];
        List<List<Integer>> mainList = new ArrayList<List<Integer>>();
        int n = 1;
        for (int row = 0; row < rows; row++) {
            List<Integer> rowList = new ArrayList<>();
            for (int col = 0; col < cols; col++) {
                rowList.add(n++);
            }
            mainList.add(rowList);
        }
        int maxSize = mainList.get(0).size();
        String line = scanner.nextLine();
        while (!line.equals("Nuke it from orbit")) {
            int[] bombCoordinates = Arrays.stream(line.split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            int row = bombCoordinates[0];
            int col = bombCoordinates[1];
            int radius = bombCoordinates[2];
            int startOfColDestruction = row - radius;
            if (startOfColDestruction < 0) {
                startOfColDestruction = 0;
            }
            int endOfColDestruction = row + radius;
            if (endOfColDestruction >= mainList.size()) {
                endOfColDestruction = mainList.size()-1;
            }
            int startOfRowDestruction = col - radius;
            if (startOfRowDestruction < 0) {
                startOfRowDestruction = 0;
            }
            int endOfRowDestruction = col + radius;
            if (endOfRowDestruction >= maxSize) {
                endOfRowDestruction = maxSize-1;
            }
            for (int i = startOfColDestruction; i <= endOfColDestruction; i++) {
                if (i >= mainList.size() || i < 0 || i == row) {
                    continue;
                }
                if (col < 0 || col >= mainList.get(i).size()) {
                    continue;
                } else {
                    mainList.get(i).remove(col);
                }
            }

            for (int currentCol = endOfRowDestruction; currentCol >= startOfRowDestruction; currentCol--) {
                if (row < 0 || row >= mainList.size()) {
                    continue;
                } else if (currentCol >= mainList.get(row).size()) {
                    continue;
                } else {
                    mainList.get(row).remove(currentCol);
                }
            }
            mainList.removeIf(List::isEmpty);
            line = scanner.nextLine();
        }
        for (List<Integer> list : mainList
        ) {
            for (int num : list
            ) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }
}


