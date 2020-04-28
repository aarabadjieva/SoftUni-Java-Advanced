import java.util.Arrays;
import java.util.Scanner;

public class LongestIncreasingSubsequence {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] numbers = Arrays.stream(scanner.nextLine().split("\\s"))
                .mapToInt(Integer::parseInt).toArray();
        int[] len = new int[numbers.length];
        int lis = 0;
        int bestIndex = 0;
        int[] prev = new int[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            int bestLenght = 1;
            int index = -1;
            prev[i] = index;
            int element = numbers[i];
            for (int j = 0; j < i; j++) {
               if (numbers[j]<element&&len[j]>=bestLenght){
                   bestLenght = len[j]+1;
                   if (bestLenght>len[lis]){
                       lis = i;
                   }
                   index = j;
               }
            }
            len[i] = bestLenght;
            prev[i] = index;
        }
        int[] longest = new int[len[lis]];
        longest[longest.length-1] = numbers[lis];
        int max = len[lis];
       for (int i = longest.length-2; i >=0 ; i--) {
          longest[i] = numbers[prev[lis]];
          lis = prev[lis];
       }
        for (int num:longest
             ) {
            System.out.print(num+" ");
        }
    }
}
