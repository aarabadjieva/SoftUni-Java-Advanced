import java.io.*;
import java.util.Scanner;
import java.util.regex.Pattern;

public class ExtractIntegers {
    public static void main(String[] args) throws IOException {
        String path = "C:\\Users\\User\\Downloads\\javaNeeds\\04. Java-Advanced-Files-and-Streams-Lab-Resources";
        String in = path+"\\input.txt";
        String out = path+"\\04.ExtractIntegersOutput.txt";
        Scanner inputStream = null;
        FileWriter outputStream = null;
        try {
            inputStream = new Scanner(new FileInputStream(in));
            outputStream = new FileWriter(out);
           while (inputStream.hasNext()){
               if (inputStream.hasNextInt()){
                  outputStream.write(String.valueOf(inputStream.nextInt()));
                  outputStream.write('\n');
               }
               inputStream.next();
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
