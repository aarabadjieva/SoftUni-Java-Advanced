import java.util.*;

public class SumOfCoins {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        Map<Integer, Integer> coins = new LinkedHashMap<>();
        Arrays.stream(input
                .replaceAll("Coins: ", "")
                .split(",\\s"))
                .map(Integer::parseInt)
                .sorted((f, s) -> Integer.compare(s, f))
                .forEach(coin -> coins.putIfAbsent(coin, 0));

        String[] neededSum = scanner.nextLine().split(": ");
        int sum = Integer.parseInt(neededSum[1]);
        for (Integer coinValue : coins.keySet()
        ) {
            coins.put(coinValue, sum / coinValue);
            sum = sum % coinValue;
        }
        int totalCoins = 0;
        int totalSum = 0;
        for (Map.Entry<Integer, Integer> coin:coins.entrySet()
             ) {
            totalCoins+=coin.getValue();
            totalSum+=coin.getValue()*coin.getKey();
        }
        if (totalSum==Integer.parseInt(neededSum[1])){
            System.out.println("Number of coins to take: " + totalCoins);
            coins.forEach((key, value) -> {
                if (value > 0) {
                    System.out.printf("%d coin(s) with value %d%n",
                            value, key);
                }
            });
        }else {
            System.out.println("Error");
        }


    }
}
