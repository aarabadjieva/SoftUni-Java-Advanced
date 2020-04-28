import java.util.Arrays;
import java.util.Scanner;

public class RecursiveArray {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] arr = Arrays.stream(scanner.nextLine().split("\\s"))
                .mapToInt(Integer::parseInt)
                .toArray();
        int sum = arraySum(arr, 0);
        System.out.println(sum);
    }

    private static int arraySum(int[] arr, int index) {
        if (index==arr.length-1){
            return arr[index];
        }
        return arr[index] + arraySum(arr, index+1);
    }
}
