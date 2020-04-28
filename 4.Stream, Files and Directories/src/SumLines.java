import java.io.*;

public class SumLines {
    public static void main(String[] args) throws IOException {
        String path = "C:\\Users\\User\\Downloads\\javaNeeds\\04. Java-Advanced-Files-and-Streams-Exercises-Resources";
        String inPath = path+"\\input.txt";
        String outPath = path+"\\output.txt";
        FileInputStream inputStream = new FileInputStream(inPath);
        FileWriter writer = new FileWriter(outPath);
        BufferedReader buff = new BufferedReader(new InputStreamReader(inputStream));
        String line = buff.readLine();

        while (line!=null){
            int sum = 0;
            for (int i = 0; i < line.length(); i++) {
                sum+=line.charAt(i);
            }
            writer.write(sum+System.lineSeparator());
            line = buff.readLine();
        }
        writer.close();
    }
}
