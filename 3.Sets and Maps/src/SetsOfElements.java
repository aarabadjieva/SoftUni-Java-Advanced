import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class SetsOfElements {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] sizes = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        int firstSize = sizes[0];
        int secondSize = sizes[1];
        Set<Integer> firstDeck = new LinkedHashSet<>();
        Set<Integer> secondDeck = new LinkedHashSet<>();
        for (int i = 0; i < firstSize; i++) {
            firstDeck.add(Integer.parseInt(scanner.nextLine()));
        }
        for (int i = 0; i < secondSize; i++) {
            secondDeck.add(Integer.parseInt(scanner.nextLine()));
        }
        for (int number:firstDeck
             ) {
            if (secondDeck.contains(number)){
                System.out.print(number+" ");
            }
        }
    }
}
