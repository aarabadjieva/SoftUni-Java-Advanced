package LinkedList;

import java.awt.dnd.InvalidDnDOperationException;
import java.util.Iterator;
import java.util.function.Consumer;

class LinkedList implements Iterable {
    private Node head;
    private Node tail;
    private int size;

    public int getHead() {
        return head.value;
    }

    public int getTail() {
        return tail.value;
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty(int size) {
        return this.size == 0;
    }

    public void addFirst(int element) {
        Node node = new Node(element);
        if (isEmpty(this.size)) {
            this.tail = node;
        } else {
            this.head.prev = node;
            node.next = this.head;
        }
        this.head = node;
        this.size++;
    }

    public void add(int element) {
        Node node = new Node(element);
        if (isEmpty(this.size)) {
            this.head = node;
        } else {
            this.tail.next = node;
            node.prev = this.tail;
        }
        this.tail = node;
        this.size++;
    }

    public int removeFirst() {
        if (isEmpty(this.size)) {
            throw new InvalidDnDOperationException("Remove called for collection with size 0");
        }
        int first = this.head.value;
        if (this.size == 1) {
            this.head = null;
            this.tail = null;
        } else {
            this.head = this.head.next;
            this.head.prev = null;
        }
        this.size--;
        return first;
    }
    public boolean remove(int element){
        if (isEmpty(this.size)) {
            throw new InvalidDnDOperationException("Remove called for collection with size 0");
        }
        if (this.head.value==element){
            this.head=this.head.next;
            this.head.prev=null;
            this.size--;
            return true;
        }
        Node prev = this.head;
        Node current = this.head.next;
        while (current!=null){
            if (current.value==element){
                prev.next=current.next;
                current.next.prev = prev;
                this.size--;
                return true;
            }
            prev = current;
            current=current.next;
        }
        return false;
    }

    public int removeLast(){
        if (isEmpty(this.size)){
            throw new InvalidDnDOperationException("Remove called for collection with size 0");
        }
        int last = this.tail.value;
        if (this.size==1){
            this.head = null;
            this.tail = null;
        }else {
            this.tail = this.tail.prev;
            this.tail.next = null;
        }
        this.size--;
        return last;
    }

    public void foreach(Consumer<Integer> consumer){
        Node node = this.head;
        while (node!=null){
            consumer.accept(node.value);
            node = node.next;
        }
    }

    public int[] toArray(){
        int[] result = new int[this.size];
        Node node = this.head;
        int index = 0;
        while (node!=null){
            result[index] = node.value;
            index++;
            node = node.next;
        }
        return result;
    }

    public void addAfter(int searchElement, int element){
        if (isEmpty(this.size)){
            throw new InvalidDnDOperationException("AddAfter method on empty list");
        }
        Node node = this.head;
        while (node!=null){
            if (node.value==searchElement){
                break;
            }
            node = node.next;
        }
        if (node==null){
            throw new InvalidDnDOperationException("Element not found");
        }
        Node newNode = new Node(element);
        newNode.next = node.next;
        newNode.prev = node;
        node.next.prev = newNode;
        node.next = newNode;
        this.size++;
    }

    public void removeAfter(int searchElement){
        if (isEmpty(this.size)){
            throw new InvalidDnDOperationException("RemoveAfter on empty list");
        }
        Node node = this.head;
        while (node!=null){
            if (node.value==searchElement){
                break;
            }
            node = node.next;
        }
        if (node==null){
            throw new InvalidDnDOperationException("Element not found");
        }
        node.next.next.prev = node;
        node.next = node.next.next;
        this.size--;
    }

    @Override
    public Iterator iterator() {
        return new Iterator() {
            private Node current = head;
            @Override
            public boolean hasNext() {
                return this.current!=null;
            }

            @Override
            public Integer next() {
                int element = this.current.value;
                this.current = this.current.next;
                return element;
            }
        };
    }


    private class Node {
        private Node next;
        private Node prev;
        private int value;

        public Node(int element) {
            this.value = element;
            this.prev = null;
            this.next = null;
        }
    }
}
