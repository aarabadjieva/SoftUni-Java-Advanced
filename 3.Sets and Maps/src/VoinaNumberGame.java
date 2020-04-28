import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Scanner;

public class VoinaNumberGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] firstNumbers = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        int[] secondNumbers = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        LinkedHashSet<Integer> firstPlayerCards = new LinkedHashSet<>();
        LinkedHashSet<Integer> secondPlayerCards = new LinkedHashSet<>();
        for (int card:firstNumbers
             ) {
            firstPlayerCards.add(card);
        }
        for (int card:secondNumbers
             ) {
            secondPlayerCards.add(card);
        }
        int rounds =1;
        while (rounds<=50&&!firstPlayerCards.isEmpty()&&!secondPlayerCards.isEmpty()){
            int player1card = firstPlayerCards.iterator().next();
            int player2card = secondPlayerCards.iterator().next();
            firstPlayerCards.remove(player1card);
            secondPlayerCards.remove(player2card);
            if (player1card>player2card){
                firstPlayerCards.add(player1card);
                firstPlayerCards.add(player2card);
            }else if (player2card>player1card){
                secondPlayerCards.add(player1card);
                secondPlayerCards.add(player2card);
            }
            rounds++;
        }
        if (firstPlayerCards.isEmpty()||firstPlayerCards.size()<secondPlayerCards.size()){
            System.out.println("Second player win!");
        }else if (secondPlayerCards.isEmpty()||secondPlayerCards.size()<firstPlayerCards.size()){
            System.out.println("First player win!");
        }else {
            System.out.println("Draw!");
        }
    }
}
