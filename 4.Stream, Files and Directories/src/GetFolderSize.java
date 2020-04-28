import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Arrays;

public class GetFolderSize {
    public static void main(String[] args) throws FileNotFoundException {
        String path = "C:\\Users\\User\\Downloads\\javaNeeds\\04. Java-Advanced-Files-and-Streams-Exercises-Resources";
        String inPath = path + "\\Exercises Resources";
        String outPath = path + "\\output.txt";
        File file = new File(inPath);
        long sum = Arrays.stream(file.listFiles()).filter(f-> !f.isDirectory())
                .mapToLong(File::length)
                .sum();
        PrintWriter writer = new PrintWriter(outPath);
        writer.println("Folder size: "+sum);
        writer.close();
    }
}
