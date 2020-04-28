package CatLady;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, Cat> cats = new LinkedHashMap<>();
        String line = scanner.nextLine();
        while (!line.equals("End")){
            String[] data = line.split("\\s+");
            String type = data[0];
            String name = data[1];
            Cat cat = new Cat(type,name);
            double specific = Double.parseDouble(data[2]);
            switch (type){
                case "Siamese":
                    cat.setEarSize(specific);
                    break;
                case "Cymric":
                    cat.setFurLength(specific);
                    break;
                case "StreetExtraordinaire":
                    cat.setDecibelOfMeows(specific);
                    break;
            }
            cats.put(name,cat);
            line = scanner.nextLine();
        }
        String catName = scanner.nextLine();
        if (cats.containsKey(catName)){
            System.out.print(cats.get(catName).toString());
            if (cats.get(catName).getBreed().equals("Siamese")){
                System.out.printf("%.2f",cats.get(catName).getEarSize());
            }else if (cats.get(catName).getBreed().equals("Cymric")){
                System.out.printf("%.2f",cats.get(catName).getFurLength());
            }else {
                System.out.printf("%.2f",cats.get(catName).getDecibelOfMeows());
            }
        }
    }
}
