package Froggy;

import java.util.Arrays;
import java.util.Scanner;
import java.util.StringJoiner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] stones = Arrays.stream(scanner.nextLine().split(", "))
                .mapToInt(Integer::parseInt)
                .toArray();
        Lake lake = new Lake(stones);
        StringJoiner joiner = new StringJoiner(", ");
        for (Integer stone: lake) {
            joiner.add(stone.toString());
        }
        System.out.println(joiner);
    }
}
