import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Scanner;

public class BasicQueueOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] limits = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int numbersToadd = limits[0];
        int numbersToRemove = limits[1];
        int numberToFind = limits[2];
        Deque<Integer> numbers = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .limit(numbersToadd)
                .forEach(numbers::add);
        while (numbersToRemove-->0){
            numbers.poll();
        }
        if (numbers.contains(numberToFind)){
            System.out.println("true");
        }else{
            if (numbers.isEmpty()){
                System.out.println("0");
            }else{
                int minElement = Integer.MAX_VALUE;
                for (int num:numbers
                     ) {
                    if (num<minElement){
                        minElement = num;
                    }
                }
                System.out.println(minElement);
            }
        }
    }
}
