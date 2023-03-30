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
    public Node <Album> insert (int position, Album Album1){
        Node <Album> toInsert = new Node<Album>(Album1);
        IllegalArgumentException IAe = new IllegalArgumentException();
        if(head == null && position!=0) {

            throw IAe;
        }
        else {
            if (head == null && position == 0) {
                head = toInsert;
                tail = toInsert;


            } else{
                int pos = 0;
                Node<Album> current = this.head;
                while(pos<position && current.next != null){
                    current = current.next;
                    pos++;
                }
                if((pos+1)==position)
                    return this.append(Album1);
                if(pos!=position && ((pos != position)))
                    throw IAe;
                else {
                    toInsert.next = current;
                    toInsert.previous = current.previous;
                    current.previous.next = toInsert;
                    current.previous = toInsert;
                }

            }
        }
        return toInsert;
    }
}