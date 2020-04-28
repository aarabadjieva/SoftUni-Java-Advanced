import java.util.Arrays;
import java.util.Scanner;

public class Sort {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] arr = Arrays.stream(scanner.nextLine().split("\\s"))
                .mapToInt(Integer::parseInt).toArray();
        arr = sort(arr);
        for (int n:arr
             ) {
            System.out.print(n+" ");
        }
    }

    private static int[] sort(int[] arr) {
        for (int j = 0; j <arr.length ; j++) {
            boolean sorted = true;
            for (int i = 0; i < arr.length-1-j; i++) {
                if (arr[i]>arr[i+1]){
                    int temp = arr[i];
                    arr[i] = arr[i+1];
                    arr[i+1] = temp;
                    sorted = false;
                }
            }
            if (sorted){
                break;
            }
        }
        return arr;
    }
}
