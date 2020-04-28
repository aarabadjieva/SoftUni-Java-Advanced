package ListIterator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Spliterator;
import java.util.function.Consumer;

public class ListIterator implements Iterable<String>{
    private static final int DEFAULT_INDEX = -1;
    private List<String> elements;
    private int index;

    public ListIterator(List<String> elements){
        this.elements = elements;
        this.setIndex();
    }

    private void setIndex() {
        if (this.elements.size()==0){
            this.index = ListIterator.DEFAULT_INDEX;
        }else {
            this.index = 0;
        }
    }

    public boolean move() {
        if (this.index<this.elements.size()-1){
            this.index++;
            return true;
        }
        return false;
    }

    public boolean hasNext() {
        if (this.index+1<this.elements.size()){
            return true;
        }
        return false;
    }

    public String getItem() {
        if (this.elements.size()==0){
            throw new IndexOutOfBoundsException("Invalid Operation!");
        }
        return this.elements.get(this.index);
    }

    @Override
    public Iterator<String> iterator() {
        return new Iterator<String>() {
            private int index = 0;
            @Override
            public boolean hasNext() {
                return this.index<elements.size();
            }

            @Override
            public String next() {
                return elements.get(this.index++);
            }
        };
    }

    @Override
    public void forEach(Consumer action) {
        for (int i = 0; i < this.elements.size(); i++) {
            action.accept(this.elements.get(i));
        }
    }

}
