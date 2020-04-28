package Generics;

public class Box<E extends Comparable<E>>  {
    private E element;

    public Box(E element){
        this.element = element;
    }

    @Override
    public String toString() {
        return this.element.getClass().getName()+ ": " + element.toString();
    }

    public int compareTo(Box<E> other) {
        return this.element.compareTo(other.element);
    }
}
