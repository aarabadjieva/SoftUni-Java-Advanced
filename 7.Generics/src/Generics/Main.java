package Generics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        List<Box<String>> boxes = new ArrayList<>();
        while (n-->0){
            String line = scanner.nextLine();
            Box<String> box = new Box<String>(line);
            boxes.add(box);
        }
        String line = scanner.nextLine();
        Box<String> comparator = new Box<>(line);
       // System.out.println(countGreaterValues(boxes,comparator));
        int counter = 0;
        for (Box box:boxes
             ) {
            if (box.compareTo(comparator)>0){
                counter++;
            }
        }
        System.out.println(counter);
    }
    public static List<Box> swap(List<Box> boxes, int firstIndex, int secondIndex){
        Box temp = boxes.get(firstIndex);
        boxes.set(firstIndex, boxes.get(secondIndex));
        boxes.set(secondIndex, temp);
        return boxes;
    }
    public static <T extends Comparable<T>> int countGreaterValues(List<Box<T>> list, Box<T> box){
        int counter = 0;
        for (Box<T> t:list){
            if (t.compareTo(box)>0){
                counter++;
            }
        }
        return counter;
    }
}
