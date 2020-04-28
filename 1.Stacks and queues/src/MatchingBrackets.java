import java.util.ArrayDeque;
import java.util.Scanner;

public class MatchingBrackets {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayDeque<Integer> bracketIndexes = new ArrayDeque<>();
        String input = scanner.nextLine();
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == '('){
                bracketIndexes.push(i);
            }
            if (input.charAt(i) == ')'){
                int startIndex = bracketIndexes.pop();
                System.out.println(input.substring(startIndex,i+1));
            }
        }
    }
}
