import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class CountSymbols {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char[] input = scanner.nextLine().toCharArray();
        Map<Character, Integer> characters = new TreeMap<>();
        for (char symbol:input
             ) {
            characters.putIfAbsent(symbol, 0);
            characters.put(symbol,characters.get(symbol)+1);
        }
        for (char symbol:characters.keySet()
             ) {
            System.out.printf("%c: %d time/s\n",symbol,characters.get(symbol));
        }
    }
}
