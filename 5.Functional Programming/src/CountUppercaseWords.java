import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class CountUppercaseWords {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] words = scanner.nextLine().split("\\s+");
        Predicate<String> isUpperCase = s->Character.isUpperCase(s.charAt(0))||Character.isDigit(s.charAt(0));
        int count = 0;
        List<String> wordsUpperCase = new ArrayList<>();
        for (String word:words
             ) {
            if (isUpperCase.test(word)){
                count++;
                wordsUpperCase.add(word);
            }
        }
        System.out.println(count);
        for (String word:wordsUpperCase
             ) {
            System.out.println(word);
        }
    }
}
