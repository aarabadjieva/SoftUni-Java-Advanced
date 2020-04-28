import java.util.Arrays;
import java.util.Scanner;

public class ComparingMatrices {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] firstMatrixDimensions = scanner.nextLine().split(" ");
        int rows = Integer.parseInt(firstMatrixDimensions[0]);
        int cols = Integer.parseInt(firstMatrixDimensions[1]);
        int[][] firstMatrix = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            String[] col1Data = scanner.nextLine().split(" ");
            for (int j = 0; j < col1Data.length; j++) {
                firstMatrix[i][j] = Integer.parseInt(col1Data[j]);
            }
        }
        String[] secondMatrixDimensions = scanner.nextLine().split(" ");
        int rows2 = Integer.parseInt(secondMatrixDimensions[0]);
        int cols2 = Integer.parseInt(secondMatrixDimensions[1]);
        int[][] secondMatrix = new int[rows2][cols2];
        for (int i = 0; i < rows2; i++) {
            String[] col2Data = scanner.nextLine().split(" ");
            for (int j = 0; j < col2Data.length; j++) {
                secondMatrix[i][j] = Integer.parseInt(col2Data[j]);
            }
        }
        if (isEqual(firstMatrix,secondMatrix)){
            System.out.println("equal");
        }else{
            System.out.println("not equal");
        }
    }
    private static boolean isEqual(int[][] firstMatrix, int[][] secondMatrix){
        for (int i = 0; i < firstMatrix.length; i++) {
            for (int j = 0; j < firstMatrix[0].length; j++) {
                if (firstMatrix.length!=secondMatrix.length||firstMatrix[0].length!=secondMatrix[0].length){
                    return false;
                }else if (firstMatrix[i][j]!=secondMatrix[i][j]){
                    return false;
                }
            }
        }
        return true;
    }
}
