import java.util.*;

public class LegendaryFarming {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String,Integer> legendary = new TreeMap<>();
        String shadowmourne = "shards";
        String valanyr = "fragments";
        String dragonwrath = "motes";
        legendary.put(shadowmourne,0);
        legendary.put(valanyr,0);
        legendary.put(dragonwrath,0);
        Map<String, Integer> junk = new TreeMap<>();
        while (legendary.get(shadowmourne)<250&&legendary.get(valanyr)<250&&legendary.get(dragonwrath)<250){
            String[] input = scanner.nextLine().split("\\s+");
            for (int i = 0; i <input.length ; i+=2) {
                String fragment = input[i+1].toLowerCase();
                int quantity = Integer.parseInt(input[i]);
                if (fragment.equalsIgnoreCase(shadowmourne)||fragment.equalsIgnoreCase(valanyr)||fragment.equalsIgnoreCase(dragonwrath)){
                    legendary.put(fragment,legendary.get(fragment)+quantity);
                    if (legendary.get(fragment)>=250){
                        break;
                    }
                }else {
                    junk.putIfAbsent(fragment,0);
                    junk.put(fragment,junk.get(fragment)+quantity);
                }
            }
        }
        if (legendary.get(shadowmourne)>=250){
            legendary.put(shadowmourne,legendary.get(shadowmourne)-250);
            System.out.println("Shadowmourne obtained!");
            legendary.entrySet().stream().sorted(Collections.reverseOrder(Map.Entry.comparingByValue())).forEach(e-> System.out.println(e.getKey()+": "+e.getValue()));
        }
        if (legendary.get(valanyr)>=250){
            legendary.put(valanyr,legendary.get(valanyr)-250);
            System.out.println("Valanyr obtained!");
            legendary.entrySet().stream().sorted(Collections.reverseOrder(Map.Entry.comparingByValue())).forEach(e-> System.out.println(e.getKey()+": "+e.getValue()));
        }
        if (legendary.get(dragonwrath)>=250){
            legendary.put(dragonwrath,legendary.get(dragonwrath)-250);
            System.out.println("Dragonwrath obtained!");
            legendary.entrySet().stream().sorted(Collections.reverseOrder(Map.Entry.comparingByValue())).forEach(e-> System.out.println(e.getKey()+": "+e.getValue()));
        }
        junk.entrySet().stream().forEach(e-> System.out.println(e.getKey()+": "+e.getValue()));
    }
}
