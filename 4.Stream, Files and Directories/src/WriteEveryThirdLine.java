import java.io.*;

public class WriteEveryThirdLine {
    public static void main(String[] args) throws IOException {
        String path = "C:\\Users\\User\\Downloads\\javaNeeds\\04. Java-Advanced-Files-and-Streams-Lab-Resources";
        String in = path+"\\input.txt";
        String out = path+"\\05.WriteEveryThirdLineOutput.txt";
        BufferedReader breader = null;
        PrintWriter writer = null;
        int row = 1;
        try {
            breader = new BufferedReader(new FileReader(in));
            writer = new PrintWriter(new FileWriter(out));
            String line = breader.readLine();
            while (line!=null) {
                if (row % 3 == 0) {
                    writer.println(line);
                }
                row++;
                line = breader.readLine();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }finally {
            if (breader!=null){
                breader.close();
            }
            if (writer!=null){
                writer.close();
            }
        }
    }
}
