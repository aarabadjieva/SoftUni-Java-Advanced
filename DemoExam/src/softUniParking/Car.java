package softUniParking;

public class Car {
    private String make;
    private String model;
    private int horsePower;
    private String registrationNumber;

    public Car(String make, String model, int horsepower, String registrationNumber) {
        this.make = make;
        this.model = model;
        this.horsePower = horsepower;
        this.registrationNumber = registrationNumber;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public String getMake() {
        return make;
    }

    public String getModel() {
        return model;
    }

    public int getHorsePower() {
        return horsePower;
    }

    @Override
    public String toString() {
        return String.format("Make: %s%nModel: %s%n" +
                "HorsePower: %d%nRegistrationNumber: %s"
                ,this.make,this.model,
                this.horsePower,this.registrationNumber);
    }
}
