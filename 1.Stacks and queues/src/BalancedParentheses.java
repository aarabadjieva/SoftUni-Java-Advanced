import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class BalancedParentheses {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        Deque<Character> parentheses = new ArrayDeque<>();
        boolean isBalanced = true;
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i)=='['||input.charAt(i)=='{'||input.charAt(i)=='('){
                parentheses.push(input.charAt(i));
            }else if (parentheses.isEmpty()){
                isBalanced = false;
            }else if (input.charAt(i)==']'){
                if (parentheses.pop()!='['){
                    isBalanced = false;
                }
            }else if (input.charAt(i)=='}'){
                if (parentheses.pop()!='{'){
                    isBalanced = false;
                }
            }else if (input.charAt(i)==')'){
                if (parentheses.pop()!='('){
                    isBalanced = false;
                }
            }
            if (!isBalanced){
                break;
            }
        }
        if (isBalanced){
            System.out.println("YES");
        }else{
            System.out.println("NO");
        }
    }
}
