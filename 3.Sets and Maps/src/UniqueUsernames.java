import java.util.*;

public class UniqueUsernames {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int countOfUsernames = Integer.parseInt(scanner.nextLine());
        Set<String> uniqueUsernames = new LinkedHashSet<>();
        for (int i = 0; i < countOfUsernames; i++) {
            String username = scanner.nextLine();
            uniqueUsernames.add(username);
        }
        StringJoiner joiner = new StringJoiner("\n");
        for (String username:uniqueUsernames
             ) {
            joiner.add(username);
        }
        System.out.print(joiner);
    }
}
