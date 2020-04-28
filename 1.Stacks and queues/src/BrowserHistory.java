import java.util.ArrayDeque;
import java.util.Scanner;

public class BrowserHistory {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String url = scanner.nextLine();
        String current = "";
        ArrayDeque<String> backHistory = new ArrayDeque<>();
        ArrayDeque<String> forwardHistory = new ArrayDeque<>();
        while (!url.equals("Home")) {
            if (url.equals("back")) {
                if (!backHistory.isEmpty()){
                     forwardHistory.push(current);
                     current = backHistory.pop();
                }else{
                    System.out.println("no previous URLs");
                    url = scanner.nextLine();
                    continue;
                }
            } else if (url.equals("forward")){
                if (!forwardHistory.isEmpty()){
                    backHistory.push(current);
                    current = forwardHistory.pop();
                }else{
                    System.out.println("no next URLs");
                    url = scanner.nextLine();
                    continue;
                }
            }else{
                if (!current.equals("")){
                    backHistory.push(current);
                    if (!forwardHistory.isEmpty()){
                        forwardHistory.clear();
                    }
                }
                current = url;
            }
            System.out.println(current);
            url = scanner.nextLine();
        }
    }
}
