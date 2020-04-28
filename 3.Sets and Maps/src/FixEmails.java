import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class FixEmails {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, String> names = new LinkedHashMap<>();
        String input = scanner.nextLine();
        int lineCounter = 1;
        String name = "";
        String email = "";
        while (!input.equals("stop")){
            if (lineCounter%2!=0){
                name = input;
                names.putIfAbsent(name,email);
            }else {
                String[] emailHost = input.split("\\.");
                email = input;
                if (emailHost[1].equalsIgnoreCase("uk")||
                        emailHost[1].equalsIgnoreCase("com")||
                        emailHost[1].equalsIgnoreCase("us")){
                    names.remove(name);
                }else {
                    names.put(name, email);
                }
            }
            lineCounter++;
            input=scanner.nextLine();
        }
        for (String user:names.keySet()
             ) {
            System.out.println(user + " -> " + names.get(user));
        }
    }
}
