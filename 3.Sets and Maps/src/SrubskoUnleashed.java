import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SrubskoUnleashed {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String nameRegex = "^([a-zA-Z\\ ]+(?=\\ @))";
        String placeRegex = "((?<=\\ @)([a-zA-Z\\ ]+)(?=\\ \\d))";
        String priceRegex = "((?<=[a-zA-Z]\\ )(\\d+)(?=\\ \\d))";
        String countRegex = "(?<=\\d\\ )(\\d+)";
        Pattern name = Pattern.compile(nameRegex);
        Pattern place = Pattern.compile(placeRegex);
        Pattern price = Pattern.compile(priceRegex);
        Pattern count = Pattern.compile(countRegex);
        Map<String,Map<String,Integer>> cities = new LinkedHashMap<>();
        String input = scanner.nextLine();
        while (!input.equals("End")){
            String singer = "";
            String venue = "";
            int pricePerTicket = 0;
            int countOfTickets = 0;
            Matcher nameMatcher = name.matcher(input);
            Matcher placeMatcher = place.matcher(input);
            Matcher priceMatcher = price.matcher(input);
            Matcher countmatcher = count.matcher(input);
            if (nameMatcher.find()){
                if (placeMatcher.find()){
                    if (priceMatcher.find()){
                        if (countmatcher.find()){
                            singer = nameMatcher.group();
                            venue = placeMatcher.group();
                            pricePerTicket = Integer.parseInt(priceMatcher.group());
                            countOfTickets = Integer.parseInt(countmatcher.group());
                            int totalMoneyForConcert = pricePerTicket*countOfTickets;
                            cities.putIfAbsent(venue,new LinkedHashMap<>());
                            cities.get(venue).putIfAbsent(singer, 0);
                            cities.get(venue).put(singer,cities.get(venue).get(singer)+totalMoneyForConcert);
                        }else {
                            continue;
                        }
                    }
                }
            }
            input = scanner.nextLine();
        }
        for (String city:cities.keySet()
        ) {
            System.out.println(city);
            cities.get(city).entrySet().stream().sorted(Collections.reverseOrder(Map.Entry.comparingByValue()))
                    .forEach(e-> System.out.printf("#  %s -> %d\n",e.getKey(),e.getValue()));
        }
    }
}
