public class LinkedList {

    private class Node {

        private int value;
        private Node next;

        private Node(int item) {
            value = item;
        }
    }

    private Node first;
    private Node last;

    public void addLast(int item) {
        var node = new Node(item);
        if (first == null)
            first = last = node;
        else {
            last.next = node;
            last = node;
        }
    }

    public void addFirst(int item) {
        var node = new Node(item);
        if (first == null)
            first = last = node;
        else {
            node.next = first;
            first = node;
        }
    }

    public int indexOf(int item) {
        int index = 0;
        var current = this.first;
        while (current != null) {
            if (current.value == item) return index;
            current = current.next;
            index++;
        }
        return -1;
    }

    public Boolean contains(int item) {
        var current = first;
        while (current != null) {
            if (current.value == item) return true;
            current = current.next;
        }
        return false;
    }

    public void removeFirst() {
        first = first.next;
    }

    public void removeLast() {
        last = getPrevious(last);
        if (last != null) last.next = null;


    }

    private Node getPrevious(Node node) {
        var current = first;
        while (current != null) {
            if (current.next == node) return current;
            current = current.next;
        }
        return null;
    }
}
