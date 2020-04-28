import java.io.*;

public class ReadSerialize {
    public static void main(String[] args) {
        String path = "C:\\Users\\User\\Downloads\\javaNeeds\\04. Java-Advanced-Files-and-Streams-Lab-Resources";
        String in = path+"\\input.txt";
        String out = path+"\\7output.txt";

        try {
            ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(in));
            Cube restored = (Cube) objectInputStream.readObject();
            System.out.printf("%s, %f, %f, %f",
                    restored.color,
                    restored.depth,
                    restored.height,
                    restored.width);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
