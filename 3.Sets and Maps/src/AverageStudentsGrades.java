import java.util.*;

public class AverageStudentsGrades {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int countOfStudents = Integer.parseInt(scanner.nextLine());
        Map<String, List<Double>> students = new TreeMap<>();
        for (int i = 0; i < countOfStudents; i++) {
            String[] studentGrade = scanner.nextLine().split("\\s+");
            String student = studentGrade[0];
            double grade = Double.parseDouble(studentGrade[1]);
            students.putIfAbsent(student,new ArrayList<>());
            students.get(student).add(grade);
        }
        for (List<Double> grades:students.values()
             ) {
            double average = 0;
            for (int i = 0; i < grades.size(); i++) {
                average+=grades.get(i);
            }
            average = average/grades.size();
            grades.add(average);
        }
        for (String name:students.keySet()
             ) {
            System.out.printf("%s -> ",name);
            for (int i = 0; i < students.get(name).size()-1; i++) {
                System.out.printf("%.2f ",students.get(name).get(i));
            }
            System.out.printf("(avg: %.2f)\n",students.get(name).get(students.get(name).size()-1));
        }
    }
}
