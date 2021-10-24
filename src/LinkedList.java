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
}
