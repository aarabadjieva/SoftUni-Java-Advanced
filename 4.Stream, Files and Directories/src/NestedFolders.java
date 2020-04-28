import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class NestedFolders {
    public static void main(String[] args) {
        String path = "C:\\Users\\User\\Downloads\\javaNeeds\\04. Java-Advanced-Files-and-Streams-Lab-Resources";
        String in = path+"\\Files-and-Streams";
        String out = path+"\\7output.txt";
        File folderToRead = new File(in);
        PrintWriter writer = null;
        Deque<File> filesToVisit = new ArrayDeque<>();
        int count = 1;
        try {
            writer = new PrintWriter(out);
            filesToVisit.addAll(Arrays.asList(folderToRead.listFiles()));
            writer.println(folderToRead.getName());
            while (!filesToVisit.isEmpty()){
                File currentFile = filesToVisit.poll();
                if (currentFile.isDirectory()){
                    filesToVisit.addAll(Arrays.asList(currentFile.listFiles()));
                    count++;
                    writer.println(currentFile.getName());
                }
            }
            writer.println(count+" folders");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }finally {
            if (writer!=null){
                writer.close();
            }
        }

    }
}
