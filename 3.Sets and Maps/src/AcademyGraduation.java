import com.sun.source.tree.Tree;
import java.util.Arrays;
import java.util.Scanner;
import java.util.TreeMap;

public class AcademyGraduation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberOfStudents = Integer.parseInt(scanner.nextLine());
        TreeMap<String, double[]> students = new TreeMap<>();
        for (int i = 0; i < numberOfStudents; i++) {
            String name = scanner.nextLine();
            double[] grades = Arrays.stream(scanner.nextLine().split("\\s+")).mapToDouble(Double::parseDouble).toArray();
            students.putIfAbsent(name,grades);
        }
        for (String student:students.keySet()
             ) {
            double average = 0;
            for (int i = 0; i < students.get(student).length; i++) {
                average+=students.get(student)[i];
            }
            average = average/students.get(student).length;
            System.out.println(student+" is graduated with "+average);
        }
    }
}
