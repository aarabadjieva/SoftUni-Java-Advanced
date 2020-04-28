import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class SerializeCustomObject {
    public static void main(String[] args) {
        Cube cube = new Cube();
        cube.color = "green";
        cube.width = 15.3d;
        cube.height = 12.4d;
        cube.depth = 3.0d;
        String path = "C:\\Users\\User\\Downloads\\javaNeeds\\04. Java-Advanced-Files-and-Streams-Lab-Resources";
        String in = path+"\\input.txt";
        String out = path+"\\7output.txt";

        try {
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(in));
            objectOutputStream.writeObject(cube);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
class Cube implements Serializable{
    public String color;
    public double width;
    public double height;
    public double depth;

}