import java.util.Map;
import java.util.Scanner;
import java.util.StringJoiner;
import java.util.TreeMap;

public class LogsAggregator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int lines = Integer.parseInt(scanner.nextLine());
        Map<String, Map<String, Integer>> allLogs = new TreeMap<>();
        while (lines-->0){
            String[] log = scanner.nextLine().split("\\s+");
            String ip = log[0];
            String user = log[1];
            int duration = Integer.parseInt(log[2]);
            allLogs.putIfAbsent(user,new TreeMap<>());
            allLogs.get(user).putIfAbsent(ip,0);
            allLogs.get(user).put(ip,allLogs.get(user).get(ip)+duration);
        }
        for (String user:allLogs.keySet()
             ) {
            int totalTime = 0;
            StringJoiner joiner = new StringJoiner(", ");
            for (String id:allLogs.get(user).keySet()
                 ) {
                joiner.add(id);
                totalTime+=allLogs.get(user).get(id);
            }
            System.out.printf("%s: %d [%s]\n",user,totalTime,joiner);
        }
    }
}
