import java.util.Arrays;
import java.util.Scanner;

public class Searching {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] numbers = Arrays.stream(scanner.nextLine().split("\\s"))
                .mapToInt(Integer::parseInt).toArray();

        numbers = Arrays.stream(numbers).sorted().toArray();
        int n = Integer.parseInt(scanner.nextLine());
        System.out.println(findNumber(numbers,0, numbers.length-1, n));
    }

    private static int findNumber(int[] numbers, int start, int end, int n) {
        while (end>=start){
            int mid = (start+end)/2;
            if (numbers[mid]<n){
                start = mid+1;
            }else if (numbers[mid]>n){
                end = mid-1;
            }else return mid;
        }
        return -1;
    }
}
