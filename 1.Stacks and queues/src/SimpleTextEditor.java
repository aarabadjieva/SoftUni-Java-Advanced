import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class SimpleTextEditor {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberOFOperations = Integer.parseInt(scanner.nextLine());
        Deque<StringBuilder> undo = new ArrayDeque<>();
        StringBuilder text = new StringBuilder();
        undo.push(new StringBuilder(text));
        for (int i = 0; i < numberOFOperations; i++) {
            String[] cmd = scanner.nextLine().split(" ");
            String command = cmd[0];
            switch (command){
                case "1":
                    String textToAppend = cmd[1];
                    text.append(textToAppend);
                    undo.push(new StringBuilder(text));
                    break;
                case "2":
                    int counterToRemove = Integer.parseInt(cmd[1]);
                    text.delete(text.length()-counterToRemove, text.length());
                    undo.push(new StringBuilder(text));
                    break;
                case "3":
                    int index = Integer.parseInt(cmd[1]);
                    System.out.println(text.charAt(index-1));
                    break;
                case "4":
                    undo.pop();
                    text = undo.peek();
                    break;
            }
        }
    }
}
