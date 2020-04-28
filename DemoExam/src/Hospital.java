import java.util.*;

public class Hospital {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, List<List<String>>> departments = new LinkedHashMap<>();
        Map<String, List<String>> doctors = new LinkedHashMap<>();
        String line = scanner.nextLine();
        while (!line.equals("Output")){
            String[] input = line.split("\\s+");
            String department = input[0];
            String doctor = input[1] + " " + input[2];
            String patient = input[3];
            departments.putIfAbsent(department,new ArrayList<>());
            doctors.putIfAbsent(doctor, new ArrayList<>());
            for (int row = 0; row < 20; row++) {
                boolean isAdded = false;
                if (departments.get(department).size()<=row) {
                    departments.get(department).add(new ArrayList<>());
                }
                    if (departments.get(department).get(row).size()<3){
                        departments.get(department).get(row).add(patient);
                        isAdded = true;
                    }
                    if (isAdded){
                        break;
                    }
            }
            doctors.get(doctor).add(patient);
            line = scanner.nextLine();
        }
        line = scanner.nextLine();
        while (!line.equals("End")){
            String[] cmd = line.split("\\s+");
            if (cmd.length==1){
                for (int row = 0; row < departments.get(cmd[0]).size(); row++) {
                    for (int col = 0; col < departments.get(cmd[0]).get(row).size(); col++) {
                        String patient = departments.get(cmd[0]).get(row).get(col);
                            System.out.println(patient);
                    }
                }
            }else {
                if (departments.containsKey(cmd[0])){
                    int roomNumber = Integer.parseInt(cmd[1]) - 1;
                    departments.get(cmd[0]).get(roomNumber).stream().sorted().forEach(System.out::println);

                }else if (doctors.containsKey(cmd[0] + " " + cmd[1])){
                    doctors.get(cmd[0] + " " + cmd[1]).stream().sorted().forEach(System.out::println);
                }
            }
            line = scanner.nextLine();
        }
    }
}
