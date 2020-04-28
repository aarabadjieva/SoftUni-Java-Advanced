import java.util.*;

public class BasicStackOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] limits = scanner.nextLine().split(" ");
        Deque<Integer> numbers = new ArrayDeque<>();
        int elementsToPush = Integer.parseInt(limits[0]);
        int elementsToPop = Integer.parseInt(limits[1]);
        int elementToFind = Integer.parseInt(limits[2]);

        Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .limit(elementsToPush)
                .forEach(numbers::push);
        while (elementsToPop-->0){
            numbers.pop();
        }
        if (numbers.contains(elementToFind)){
            System.out.println("true");
        }else {
            int minNum = Integer.MAX_VALUE;
            if (numbers.isEmpty()){
                System.out.println("0");
            }else {
                while (!numbers.isEmpty()) {
                    int current = numbers.pop();
                    if (current < minNum) {
                        minNum = current;
                    }
                }
                System.out.println(minNum);
            }
        }
    }
}
