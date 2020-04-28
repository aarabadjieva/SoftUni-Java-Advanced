import java.util.*;

public class Socks {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Deque<Integer> leftSocks = new ArrayDeque<>();
        Deque<Integer> rightSocks = new ArrayDeque<>();
        int[] leftCollection = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
        int[] rightCollection = Arrays.stream(scanner.nextLine().split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
        for (int i1 : leftCollection) {
            leftSocks.push(i1);
        }
        for (int i1 : rightCollection) {
            rightSocks.offer(i1);
        }
        int biggestPair = 0;
        List<Integer> socks = new ArrayList<>();
        while (!leftSocks.isEmpty() && !rightSocks.isEmpty()) {
            int left = leftSocks.pop();
            int right = rightSocks.peek();
            if (left > right) {
                rightSocks.poll();
                int pair = left + right;
                if (pair > biggestPair) {
                    biggestPair = pair;
                }
                socks.add(pair);
            }
            if (left == right) {
                left += 1;
                leftSocks.push(left);
                rightSocks.poll();
            }
        }
        System.out.println(biggestPair);
        for (int pair : socks
        ) {
            System.out.print(pair + " ");
        }
    }
}
