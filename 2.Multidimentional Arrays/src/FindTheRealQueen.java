import java.util.Scanner;

public class FindTheRealQueen {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[][] chessBoard = new String[8][8];
        for (int row = 0; row < 8; row++) {
            String[] figures = scanner.nextLine().split(" ");
            chessBoard[row] = figures;
        }
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (chessBoard[i][j].equals("q")){

                    if (isQueen(chessBoard, i, j)) {
                        System.out.println(i + " " + j);
                        break;
                    }
                }
            }
        }
    }
    private static boolean isQueen(String[][] board, int row, int col){
        return validColumn(board, col)&&
        validRow(board,row)&&
        validFirstDiagonal(board, row, col)&&
        validSecondDiagonal(board, row, col);

    }
    private static boolean validColumn(String[][] board, int col){
        int queenCount = 0;
        for (int i = 0; i < 8; i++) {
            if (board[i][col].equals("q")){
                queenCount++;
            }
        }
        return queenCount==1;
    }
    private static boolean validRow(String[][] board, int row){
        int queenCount = 0;
        for (int i = 0; i < 8; i++) {
            if (board[row][i].equals("q")){
                queenCount++;
            }
        }
        return queenCount==1;
    }
    private static boolean validFirstDiagonal(String[][] board, int row, int col){
        int queenCount = 0;
        for (int i = 0; row-i>=0&&col-i>=0; i++) {
            if (board[row-i][col-i].equals("q")){
                queenCount++;
            }
        }
        for (int i = 0; row+i<8&&col+i<8; i++) {
            if (board[row+i][col+i].equals("q")){
                queenCount++;
            }
        }
        return queenCount==2;
    }
    private static boolean validSecondDiagonal(String[][] board, int row, int col){
        int queenCount = 0;
        for (int i = 0; row-i>=0&&col+i<8; i++) {
            if (board[row-i][col+i].equals("q")){
                queenCount++;
            }
        }
        for (int i = 0; row+i<8&&col-i>=0; i++) {
            if (board[row+i][col-i].equals("q")){
                queenCount++;
            }
        }
        return queenCount==2;
    }
}
