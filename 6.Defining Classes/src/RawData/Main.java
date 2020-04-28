package RawData;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int count = Integer.parseInt(scanner.nextLine());
        Map<String, Car> cars = new LinkedHashMap<>();
        while (count-->0){
            String[] data = scanner.nextLine().split("\\s+");
            String name = data[0];
            int speed = Integer.parseInt(data[1]);
            int power = Integer.parseInt(data[2]);
            int weight = Integer.parseInt(data[3]);
            String type = data[4];
            Engine engine = new Engine(speed,power);
            Cargo cargo = new Cargo(weight,type);
            List<Tire> tires = new ArrayList<>();
            for (int i = 5; i <12 ; i+=2) {
                double tirePressure = Double.parseDouble(data[i]);
                int tireAge = Integer.parseInt(data[i+1]);
                Tire tire = new Tire(tireAge,tirePressure);
                tires.add(tire);
            }
            Car car = new Car(name,engine,cargo,tires);
            cars.put(name,car);
        }
        String cmd = scanner.nextLine();
        switch (cmd){
            case "fragile":
                for (String car:cars.keySet()
                     ) {
                    if (cars.get(car).getCargo().getType().equals("fragile")){
                        boolean isValid = false;
                        for (int i = 0; i < cars.get(car).getTires().size(); i++) {
                            if (cars.get(car).getTires().get(i).getPressure()<1){
                                isValid = true;
                            }
                        }
                        if (isValid){
                            System.out.println(car);
                        }
                    }
                }
                break;
            case "flamable":
                for (String car: cars.keySet()
                     ) {
                    if (cars.get(car).getCargo().getType().equals("flamable")){
                        if (cars.get(car).getEngine().getPower()>250){
                            System.out.println(car);
                        }
                    }
                }
                break;
        }
    }
}
