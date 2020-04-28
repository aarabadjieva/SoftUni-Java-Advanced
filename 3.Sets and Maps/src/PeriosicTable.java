import java.util.*;

public class PeriosicTable {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int count = Integer.parseInt(scanner.nextLine());
        Set<String> elements = new TreeSet<>();
        for (int i = 0; i < count; i++) {
            String[] input = scanner.nextLine().split("\\s+");
            Collections.addAll(elements, input);
        }
        for (String element : elements
        ) {
            System.out.print(element + " ");
        }
    }
}
