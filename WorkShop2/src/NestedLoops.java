import java.util.Arrays;
import java.util.Scanner;

public class NestedLoops {
    public static int[] arr;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        arr = new int[n];
        printNested(n,0);
    }

    private static void printNested(int n, int begin) {
        if (begin>=n){
            for (int i = 0; i < arr.length; i++) {
                System.out.print(arr[i]+" ");
            }
            System.out.println();
            return;
        }
        for (int i = 1; i <=n ; i++) {
            arr[begin] = i;
          printNested(n, begin+1);
        }
    }
}
