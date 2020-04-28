import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Agency {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Deque<String> ids = new ArrayDeque<>();
        List<String> numbers = Arrays.stream(scanner.nextLine().split("\\s+"))
                .collect(Collectors.toList());
        Deque<String> agents = new ArrayDeque<>();
        List<String> names = Arrays.stream(scanner.nextLine().split("\\s+")).collect(Collectors.toList());
        for (String name:names
             ) {
            agents.offer(name);
        }
        String line = scanner.nextLine();
        while (!line.equals("stop")){
            String[] cmd = line.split("\\s+");
            switch (cmd[0]){
                case "add-ID":
                    numbers.add(cmd[1]);
                    break;
                case "add-agent":
                    agents.offer(cmd[1]);
                    break;
                case "remove-ID":
                    String toRemove = numbers.get(numbers.size()-1);
                    numbers.remove(numbers.size()-1);
                    System.out.println(toRemove+" has been removed.");
                    break;
                case "remove-agent":
                    System.out.println(agents.pollLast() + " has left the queue.");
                    break;
                case "sort-ID":
                    Collections.sort(numbers);
                    break;
            }
            line = scanner.nextLine();
        }
        for (String num:numbers
        ) {
            ids.push(num);
        }
        int agentsSize = agents.size();
        for (int i = 0; i < agentsSize; i++) {
            System.out.print(agents.poll());
            if (!ids.isEmpty()){
                System.out.println(" takes ID number: " + ids.pop());
            }else {
                System.out.println(" does not have an ID.");
            }
        }
        if (!ids.isEmpty()){
            System.out.println("No more agents left.");
            for (String id:ids
                 ) {
                System.out.println("ID number: " + id);
            }
        }
    }
}
