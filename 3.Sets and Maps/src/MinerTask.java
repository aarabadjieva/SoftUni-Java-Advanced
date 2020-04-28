import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class MinerTask {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, Integer> resources = new LinkedHashMap<>();
        String input = scanner.nextLine();
        int lineCount = 1;
        String resource = "";
        while (!input.equals("stop")){
            int quantity = 0;
            if (lineCount%2!=0){
                resources.putIfAbsent(input,quantity);
                resource = input;
            }else {
                quantity = Integer.parseInt(input);
                resources.put(resource,resources.get(resource)+quantity);
            }
            input = scanner.nextLine();
            lineCount++;
        }
        for (String currentRes:resources.keySet()
             ) {
            System.out.println(currentRes + " -> " + resources.get(currentRes));
        }
    }
}
