import java.util.*;

public class PopulationCounter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String,Map<String,Long>> countries = new LinkedHashMap<>();
        String input = scanner.nextLine();
        while (!input.equals("report")){
            String[] information = input.split("\\|");
            String country = information[1];
            String city = information[0];
            long population = Long.parseLong(information[2]);
            countries.putIfAbsent(country, new LinkedHashMap<>());
            countries.get(country).putIfAbsent(city, (long) 0);
            countries.get(country).put(city,countries.get(country).get(city)+population);
            input = scanner.nextLine();
        }
        Map<String, Long> countriesByPopulation = new LinkedHashMap<>();
        for (String country:countries.keySet()
             ) {
            long totalPopulation = 0;
            for (String city:countries.get(country).keySet()
                 ) {
                totalPopulation+=countries.get(country).get(city);
            }
            countriesByPopulation.put(country,totalPopulation);
        }
        countriesByPopulation.entrySet().stream().sorted(Collections.reverseOrder(Map.Entry.comparingByValue()))
                .forEach(country ->{
                    System.out.printf("%s (total population: %d)\n",country.getKey(),country.getValue());
                    countries.get(country.getKey()).entrySet().stream().sorted(Collections.reverseOrder(Map.Entry.comparingByValue()))
                            .forEach(city -> {
                                System.out.printf("=>%s: %d\n",city.getKey(),city.getValue());
                            });
                });
    }
}
