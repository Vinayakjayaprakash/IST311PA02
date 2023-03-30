public class DoubleLinkedList {
    Node<Album> head;
    Node<Album> tail;

    public DoubleLinkedList() {
        this.head = null;
        this.tail = null;


    }
    public Node<Album> append(Album album1) {
        Node<Album> toAppend = new Node<>(album1);
        if (this.head == null) {
            this.head = toAppend; // appends to the head first
            this.tail = toAppend; // appends to the head first
        } else { // else it gets added to the next node
            tail.next = toAppend;
            toAppend.previous = tail;
            tail = toAppend;
        }
        return toAppend;
    }
}