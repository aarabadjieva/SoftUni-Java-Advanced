package CarDemo;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        IntStream.rangeClosed(1, n).boxed()
                .map(num-> scanner.nextLine().split("\\s+"))
                .map(data-> {
                    Car car = new Car(data[0]);
                    if (data.length!=1) {
                        car = new Car(data[0],data[1],Integer.parseInt(data[2]));
                    }
                    return car;
                })
                .forEach(car -> System.out.println(car.getInfo()));
    }
}
