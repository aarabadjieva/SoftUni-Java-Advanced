import java.util.ArrayDeque;
import java.util.Scanner;

public class PrinterQueue {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        ArrayDeque<String> documents = new ArrayDeque<>();
        while (!input.equals("print")){
            if (input.equals("cancel")){
                if (documents.isEmpty()){
                    System.out.println("Printer is on standby");
                }else {
                    System.out.println("Canceled " + documents.poll());
                }
            }
            else{
                documents.offer(input);
            }
            input = scanner.nextLine();
        }
        while (!documents.isEmpty()){
            System.out.println(documents.poll());
        }
    }
}
