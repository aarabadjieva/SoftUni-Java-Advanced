import java.io.*;

public class AllCapitals {
    public static void main(String[] args) throws IOException {
        String path = "C:\\Users\\User\\Downloads\\javaNeeds\\04. Java-Advanced-Files-and-Streams-Exercises-Resources";
        String inPath = path + "\\input.txt";
        String outPath = path + "\\output.txt";
        FileInputStream inputStream = new FileInputStream(inPath);
        FileWriter writer = new FileWriter(outPath);
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
        String line = reader.readLine();
        while (line != null) {
            writer.write(line.toUpperCase() + System.lineSeparator());
            line = reader.readLine();
        }
        writer.close();
    }
}
