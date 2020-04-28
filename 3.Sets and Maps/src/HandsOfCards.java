import java.util.*;

public class HandsOfCards {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, Set<String>> players = new LinkedHashMap<>();
        String input = scanner.nextLine();
        while (!input.equals("JOKER")) {
            String[] playerAndCards = input.split(": ");
            String name = playerAndCards[0];
            String[] cardsArray = playerAndCards[1].split(", ");
            Set<String> cards = new HashSet<>(Arrays.asList(cardsArray));
            players.putIfAbsent(name, new HashSet<>());
            players.get(name).addAll(cards);
            input = scanner.nextLine();
        }
        for (String player : players.keySet()
        ) {
            int power = getPower(players.get(player));
            System.out.println(player+": "+power);
        }
    }

    private static int getPower(Set<String> cards) {
        int totalPower = 0;
        int power = 0;
        for (String card : cards
        ) {
            char[] cardParts = card.toCharArray();
            int number = 0;
            int multiplier = 0;
            switch (cardParts[0]) {
                case '1':
                    number = 10;
                    break;
                case 'J':
                    number = 11;
                    break;
                case 'Q':
                    number = 12;
                    break;
                case 'K':
                    number = 13;
                    break;
                case 'A':
                    number = 14;
                    break;
                default:
                    number = Character.getNumericValue(cardParts[0]);
            }
            if (cardParts[1]=='0'){
                cardParts[1]=cardParts[2];
            }
            switch (cardParts[1]){
                case 'S':
                    multiplier = 4;
                    break;
                case 'H':
                    multiplier = 3;
                    break;
                case 'D':
                    multiplier = 2;
                    break;
                case 'C':
                    multiplier = 1;
                    break;

            }
            power = number*multiplier;
            totalPower+=power;
        }
        return totalPower;
    }
}
