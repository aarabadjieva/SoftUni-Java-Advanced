import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ReadFile {
    public static void main(String[] args) throws IOException {
        String path = "C:\\Users\\User\\Downloads\\javaNeeds\\04. Java-Advanced-Files-and-Streams-Lab-Resources\\input.txt";
        FileInputStream inputStream = null;
        try {
            inputStream = new FileInputStream(path);
            int byteData = inputStream.read();
            while (byteData>=0){
                System.out.print(Integer.toBinaryString(byteData)+" ");
                byteData = inputStream.read();
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }finally {
            if (inputStream!=null){
                inputStream.close();
            }
        }
    }
}
