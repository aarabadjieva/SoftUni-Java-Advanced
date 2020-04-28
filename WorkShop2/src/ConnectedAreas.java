import java.util.*;
import java.util.stream.Collectors;

public class ConnectedAreas {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int rows = Integer.parseInt(scanner.nextLine());
        int cols = Integer.parseInt(scanner.nextLine());
        char[][] matrix = new char[rows][cols];
        for (int row = 0; row < rows; row++) {
            matrix[row] = scanner.nextLine().toCharArray();
        }
        List<Area> areas= new ArrayList<>();
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[0].length; col++) {
                if (matrix[row][col]=='-'){
                    int[] size =new int[1];
                    findSize(matrix, row, col,size);
                    int[]starting = {row,col};
                    Area area = new Area(size[0], starting);
                    areas.add(area);
                }
            }
        }
        System.out.printf("Total areas found: %d%n",areas.size());
        int n=0;
        areas = areas.stream().sorted(Comparator.comparingInt(Area::getSize).reversed().thenComparing(Comparator.comparingInt(Area::getRow)).thenComparing(Comparator.comparingInt(Area::getCol)))
                .collect(Collectors.toList());
        for (int i = 0; i < areas.size(); i++) {
            System.out.printf("Area #%d at (%d, %d), size: %d%n",i+1,areas.get(i).getRow(),areas.get(i).getCol(),areas.get(i).getSize());
        }
    }

    private static void findSize(char[][] matrix, int startRow, int startCol, int[] size) {
       if (!isInBounds(matrix, startRow,startCol)||matrix[startRow][startCol]=='*'){
           return;
       }
       size[0]++;
       matrix[startRow][startCol] = '*';
       findSize(matrix,startRow+1,startCol,size);
       findSize(matrix,startRow-1,startCol,size);
       findSize(matrix,startRow,startCol+1,size);
       findSize(matrix,startRow,startCol-1,size);
    }

    private static boolean isInBounds(char[][] matrix, int startRow, int startCol) {
        return startRow>=0&&startRow<matrix.length&&startCol>=0&&startCol<matrix[0].length;
    }

}
class Area{
   private int size;
    private int[] startingIndex;

    public Area(int size, int[] startingIndex) {
        this.size = size;
        this.startingIndex = startingIndex;
    }

    public int getSize() {
        return size;
    }

    public int[] getStartingIndex() {
        return startingIndex;
    }
    public int getRow(){
        return startingIndex[0];
    }
    public int getCol(){
        return startingIndex[1];
    }
}
