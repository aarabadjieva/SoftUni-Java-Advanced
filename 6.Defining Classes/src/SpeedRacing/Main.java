package SpeedRacing;

import SpeedRacing.Car;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, Car> cars = new LinkedHashMap<>();
        int count = Integer.parseInt(scanner.nextLine());
        while (count-->0){
            String[] data = scanner.nextLine().split("\\s+");
            String name = data[0];
            double fuel = Double.parseDouble(data[1]);
            double fuelCost = Double.parseDouble(data[2]);
            Car car = new Car(name,fuel,fuelCost);
            cars.put(name,car);
        }
        String line = scanner.nextLine();
        while (!line.equals("End")){
            String[] data = line.split("\\s+");
            String name = data[1];
            int distance = Integer.parseInt(data[2]);
            System.out.print(cars.get(name).travel(distance));
            line = scanner.nextLine();
        }
        for (String car: cars.keySet()
             ) {
            System.out.println(cars.get(car).getInfo());
        }
    }
}
