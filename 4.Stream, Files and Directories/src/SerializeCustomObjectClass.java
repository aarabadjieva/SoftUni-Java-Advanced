import java.io.*;

public class SerializeCustomObjectClass {
    public static void main(String[] args) throws IOException {
        Course course = new Course();
        course.name = "Java";
        course.students = 46;
        FileOutputStream fos = new FileOutputStream("course.ser");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(course);
        fos.close();
        oos.close();
    }
}
class Course implements Serializable {
    public String name;
    public int students;
}