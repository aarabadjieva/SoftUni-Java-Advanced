import java.util.*;

public class ClubParty {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int capacity = Integer.parseInt(scanner.nextLine());
        String[] input = scanner.nextLine().split("\\s");
        Deque<String> names = new ArrayDeque<>();
        Deque<String> toCheck = new ArrayDeque<>();
        Map<String, List<Integer>> halls = new LinkedHashMap<>();

        for (int i = 0; i < input.length; i++) {
            toCheck.push(input[i]);
        }
        while (!toCheck.isEmpty()){
            try {
                int comp = Integer.parseInt(toCheck.peek());
                if (!names.isEmpty()){
                    String hall = names.peek();
                    halls.putIfAbsent(hall,new ArrayList<>());
                    if (halls.get(hall).size()<1){
                        halls.get(hall).add(0);
                    }
                    halls.get(hall).set(0,halls.get(hall).get(0)+comp);
                    if (halls.get(hall).get(0)>capacity){
                        System.out.print(hall+" -> ");
                        StringJoiner joiner = new StringJoiner(", ");
                        for (int j = 1; j < halls.get(hall).size(); j++) {
                            joiner.add(String.valueOf(halls.get(hall).get(j)));
                        }
                        System.out.println(joiner);
                        names.pop();
                    }else {
                        halls.get(hall).add(comp);
                        toCheck.pop();
                    }
                }else {
                    toCheck.pop();
                }

            }catch (NumberFormatException e){
                String hall = toCheck.pop();
                names.offer(hall);
            }
        }
    }
}