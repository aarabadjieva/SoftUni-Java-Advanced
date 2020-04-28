import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Scanner;

public class CountRealNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LinkedHashMap<Double,Integer> numbersCount = new LinkedHashMap<>();
        double[] numbers = Arrays.stream(scanner.nextLine().split(" "))
                .mapToDouble(Double::parseDouble).toArray();
        for (double num: numbers
             ) {
            if (!numbersCount.containsKey(num)){
                numbersCount.put(num,1);
            }else {
               int count = numbersCount.get(num)+1;
               numbersCount.put(num,count);
            }
        }
        for (Double num:numbersCount.keySet()
             ) {
            System.out.printf("%.1f -> %d%n",num,numbersCount.get(num));
        }
    }
}
