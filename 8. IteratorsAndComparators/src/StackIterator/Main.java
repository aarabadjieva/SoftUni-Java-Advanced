package StackIterator;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        Stack<Integer> stack = new Stack<>();
        while (!input.equals("END")){
            if (input.contains("Push")){
                Arrays.stream(input.split("[,\\s]+"))
                        .skip(1).mapToInt(Integer::parseInt)
                        .forEach(stack::push);
            }else {
                try {
                    stack.pop();
                }catch (Exception e){
                    System.out.println(e.getMessage());
                }
            }
            input = scanner.nextLine();
        }
        for (int i = 0; i <2 ; i++) {
            for (Integer num:stack
            ) {
                System.out.println(num);
            }
        }
    }
}
