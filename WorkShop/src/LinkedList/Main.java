package LinkedList;

import LinkedList.LinkedList;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LinkedList linkedList = new LinkedList();
        int n = Integer.parseInt(scanner.nextLine());
        while (n-->0){
            String[] cmd = scanner.nextLine().split("\\s+");
            if (cmd[0].equals("Add")){
                int element = Integer.parseInt(cmd[1]);
                linkedList.add(element);
            }else {
                linkedList.remove(Integer.parseInt(cmd[1]));
            }
        }
        System.out.println(linkedList.getSize());
        for (Object element:linkedList
             ) {
            System.out.print(element+" ");
        }
    }
}
