import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;

public class WriteToFile {
    public static void main(String[] args) throws IOException {
        String path = "C:\\Users\\User\\Downloads\\javaNeeds\\04. Java-Advanced-Files-and-Streams-Lab-Resources";
        String inputPath = path+"\\input.txt";
        String outputPath = path+"\\02.WriteToFileOutput.txt";
        FileInputStream inputStream = null;
        FileOutputStream outputStream = null;
        Set<Character> punctuation = Set.of(',','.','?','!');
        try {
            inputStream = new FileInputStream(inputPath);
            outputStream = new FileOutputStream(outputPath);
            int byteData = inputStream.read();
            while (byteData>=0){
                if (!punctuation.contains((char)byteData)) {
                    outputStream.write(byteData);
                }
                byteData = inputStream.read();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if (inputStream!=null){
                inputStream.close();
            }
            if (outputStream!=null){
                outputStream.close();
            }
        }
    }
}
