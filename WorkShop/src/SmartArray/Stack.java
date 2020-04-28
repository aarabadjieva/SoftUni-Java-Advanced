package SmartArray;

import java.util.NoSuchElementException;

public class Stack {
    private static final int INITIAL_CAPACITY = 4;
    private int[] data;
    private int topElement;
    private int capacity;

    public Stack(){
        this.data = new int[Stack.INITIAL_CAPACITY];
        this.topElement = -1;
        this.capacity = Stack.INITIAL_CAPACITY;
    }

    public void push(int element){
        if (this.topElement+1 == this.capacity){
            this.resize();
        }
        this.data[++this.topElement] = element;
    }

    private void resize() {
        this.capacity *=2;
        int[] newData = new int[this.capacity];
        for (int i = 0; i < this.data.length; i++) {
            newData[i] = this.data[i];
        }
        this.data = newData;
    }

    public int pop(){
        if (this.topElement<0){
            throw new NoSuchElementException("Stack is empty");
        }
        int element = this.data[this.topElement];
        this.data[this.topElement--] = 0;
        return element;
    }

    public int peek(){
        if (this.topElement<0){
            throw new NoSuchElementException("Stack is empty");
        }
        return this.data[this.topElement];
    }

}
