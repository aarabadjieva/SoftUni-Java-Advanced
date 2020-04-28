import java.util.*;

public class CitiesByContinentAndCountry {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int countOfCountries = Integer.parseInt(scanner.nextLine());
        LinkedHashMap<String, Map<String, List<String>>> continentsAndCountries = new LinkedHashMap<>();
        for (int i = 0; i < countOfCountries; i++) {
            String[] input = scanner.nextLine().split("\\s+");
            String continent = input[0];
            String country = input[1];
            String city = input[2];
            continentsAndCountries.putIfAbsent(continent, new LinkedHashMap<>());
            continentsAndCountries.get(continent).putIfAbsent(country, new ArrayList<>());
            continentsAndCountries.get(continent).get(country).add(city);
        }
        for (String continent:continentsAndCountries.keySet()
             ) {
            System.out.println(continent+":");
            for (String country:continentsAndCountries.get(continent).keySet()
                 ) {
                System.out.print("  "+country+" -> ");
                List<String> cities = continentsAndCountries.get(continent).get(country);
                StringJoiner joiner = new StringJoiner(", ");
                for (String city:cities
                     ) {
                    joiner.add(city);
                }
                System.out.println(joiner.toString());
            }
        }
    }
}
