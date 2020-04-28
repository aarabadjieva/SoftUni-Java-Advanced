import java.util.*;

public class DragonArmy {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, Map<String, List<Double>>> dragons = new LinkedHashMap<>();
        Map<String, List<Double>> stats = new LinkedHashMap<>();
        int numberOfDragons = Integer.parseInt(scanner.nextLine());
        while (numberOfDragons-->0){
            String[] dragonInfo = scanner.nextLine().split("\\s+");
            String color = dragonInfo[0];
            String name = dragonInfo[1];
            if (dragonInfo[2].equals("null")){
                dragonInfo[2] = "45";
            }
            if (dragonInfo[3].equals("null")){
                dragonInfo[3] = "250";
            }
            if (dragonInfo[4].equals("null")){
                dragonInfo[4] = "10";
            }
            double damage = Double.parseDouble(dragonInfo[2]);
            double health = Double.parseDouble(dragonInfo[3]);
            double armor = Double.parseDouble(dragonInfo[4]);
            dragons.putIfAbsent(color, new TreeMap<>());
            if (!stats.containsKey(color)){
                stats.put(color, new ArrayList<>());
                stats.get(color).add(0,0.0);
                stats.get(color).add(1,0.0);
                stats.get(color).add(2,0.0);
            }

            if (!dragons.get(color).containsKey(name)){
                dragons.get(color).put(name, new ArrayList<>());
                stats.get(color).set(0,stats.get(color).get(0)+damage);
                stats.get(color).set(1,stats.get(color).get(1)+health);
                stats.get(color).set(2,stats.get(color).get(2)+armor);
            }else {
                stats.get(color).set(0,stats.get(color).get(0)-dragons.get(color).get(name).get(0)+damage);
                stats.get(color).set(1,stats.get(color).get(1)-dragons.get(color).get(name).get(1)+health);
                stats.get(color).set(2,stats.get(color).get(2)-dragons.get(color).get(name).get(2)+armor);
            }
            dragons.get(color).get(name).add(0,damage);
            dragons.get(color).get(name).add(1,health);
            dragons.get(color).get(name).add(2,armor);
        }
        for (String color:dragons.keySet()
             ) {
            double avgDamage = stats.get(color).get(0)/dragons.get(color).size();
            double avgHealth = stats.get(color).get(1)/dragons.get(color).size();
            double avgArmor = stats.get(color).get(2)/dragons.get(color).size();
            System.out.printf("%s::(%.2f/%.2f/%.2f)\n",color,avgDamage,avgHealth,avgArmor);
            for (String dragon:dragons.get(color).keySet()
                 ) {
                System.out.printf("-%s -> damage: %.0f, health: %.0f, armor: %.0f\n",dragon,dragons.get(color).get(dragon).get(0),
                        dragons.get(color).get(dragon).get(1),dragons.get(color).get(dragon).get(2));
            }
        }
    }
}
