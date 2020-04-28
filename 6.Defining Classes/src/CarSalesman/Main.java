package CarSalesman;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int enginesCount = Integer.parseInt(scanner.nextLine());
        Map<String, Engine> engines = new LinkedHashMap<>();
        while (enginesCount-->0){
            String[] info = scanner.nextLine().split("\\s+");
            String model = info[0];
            String power = info[1];
            Engine engine = new Engine(model,power);
            if (info.length==4){
                engine.setDisplacement(info[2]);
                engine.setEfficiency(info[3]);
            }else if (info.length==3){
                try {
                    int displacement = Integer.parseInt(info[2]);
                    engine.setDisplacement(info[2]);
                }catch (NumberFormatException e){
                    engine.setEfficiency(info[2]);
                }
            }
            engines.put(model,engine);
        }
        int carsCount = Integer.parseInt(scanner.nextLine());
        List<Car> cars = new ArrayList<>();
        while (carsCount-->0){
            String[] info = scanner.nextLine().split("\\s+");
            String model = info[0];
            Engine engine = engines.get(info[1]);
            Car car = new Car(model,engine);
            if (info.length==4){
                car.setWeight(info[2]);
                car.setColor(info[3]);
            }else if (info.length==3){
                try {
                    int weight = Integer.parseInt(info[2]);
                    car.setWeight(info[2]);
                }catch (NumberFormatException e){
                    car.setColor(info[2]);
                }
            }
            cars.add(car);
        }
        for (Car car:cars
             ) {
            System.out.println(car.toString());
        }
    }
}
