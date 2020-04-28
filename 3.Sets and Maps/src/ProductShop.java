import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class ProductShop {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, Map<String, Double>> shops = new TreeMap<>();
        String input = scanner.nextLine();
        while (!input.equals("Revision")){
            String[] shopAndProduct = input.split(",\\s+");
            String shop = shopAndProduct[0];
            String product = shopAndProduct[1];
            double price = Double.parseDouble(shopAndProduct[2]);
            shops.putIfAbsent(shop, new LinkedHashMap<>());
            shops.get(shop).putIfAbsent(product, price);
            shops.get(shop).put(product,price);
            input = scanner.nextLine();
        }
        for (String shop:shops.keySet()
             ) {
            System.out.println(shop+"->");
            for (String product:shops.get(shop).keySet()
                 ) {
                System.out.printf("Product: %s, Price: %.1f\n",product,shops.get(shop).get(product));
            }
        }
    }
}
