package CustomList;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.function.Consumer;

public class SmartList<T extends Comparable<T>> implements Iterable<T>{
    private List<T> data;

    public SmartList() {
        this.data = new ArrayList<>();
    }

    public int size(){
        return this.data.size();
    }
    public T get(int index){
        return this.data.get(index);
    }

    public void add(T element){
        this.data.add(element);
    }

    public T remove(int index){
        return this.data.remove(index);
    }

    public boolean contains(T element){
        return this.data.contains(element);
    }

    public void swap(int index1, int index2){
        T temp = this.data.get(index1);
        this.data.set(index1,this.data.get(index2));
        this.data.set(index2,temp);
    }

    public int countGreaterThan(T element){
        int counter = 0;
        for (T datum : data) {
            if (datum.compareTo(element)>0){
                counter++;
            }
        }
        return counter;
    }

    public T getMax(){
        return this.data.stream().max(T::compareTo).get();
    }

    public T getMin(){
        return this.data.stream().min(T::compareTo).get();
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private int index = 0;
            @Override
            public boolean hasNext() {
                return this.index < data.size();
            }

            @Override
            public T next() {
                return data.get(index++);
            }
        };
    }
}
