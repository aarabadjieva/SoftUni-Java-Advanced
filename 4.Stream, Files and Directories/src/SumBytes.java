import java.io.*;

public class SumBytes {
    public static void main(String[] args) throws IOException {
        String path = "C:\\Users\\User\\Downloads\\javaNeeds\\04. Java-Advanced-Files-and-Streams-Exercises-Resources";
        String inPath = path+"\\input.txt";
        String outPath = path+"\\output.txt";
        FileInputStream inputStream = new FileInputStream(inPath);
        FileWriter writer = new FileWriter(outPath);
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
        String line = reader.readLine();
        long totalSum = 0;
        while (line!=null){
            long sum = 0;
            for (int i = 0; i < line.length(); i++) {
                sum+=line.charAt(i);
            }
            totalSum+=sum;
            line = reader.readLine();
        }
        writer.write(totalSum + System.lineSeparator());
        writer.close();
    }
}
