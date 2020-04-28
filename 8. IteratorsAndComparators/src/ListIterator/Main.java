package ListIterator;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] elements = Arrays.stream(scanner.nextLine().split("\\s+"))
                .skip(1).toArray(String[]::new);
        ListIterator listIterator = new ListIterator(Arrays.asList(elements));

        String line = scanner.nextLine();
        while (!line.equals("END")){
            switch (line){
                case "Move":
                    System.out.println(listIterator.move());
                    break;
                case "HasNext":
                    System.out.println(listIterator.hasNext());
                    break;
                case "Print":
                    try {
                        System.out.println(listIterator.getItem());
                    }catch (Exception e){
                        System.out.println(e.getMessage());
                    }
                    break;
                case "PrintAll":
                    for (String str:listIterator
                         ) {
                        System.out.print(str+" ");
                    }
                    System.out.println();
                    break;
            }
            line = scanner.nextLine();
        }
    }
}
