import java.io.*;
import java.util.ArrayList;

public class SerializeArrayList {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        ArrayList<Double> list = new ArrayList<>();
        list.add(3.14);
        list.add(5.15);
        list.add(3.889);
        list.add(155.20);
        FileOutputStream fileOutputStream = new FileOutputStream("list.ser");
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
        objectOutputStream.writeObject(list);
        objectOutputStream.close();
        fileOutputStream.close();

    }
}
