import java.util.*;

public class UserLogs {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, Map<String, Integer>> usernames = new TreeMap<>();
        String input = scanner.nextLine();
        while (!input.equals("end")){
            String[] cmd = input.split("\\s+");
            String [] ipNumber = cmd[0].split("=");
            String id = ipNumber[1];
            String[] usernameAndUser = cmd[2].split("=");
            String username = usernameAndUser[1];
            usernames.putIfAbsent(username,new LinkedHashMap<>());
            usernames.get(username).putIfAbsent(id,0);
            usernames.get(username).put(id,usernames.get(username).get(id)+1);
            input = scanner.nextLine();
        }
        for (String user:usernames.keySet()
             ) {
            System.out.println(user+":");
            StringJoiner joiner = new StringJoiner(", ");
            for (String idNum:usernames.get(user).keySet()
                 ) {
                String currentID = idNum + " => " + usernames.get(user).get(idNum).toString();
                joiner.add(currentID);
            }
            System.out.println(joiner+".");
        }
    }
}
