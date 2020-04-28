import java.util.Scanner;

public class RecursiveFibbonaci {
    static long[] memory;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        memory = new long[n+1];
        long fibonacci = calculateFibonacci(n);
        System.out.println(fibonacci);
    }
    private static long calculateFibonacci(int n){
        if (n<2){
            return 1;
        }else if (memory[n]==0){
            memory[n] = calculateFibonacci(n-1) + calculateFibonacci(n-2);
        }
        return memory[n];
    }
}
