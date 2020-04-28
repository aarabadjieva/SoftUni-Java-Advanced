import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Phonebook {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, String> contacts = new HashMap<>();
        String input = scanner.nextLine();
        while (!input.equals("search")){
            String[] contactDetails = input.split("-");
            String name = contactDetails[0];
            String number = contactDetails[1];
            contacts.putIfAbsent(name,number);
            contacts.put(name,number);
            input = scanner.nextLine();
        }
        input = scanner.nextLine();
        while (!input.equals("stop")){
            if (contacts.containsKey(input)){
                System.out.println(input + " -> " + contacts.get(input));
            }else{
                System.out.println("Contact " + input + " does not exist.");
            }
            input = scanner.nextLine();
        }
    }
}
