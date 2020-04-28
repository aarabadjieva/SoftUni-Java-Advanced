import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

public class DeserializeCustomObject {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Course course = new Course();
        FileInputStream fis = new FileInputStream("course.ser");
        ObjectInputStream ois = new ObjectInputStream(fis);
        course = (Course) ois.readObject();
        fis.close();
        ois.close();
        System.out.println(course.name+System.lineSeparator()+course.students);
    }
}
