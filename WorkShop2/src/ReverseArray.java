import java.util.Scanner;

public class ReverseArray {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] arr = scanner.nextLine().split("\\s");
        print(arr, arr.length-1);
    }

    private static void print(String[] arr, int index) {
        if (index==0){
            System.out.print(arr[index]);
        }else {
            System.out.print(arr[index]+" ");
            print(arr,index-1);
        }
    }
}
