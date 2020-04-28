package SmartArray;

import java.util.NoSuchElementException;

public class Queue {
    private static final int INITIAL_CAPACITY = 4;
    private int[] data;
    private static final int front = 0;
    private int capacity;
    private int size;

    public Queue(){
        this.data = new int[Queue.INITIAL_CAPACITY];
        this.capacity = Queue.INITIAL_CAPACITY;
        this.size = 0;
    }

    public void add(int element){
        if (this.size == this.capacity){
            this.resize();
        }
        this.data[this.size++] = element;
    }

    private void resize() {
        this.capacity *=2;
        int[] newData = new int[this.capacity];
        for (int i = 0; i < this.data.length; i++) {
            newData[i] = this.data[i];
        }
        this.data = newData;
    }

    public int front(){
        if (this.size <= 0){
            throw new NoSuchElementException("Queue is empty");
        }
        int element = this.data[Queue.front];
        this.shiftLeft();
        data[--this.size]=0;
        return element;
    }

    private void shiftLeft() {
        for (int i = 0; i <this.size-1 ; i++) {
            this.data[i] = this.data[i+1];
        }
    }

    public int peekFirst(){
        if (this.size <= 0){
            throw new NoSuchElementException("Queue is empty");
        }
        return this.data[Queue.front];
    }
}
