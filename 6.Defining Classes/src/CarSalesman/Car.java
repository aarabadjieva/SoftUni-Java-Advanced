package CarSalesman;

public class Car {
    private static final String DEFAULT = "n/a";
    private String model;
    private Engine engine;
    private String weight;
    private String color;

    public Car(String model, Engine engine) {
        this.model = model;
        this.engine = engine;
        this.weight = DEFAULT;
        this.color = DEFAULT;
    }

    public static String getDEFAULT() {
        return DEFAULT;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Engine getEngine() {
        return engine;
    }

    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
       return String.format("%s:%n%sWeight: %s%nColor: %s",
               getModel(),getEngine().toString(),getWeight(),getColor());
    }
}
