import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class CopyBytes {
    public static void main(String[] args) throws IOException {
        String path = "C:\\Users\\User\\Downloads\\javaNeeds\\04. Java-Advanced-Files-and-Streams-Lab-Resources";
        String input = path+"\\input.txt";
        String output = path+"\\03.CopyBytesOutput.txt";
        FileInputStream inputStream = null;
        FileOutputStream outputStream = null;
        try {
            inputStream = new FileInputStream(input);
            outputStream = new FileOutputStream(output);
            int byteData = inputStream.read();
            while (byteData>=0) {
                String digit = String.valueOf(byteData);
                if (byteData==32||byteData==10){
                    outputStream.write(byteData);
                }else {
                    for (int i = 0; i < digit.length(); i++) {
                        outputStream.write(digit.charAt(i));
                    }
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
