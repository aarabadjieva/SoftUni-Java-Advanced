package SmartArray;

import java.util.function.Consumer;

public class SmartArray {
    private static final int INITIAL_CAPACITY = 4;
    private int[] array;
    private int size;
    private int capacity;

    public SmartArray() {
        this.array = new int[INITIAL_CAPACITY];
        this.capacity = INITIAL_CAPACITY;
    }

    public int getSize() {
        return size;
    }

    public int getCapacity() {
        return capacity;
    }

    private void resize(){
        this.capacity *=2;
        int[] newArray = new int[this.capacity];
        for (int i = 0; i < this.size; i++) {
            newArray[i] = this.array[i];
        }
        this.array = newArray;
    }

    private void shrink(){
        this.capacity /=2;
        int[] newArray = new int[this.capacity];
        if (this.size >= 0) System.arraycopy(this.array, 0, newArray, 0, this.size);
        this.array = newArray;
    }

    private void shiftLeft(int index){
        if (this.size - 1 - index >= 0)
            System.arraycopy(this.array, index + 1, this.array, index, this.size - 1 - index);
        this.array[size-1] = 0;
    }

    private void shiftRight(int index){
        for (int i = this.size-1; i >index ; i--) {
            this.array[i] = this.array[i-1];
        }
    }

    public void add(int element){
        if (this.size==this.capacity){
            this.resize();
        }
        this.array[this.size] = element;
        this.size++;
    }

    public int removeAt(int index){
        int element = 0;
        if (index<0||index>=this.size){
            throw new IndexOutOfBoundsException("Index out of bounds for" +
                    " SmartArray with size of " + this.size);
        }
        element = this.array[index];
        this.shiftLeft(index);
        this.size--;
        if (this.size*2<this.capacity){
            this.shrink();
        }
        return element;
    }

    public void insert(int index, int element){
        if (index<0||index>=this.size){
            throw new IndexOutOfBoundsException("Index out of bounds for" +
                    " SmartArray with size of " + this.size);
        }
        if (this.size==this.capacity){
            this.resize();
        }
        this.size++;
        this.shiftRight(index);
        this.array[index] = element;
    }

    public boolean contains(int element){
        boolean contains = false;
        for (int i = 0; i < this.size; i++) {
            int curr = this.array[i];
            if (curr==element){
                return true;
            }
        }
        return false;
    }

    public void forEach(Consumer<Integer> consumer){
        for (int i = 0; i < this.size; i++) {
            consumer.accept(this.array[i]);
        }
    }

    @Override
    public String toString() {
        String toString = "";
        for (int i = 0; i < this.size; i++) {
            toString +=this.array[i] + " ";
        }
        return toString;
    }
}
