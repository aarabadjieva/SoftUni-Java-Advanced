import java.util.*;

public class ReverseNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Deque<Integer> numbers = new ArrayDeque<>();
        String[] input = scanner.nextLine().split(" ");
        for (String number:input
             ) {
            numbers.push(Integer.parseInt(number));
        }
        while (numbers.size()>0){
            System.out.print(numbers.pop()+" ");
        }
    }
}
