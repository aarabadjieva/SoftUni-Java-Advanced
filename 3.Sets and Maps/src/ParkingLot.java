import java.util.*;

public class ParkingLot {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        HashSet<String> parking = new HashSet<>();
        String input = scanner.nextLine();
        while (!input.equals("END")){
            String[] moveAndnumber = input.split(", ");
            String move = moveAndnumber[0];
            String numberPlate = moveAndnumber[1];
            if (move.equals("IN")){
                    parking.add(numberPlate);
            }else {
                    parking.remove(numberPlate);
            }
            input = scanner.nextLine();
        }
        if (parking.isEmpty()){
            System.out.println("Parking Lot is Empty");
        }else {
            for (String plate:parking
                 ) {
                System.out.println(plate);
            }
        }
    }
}
