import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.Scanner;

public class MaximumElement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberOfComands = Integer.parseInt(scanner.nextLine());
        Deque<Integer> numbers = new ArrayDeque<>();
        while (numberOfComands-->0){
            int[] command = Arrays.stream(scanner.nextLine().split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            if (command[0]==1){
                int number = command[1];
                numbers.push(number);
            }else if (command[0] == 2){
                numbers.pop();
            }else{
                if (numbers.isEmpty()){
                    System.out.println("0");
                }else {
                    int maxElement = Integer.MIN_VALUE;
                    for (int num : numbers
                    ) {
                        if (num > maxElement) {
                            maxElement = num;
                        }
                    }
                    System.out.println(maxElement);
                }
            }
        }
    }
}
