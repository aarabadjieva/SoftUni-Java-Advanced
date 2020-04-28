import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.List;

public class SortLines {
    public static void main(String[] args) {
        String path = "C:\\Users\\User\\Downloads\\javaNeeds\\04. Java-Advanced-Files-and-Streams-Lab-Resources";
        String in = path+"\\6.Input.txt";
        String out = path+"\\06.SortLinesOutput.txt";
        Path inputPath = Paths.get(in);
        Path outputPath = Paths.get(out);
        try {
           List<String> allLines =  Files.readAllLines(inputPath);
           Collections.sort(allLines);
           Files.write(outputPath,allLines);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
