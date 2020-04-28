import java.util.Arrays;
import java.util.Scanner;
import java.util.StringJoiner;

public class ExcelFunctions {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size = Integer.parseInt(scanner.nextLine());
        String[][] table = new String[size][];
        for (int row = 0; row < size; row++) {
            table[row] = scanner.nextLine().split(",\\s+");
        }
        String[] cmd = scanner.nextLine().split("\\s+");
        String header = cmd[1];
        int headerCol = 0;
        for (int col = 0; col <table[0].length ; col++) {
            if (table[0][col].equals(header)){
                headerCol = col;
            }
        }
        switch (cmd[0]){
            case "hide":
                for (int row = 0; row < size; row++) {
                    table[row][headerCol] = "";
                }
                printMatrix(table);
                break;
            case "sort":
                for (int row = 1; row < table.length; row++) {
                    int nextRow = row;
                    while (nextRow++<table.length-1) {
                        try {
                            double first = Double.parseDouble(table[row][headerCol]);
                            double second = Double.parseDouble(table[nextRow][headerCol]);
                            if (first > second) {
                                String[] temp = table[row];
                                table[row] = table[nextRow];
                                table[nextRow] = temp;
                            }
                        } catch (Exception e){
                        if (table[row][headerCol].compareTo(table[nextRow][headerCol]) > 0) {
                            String[] temp = table[row];
                            table[row] = table[nextRow];
                            table[nextRow] = temp;
                        }
                    }
                    }
                }
                printMatrix(table);
                break;
            case "filter":
                String value = cmd[2];
                StringJoiner firstRowJoiner = new StringJoiner(" | ");
                for (int i = 0; i < table[0].length; i++) {
                    firstRowJoiner.add(table[0][i]);
                }
                System.out.println(firstRowJoiner);
                for (int row = 1; row < table.length; row++) {
                    if (table[row][headerCol].equals(value)){
                        StringJoiner joiner = new StringJoiner(" | ");
                        for (int col = 0; col <table[0].length ; col++) {
                            joiner.add(table[row][col]);
                        }
                        System.out.println(joiner);
                    }
                }
                break;
        }
    }

    private static void printMatrix(String[][] table) {
        for (int row = 0; row < table.length; row++) {
            StringJoiner joiner = new StringJoiner(" | ");
            for (int col = 0; col < table[0].length; col++) {
                if (!table[row][col].equals("")) {
                    joiner.add(table[row][col]);
                }
            }
            System.out.println(joiner);
        }
    }
}
