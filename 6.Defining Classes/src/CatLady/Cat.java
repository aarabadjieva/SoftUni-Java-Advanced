package CatLady;

public class Cat {
    private static double DEFAULT = 0;
    private String breed;
    private String name;
    private double earSize;
    private double furLength;
    private double decibelOfMeows;

    public Cat(String breed, String name) {
        this.breed = breed;
        this.name = name;
        this.earSize = DEFAULT;
        this.furLength = DEFAULT;
        this.decibelOfMeows = DEFAULT;
    }

    public static double getDEFAULT() {
        return DEFAULT;
    }

    public static void setDEFAULT(double DEFAULT) {
        Cat.DEFAULT = DEFAULT;
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getEarSize() {
        return earSize;
    }

    public void setEarSize(double earSize) {
        this.earSize = earSize;
    }

    public double getFurLength() {
        return furLength;
    }

    public void setFurLength(double furLength) {
        this.furLength = furLength;
    }

    public double getDecibelOfMeows() {
        return decibelOfMeows;
    }

    public void setDecibelOfMeows(double decibelOfMeows) {
        this.decibelOfMeows = decibelOfMeows;
    }

    @Override
    public String toString() {
        return String.format("%s %s ",getBreed(),getName());
    }
}
