package ListUtilities;
import java.util.List;
import java.util.stream.Collectors;

public class ListUtils {
    public static <T extends Comparable<T>> T getMax(List<T> list){
        if (list.isEmpty()){
            throw new IllegalArgumentException();
        }
        list = list.stream().sorted().collect(Collectors.toList());
        return list.get(list.size()-1);
    }
    public static <T extends Comparable<T>> T getMin(List<T> list){
        if (list.isEmpty()){
            throw new IllegalArgumentException();
        }
        if (list.size()==1){
            return list.get(0);
        }
        T currentMin = list.get(0);
        for (int i = 1; i <list.size() ; i++) {
            if (currentMin.compareTo(list.get(i))>0){
                currentMin = list.get(i);
            }
        }
        return currentMin;
    }
}
