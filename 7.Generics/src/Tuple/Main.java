package Tuple;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] first = scanner.nextLine().split("\\s+");
        String[] second = scanner.nextLine().split("\\s+");
        String[] third = scanner.nextLine().split("\\s+");
       Threeuple<String,String,String> firstThreeuple= new Threeuple<>(first[0]+" "+first[1], first[2],first[3]);
       boolean isDrunk = false;
       if (second[2].equals("drunk")){
           isDrunk = true;
       }
       Threeuple<String, Integer, Boolean> secondThreeuple = new Threeuple<>(second[0], Integer.parseInt(second[1]),isDrunk);
       Threeuple<String, Double, String> thirdThreeuple = new Threeuple<>(third[0], Double.parseDouble(third[1]), third[2]);
        System.out.println(firstThreeuple.toString());
        System.out.println(secondThreeuple.toString());
        System.out.println(thirdThreeuple.toString());

    }
}
