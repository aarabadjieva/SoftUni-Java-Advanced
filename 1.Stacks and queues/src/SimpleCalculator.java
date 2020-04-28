import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Scanner;

public class SimpleCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayDeque<String> tokens = new ArrayDeque<>();
        String[] input = scanner.nextLine().split(" ");
        Collections.addAll(tokens, input);

        while (tokens.size() > 1){
            int firstNum = Integer.parseInt(tokens.poll());
            String operator = tokens.poll();
            int secondNum = Integer.parseInt(tokens.poll());
            int result = 0;
            if (operator.equals("+")){
                result = firstNum+secondNum;
            }else{
                result = firstNum-secondNum;
            }
            tokens.push(String.valueOf(result));
        }
        System.out.println(tokens.poll());
    }
}
