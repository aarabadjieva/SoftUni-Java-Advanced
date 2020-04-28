package softUniParking;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Parking {
    private Map<String, Car> cars;
    private int capacity;

    public Parking(int capacity) {
        this.capacity = capacity;
        this.cars = new LinkedHashMap<>();
    }

    public String addCar(Car car){
        if (this.cars.containsKey(car.getRegistrationNumber())){
            return "Car with that registration number, already exists!";
        }else if (this.capacity<=0){
            return "Parking is full!";
        }
        this.cars.putIfAbsent(car.getRegistrationNumber(),car);
        this.capacity--;
        return String.format("Successfully added new car %s %s",car.getMake(),car.getRegistrationNumber());
    }

    public String removeCar(String registrationNumber){
        if (!this.cars.containsKey(registrationNumber)){
            return "Car with that registration number, doesn't exists!";
        }
        this.cars.remove(registrationNumber);
        this.capacity++;
        return String.format("Successfully removed %s",registrationNumber);
    }

    public Car getCar(String registrationNumber){
        return this.cars.get(registrationNumber);
    }

    public int getCount(){
        return this.cars.size();
    }

    public void removeSetOfRegistrationNumber(List<String> registrationNumbers){
        for (String regNum: registrationNumbers
             ) {
            removeCar(regNum);
        }
    }
}
