import java.io.*;
import java.util.LinkedHashMap;
import java.util.Map;

public class WordCount {
    public static void main(String[] args) throws IOException {
        String path = "C:\\Users\\User\\Downloads\\javaNeeds\\04. Java-Advanced-Files-and-Streams-Exercises-Resources";
        String inPath = path + "\\words.txt";
        String outPath = path + "\\output.txt";
        String  secondInPath = path + "\\text.txt";
        FileInputStream inputStream = new FileInputStream(inPath);
        FileWriter writer = new FileWriter(outPath);
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
        String line = reader.readLine();
        Map<String, Integer> words = new LinkedHashMap<>();
        while (line!=null){
            String[] wordsToAdd = line.split(" ");
            for (String word:wordsToAdd
                 ) {
                words.put(word,0);
            }
            line = reader.readLine();
        }
        inputStream = new FileInputStream(secondInPath);
        reader = new BufferedReader(new InputStreamReader(inputStream));
        line = reader.readLine();
        while (line!=null){
            String[] wordsToCheck = line.split("\\s+");
            for (String word:wordsToCheck
                 ) {
                if (words.containsKey(word)){
                    words.put(word,words.get(word)+1);
                }
            }
            line = reader.readLine();
        }
        for (String word:words.keySet()
             ) {
            writer.write(word+" - "+words.get(word)+System.lineSeparator());
        }
        writer.close();
    }
}
