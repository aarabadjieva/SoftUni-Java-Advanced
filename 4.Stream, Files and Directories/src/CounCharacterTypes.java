import java.io.*;
import java.util.List;

public class CounCharacterTypes {
    public static void main(String[] args) throws IOException {
        String path = "C:\\Users\\User\\Downloads\\javaNeeds\\04. Java-Advanced-Files-and-Streams-Exercises-Resources";
        String inPath = path + "\\input.txt";
        String outPath = path + "\\output.txt";
        FileInputStream inputStream = new FileInputStream(inPath);
        FileWriter writer = new FileWriter(outPath);
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
        String line = reader.readLine();
        int vowelsCount = 0;
        int punktuationCount = 0;
        int consonantsCount = 0;
        List<Character> vowels = List.of('a','e','o','u','i');
        List<Character> punctuation = List.of('?','!',',','.');
        while (line!=null){
            for (int i = 0; i < line.length(); i++) {
                char symbol = line.charAt(i);
                if (vowels.contains(symbol)){
                    vowelsCount++;
                }else if (punctuation.contains(symbol)){
                    punktuationCount++;
                }else if (symbol==' '){
                    continue;
                }else {
                    consonantsCount++;
                }
            }
            line = reader.readLine();
        }
        writer.write("Vowels: "+vowelsCount+System.lineSeparator()+
                "Consonants: "+consonantsCount+System.lineSeparator()+
                "Punctuation: "+punktuationCount+System.lineSeparator());
        writer.close();
    }
}
