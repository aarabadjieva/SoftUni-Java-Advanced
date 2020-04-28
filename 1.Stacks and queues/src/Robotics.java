import java.text.DecimalFormat;
import java.util.*;

public class Robotics {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] robotData = scanner.nextLine().split(";");
        String[] robots = new String[robotData.length];
        int[] workingTime = new int[robotData.length];
        int[] processTime = new int[robotData.length];
        for (int i = 0; i < robotData.length; i++) {
            robots[i] = robotData[i].split("-")[0];
            workingTime[i] = Integer.parseInt(robotData[i].split("-")[1]);
        }
        String[] timeAsString = scanner.nextLine().split(":");
        int hours = Integer.parseInt(timeAsString[0]);
        int mins = Integer.parseInt(timeAsString[1]);
        int secs = Integer.parseInt(timeAsString[2]);
        int startingTime = hours*3600 + mins*60 + secs;
        String product = scanner.nextLine();
        Deque<String> products = new ArrayDeque<>();
        while (!product.equalsIgnoreCase("end")) {
            products.offer(product);
            product = scanner.nextLine();
        }
        while (!products.isEmpty()) {
            startingTime++;
            product = products.pollFirst();
            boolean isProduced = false;
            for (int i = 0; i < robots.length; i++) {
                if (processTime[i]==0&&!isProduced) {
                    processTime[i] = workingTime[i];
                    printTask(robots[i], startingTime, product);
                    isProduced = true;
                }
                if (processTime[i] > 0) {
                    processTime[i]--;
                }
            }
            if (!isProduced){
                products.offer(product);
            }
        }
    }
    private static void printTask(String robot, int time, String product){
        int hours = time/3600;
        time = time%3600;
        int minutes = time/60;
        int seconds = time%60;
        if (hours>23){
            hours=hours%24;
        }
        DecimalFormat format = new DecimalFormat("00");
        System.out.println(String.format("%s - %s [%s:%s:%s]",robot, product,format.format(hours)
                ,format.format(minutes),format.format(seconds)));
    }
}
