import java.io.*;

public class LineNumbers {
    public static void main(String[] args) throws IOException {
        String path = "C:\\Users\\User\\Downloads\\javaNeeds\\04. Java-Advanced-Files-and-Streams-Exercises-Resources";
        String inPath = path + "\\inputLineNumbers.txt";
        String outPath = path + "\\output.txt";
        FileInputStream inputStream = new FileInputStream(inPath);
        FileWriter writer = new FileWriter(outPath);
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
        String line = reader.readLine();
        int counter = 1;
        while (line != null) {
            writer.write(counter +". "+ line + System.lineSeparator());
            line = reader.readLine();
            counter++;
        }
        writer.close();
    }
}
