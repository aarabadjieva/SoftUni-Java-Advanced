import java.io.*;

public class CopyAPicture {
    public static void main(String[] args) throws IOException {
        String path = "C:\\Users\\User\\Downloads\\javaNeeds";
        String inPath = path+"\\Room.jpg";
        FileInputStream inputStream = new FileInputStream("Room.jpg");
        byte[] buffer = inputStream.readAllBytes();
        FileOutputStream outputStream = new FileOutputStream("copy-Room.jpg");
        outputStream.write(buffer);
        outputStream.close();
    }
}
