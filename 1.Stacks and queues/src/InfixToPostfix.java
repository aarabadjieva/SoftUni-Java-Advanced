import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class InfixToPostfix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] tokens = scanner.nextLine().split(" ");
        StringBuilder postfix = new StringBuilder();
        Deque<String> operators = new ArrayDeque<>();

        for (String token:tokens
        ) {
            if (!token.equals("+")&&!token.equals("-")&&!token.equals("*")&&!token.equals("/")&&!token.equals("(")&&!token.equals(")")){
                System.out.print(token + " ");
            }else if (token.equals("(")){
                operators.push(token);

            } else if (token.equals(")")){
                String currentOperator = operators.pop();
                while (!currentOperator.equals("(")){
                    System.out.print(currentOperator + " ");
                    currentOperator = operators.pop();
                }
            }else if (token.equals("+")||token.equals("-")){
                while(!operators.isEmpty()&&(!operators.peek().equals("("))){
                    System.out.print(operators.pop()+ " ");

                }
                    operators.push(token);

            }else if (token.equals("/")||token.equals("*")) {
                if (!operators.isEmpty()) {
                    if (operators.peek().equals("/") || operators.peek().equals("*")) {
                        System.out.print(operators.pop() + " ");
                        operators.push(token);
                    } else {
                        operators.push(token);
                    }
                }
                else{
                    operators.push(token);
                }
            }
        }
        while (!operators.isEmpty()){
            System.out.print(operators.pop() + " ");
        }
    }
}
