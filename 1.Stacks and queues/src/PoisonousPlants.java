import java.util.*;

public class PoisonousPlants {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberOfPlants = Integer.parseInt(scanner.nextLine());
        int[] plants = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();
        int[] deathDays = new int[numberOfPlants];
        Deque<Integer> prevStack = new ArrayDeque<>();
        prevStack.push(0);
        for (int i = 0; i < numberOfPlants; i++) {
            int lastDay = 0;
            while (!prevStack.isEmpty()&&plants[prevStack.peek()]>=plants[i]){
                lastDay = Math.max(lastDay, deathDays[prevStack.pop()]);
            }
            if (!prevStack.isEmpty()){
                deathDays[i] = lastDay+1;
            }
            prevStack.push(i);
        }
        int maxDays = 0;
        for (int i = 0; i <deathDays.length ; i++) {
            if (deathDays[i]>=maxDays){
                maxDays = deathDays[i];
            }
        }
        System.out.println(maxDays);
    }
}
