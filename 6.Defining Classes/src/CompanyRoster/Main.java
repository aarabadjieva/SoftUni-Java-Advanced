package CompanyRoster;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int count = Integer.parseInt(scanner.nextLine());
        Map<String, List<Employee>> departments = new LinkedHashMap<>();
        Map<String, Double> average = new LinkedHashMap<>();
        while (count-- > 0) {
            String[] data = scanner.nextLine().split("\\s+");
            departments.putIfAbsent(data[3], new ArrayList<>());
            String name = data[0];
            double salary = Double.parseDouble(data[1]);
            String position = data[2];
            String department = data[3];
            average.putIfAbsent(data[3], 0.0);
            Employee employee = new Employee(name, salary, position, department);
            if (data.length == 5) {
                if (data[4].contains("@")) {
                    employee.setEmail(data[4]);
                } else {
                    employee.setAge(Integer.parseInt(data[4]));
                }
            } else if (data.length == 6) {
                employee.setEmail(data[4]);
                employee.setAge(Integer.parseInt(data[5]));
            }
            departments.get(department).add(employee);
            average.put(department, average.get(department) + salary);
        }
        String bestDepartment = "";
        double maxAverageSalary = 0;
        for (String avrg:average.keySet()
             ) {
            double averageSalary = average.get(avrg)/departments.get(avrg).size();
            if (averageSalary>maxAverageSalary){
                maxAverageSalary = averageSalary;
                bestDepartment = avrg;
            }
        }
        System.out.printf("Highest Average Salary: %s%n",bestDepartment);
        departments.get(bestDepartment).stream()
                .sorted(Comparator.comparing(Employee::getSalary).reversed())
                .forEach(e-> System.out.println(e.getInfo()));
    }
}
