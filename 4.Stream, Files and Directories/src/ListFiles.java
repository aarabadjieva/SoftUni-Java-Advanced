import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class ListFiles {
    public static void main(String[] args) {
        String path = "C:\\Users\\User\\Downloads\\javaNeeds\\04. Java-Advanced-Files-and-Streams-Lab-Resources";
        String in = path+"\\Files-and-Streams";
        String out = path+"\\7output.txt";
        File folderToRead = new File(in);
        PrintWriter writer = null;
        try {
            writer = new PrintWriter(out);
            File[] files = folderToRead.listFiles();
            for (File file:files
            ) {
                if (!file.isDirectory()){
                    writer.printf("%s: [%d]\n", file.getName(),file.length());
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }finally {
            if (writer!=null){
                writer.close();
            }
        }

    }
}
