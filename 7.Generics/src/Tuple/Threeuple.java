package Tuple;

public class Threeuple<T, E, F> {
    private T item1;
    private E item2;
    private F item3;

    public Threeuple(T item1, E item2, F item3) {
        this.item1 = item1;
        this.item2 = item2;
        this.item3 = item3;
    }

    public T getItem1() {
        return item1;
    }

    public void setItem1(T item1) {
        this.item1 = item1;
    }

    public E getItem2() {
        return item2;
    }

    public void setItem2(E item2) {
        this.item2 = item2;
    }

    public F getItem3() {
        return item3;
    }

    public void setItem3(F item3) {
        this.item3 = item3;
    }

    @Override
    public String toString() {
        return item1 + " -> " + item2 + " -> " + item3;
    }
}
