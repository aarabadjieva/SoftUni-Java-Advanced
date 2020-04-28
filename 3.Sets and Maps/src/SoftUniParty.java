import java.util.HashSet;
import java.util.Scanner;
import java.util.TreeSet;

public class SoftUniParty {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String guest = scanner.nextLine();
        TreeSet<String> guests = new TreeSet<>();
        while (!guest.equals("PARTY")){
            guests.add(guest);
            guest = scanner.nextLine();
        }
        guest = scanner.nextLine();
        while (!guest.equals("END")){
            if (guests.contains(guest)){
                guests.remove(guest);
            }
            guest = scanner.nextLine();
        }
        int count = guests.size();
        System.out.println(count);
        if (!guests.isEmpty()){
            for (String current:guests
                 ) {
                System.out.println(current);
            }
        }
    }
}
