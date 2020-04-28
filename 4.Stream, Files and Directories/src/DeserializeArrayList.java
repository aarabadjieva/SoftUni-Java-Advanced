import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

public class DeserializeArrayList {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        ArrayList<Double> arrayList = new ArrayList<Double>();
        FileInputStream fis = new FileInputStream("list.ser");
        ObjectInputStream ois = new ObjectInputStream(fis);
        arrayList = (ArrayList) ois.readObject();
        ois.close();
        fis.close();
        for (Double num:arrayList
             ) {
            System.out.println(num);
        }
    }
}
