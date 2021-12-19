import java.util.Arrays;

public class LinkedList<T> {
    private class Node {

        private Integer index;
        private T value;
        private Node next;

        private Node(T item) {
            value = item;
            index = pointer++;
        }

        public Node(T item, Integer nodeIndex) {
            this(item);
            index = nodeIndex;
        }

        @Override
        public String toString() {
            if (this.value != null)
                return this.value.toString();
            return null;
        }
    }

    private Integer pointer = 0;
    private Node tail;
    private Node head;
    private Integer size = 0;

    public void add(T item, Integer index) {
        if (index == 0) addFirst(item);
        else if (index.equals(size)) addLast(item);
        var temp = this.getNode(index);
        var nodeIndex = temp.index;
        var current = this.getNode(index - 1);
        current.next = new Node(item, nodeIndex);
        current.next.next = temp;
        current = current.next.next;
        while (current != null) {
            current.index += 1;
            current = current.next;
        }
        this.size += 1;
    }

    public void addLast(T item) {
        var node = new Node(item);
        if (tail == null)
            tail = head = node;
        else {
            head.next = node;
            head = node;
        }
        this.size += 1;
    }

    public void addFirst(T item) {
        var node = new Node(item);
        if (tail == null)
            tail = head = node;
        else {
            node.next = tail;
            tail = node;
        }
        this.size += 1;
    }

    public int indexOf(T item) {
        int index = 0;
        var current = this.tail;
        while (current != null) {
            if (current.value == item) return index;
            current = current.next;
            index++;
        }
        return -1;
    }

    public Boolean contains(T item, String... strings) {
        var current = tail;
        while (current != null) {
            if (current.value == item) return true;
            current = current.next;
        }
        return false;
    }

    public void remove(int index) {
        var first = this.tail;
        var next = this.getNext(first);
        for (int i = 0; i < index; i++) {
            first = this.getNext(first);
            next = this.getNext(next);
        }
        first.value = next.value;
        this.removeFirst();
    }


    public void removeFirst() {
        tail = tail.next;
        this.size -= 1;
    }

    public void removeLast() {
        head = getPrevious(head);
        if (head != null) head.next = null;
        this.size -= 1;
    }

    private Node getPrevious(Node node) {
        var current = tail;
        while (current != null) {
            if (current.next == node) return current;
            current = current.next;
        }
        return null;
    }

    private Node getNext(Node node) {
        return node.next;
    }

    public Node getNode(Integer index) {
        var current = this.tail;
        while (current != null) {
            if (current.index.equals(index)) return current;
            current = current.next;
        }
        return null;
    }


    public Integer size() {
        return this.size;
    }

    public T[] toArray() {
        T[] arr = (T[]) new Object[this.size];
        int i = 0;
        var current = tail;
        while (current != null) {
            arr[i] = current.value;
            if (current.next == null) return arr;
            current = current.next;
            i += 1;
        }
        return arr;
    }

    @Override
    public String toString() {
        return Arrays.toString(this.toArray());
    }
}
