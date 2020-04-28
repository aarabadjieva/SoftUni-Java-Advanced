import java.util.ArrayDeque;
import java.util.Collection;
import java.util.Collections;
import java.util.Scanner;

public class HotPotato {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split(" ");
        int n = Integer.parseInt(scanner.nextLine());
        ArrayDeque<String> names = new ArrayDeque<>();
        Collections.addAll(names, input);
        int round = 1;
        while (names.size()>1){
            for (int i = 0; i <n-1 ; i++) {
                String currentChild = names.poll();
                names.offer(currentChild);
            }
            if (isPrime(round)&&round!=1){
                String child = names.peek();
                System.out.println("Prime " + child);
            }else{
                String child = names.poll();
                System.out.println("Removed " + child);
            }
            round++;
        }
        System.out.println("Last is " + names.poll());
    }
    private static boolean isPrime(int number){
        for (int i = 2; i <number ; i++) {
            if (number%i == 0){
                return false;
            }
        }
        return true;
    }
}
