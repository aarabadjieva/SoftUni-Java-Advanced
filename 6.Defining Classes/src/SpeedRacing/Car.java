package SpeedRacing;

public class Car {
    private String model;
    private double fuelAmount;
    private double fuelCost;
    private int distanceTraveled;

    public Car(String model, double fuelAmount, double fuelCost) {
        this.model = model;
        this.fuelAmount = fuelAmount;
        this.fuelCost = fuelCost;
        this.distanceTraveled = 0;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public double getFuelAmount() {
        return fuelAmount;
    }

    public void setFuelAmount(double fuelAmount) {
        this.fuelAmount = fuelAmount;
    }

    public double getFuelCost() {
        return fuelCost;
    }

    public void setFuelCost(double fuelCost) {
        this.fuelCost = fuelCost;
    }

    public int getDistanceTraveled() {
        return distanceTraveled;
    }

    public void setDistanceTraveled(int distanceTraveled) {
        this.distanceTraveled = distanceTraveled;
    }
    public String getInfo(){
        return String.format("%s %.2f %d"
                ,getModel(),getFuelAmount(),getDistanceTraveled());
    }
    public String travel(int distance){
        double costToTravel = distance*this.fuelCost;
        if (costToTravel<=this.fuelAmount){
            this.fuelAmount -=costToTravel;
            this.distanceTraveled += distance;
        }else {
            return String.format("Insufficient fuel for the drive%n");
        }
        return "";
    }
}
