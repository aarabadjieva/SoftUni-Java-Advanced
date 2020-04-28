import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class InfernoIII {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> diamonds = Arrays.stream(scanner.nextLine().split("\\s+"))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        Map<String, Predicate> predicates = new LinkedHashMap<>();
        String line = scanner.nextLine();
        while (!line.equals("Forge")){
            String[] tokens = line.split(";");
            Predicate<Integer> filter = null;
            String predName = tokens[1] + tokens[2];
            if (tokens[0].equals("Exclude")){
                switch (tokens[1]){
                    case "Sum Left":
                        filter = e-> {
                            int left = 0;
                            if (diamonds.indexOf(e)-1>=0){
                                left = diamonds.get(diamonds.indexOf(e)-1);
                            }
                            if ((e+left)==Integer.parseInt(tokens[2])){
                                return true;
                            }
                            return false;
                        };
                        predicates.put(predName,filter);
                        break;
                    case "Sum Right":
                        filter = e-> {
                            int right = 0;
                            if (diamonds.indexOf(e)+1<diamonds.size()){
                                right = diamonds.get(diamonds.indexOf(e)+1);
                            }
                            if ((e+right)==Integer.parseInt(tokens[2])){
                                return true;
                            }
                            return false;
                        };
                        predicates.put(predName, filter);
                        break;
                    case "Sum Left Right":
                        filter = e-> {
                            int left = 0;
                            if (diamonds.indexOf(e)-1>=0){
                                left = diamonds.get(diamonds.indexOf(e)-1);
                            }
                            int right = 0;
                            if (diamonds.indexOf(e)+1<diamonds.size()){
                                right = diamonds.get(diamonds.indexOf(e)+1);
                            }
                            if ((e+left+right)==Integer.parseInt(tokens[2])){
                                return true;
                            }
                            return false;
                        };
                        predicates.put(predName,filter);
                        break;
                }
            }else {
                predicates.remove(predName);
            }
            line = scanner.nextLine();
        }
        List<Integer> remained = diamonds.stream().filter(e->{
            boolean isValid = true;
            for (String predName:predicates.keySet()
                 ) {
                if (predicates.get(predName).test(e)){
                    isValid = false;
                }
            }
            return isValid;
        }).collect(Collectors.toList());
        for (int num:remained
             ) {
            System.out.print(num + " ");
        }
    }
}
