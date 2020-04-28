import java.io.*;
import java.util.LinkedHashMap;
import java.util.Map;

public class MergeTwoFiles {
    public static void main(String[] args) throws IOException {
        String path = "C:\\Users\\User\\Downloads\\javaNeeds\\04. Java-Advanced-Files-and-Streams-Exercises-Resources";
        String inPath = path + "\\inputOne.txt";
        String outPath = path + "\\output.txt";
        String  secondInPath = path + "\\inputTwo.txt";
        FileInputStream inputStream = new FileInputStream(inPath);
        FileWriter writer = new FileWriter(outPath);
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
        String line = reader.readLine();
        while (line!=null){
           writer.write(line + System.lineSeparator());
            line = reader.readLine();
        }
        inputStream = new FileInputStream(secondInPath);
        reader = new BufferedReader(new InputStreamReader(inputStream));
        line = reader.readLine();
        while (line!=null){
            writer.write(line + System.lineSeparator());
            line = reader.readLine();
        }
        writer.close();
    }
}
