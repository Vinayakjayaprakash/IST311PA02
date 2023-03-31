import java.util.ArrayList;
import java.util.Collections;

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

    public Node<Album> insert(int position, Album Album1) {
        Node<Album> toInsert = new Node<Album>(Album1);
        IllegalArgumentException IAe = new IllegalArgumentException();
        if (head == null && position != 0) {

            throw IAe;
        } else {
            if (head == null && position == 0) {
                head = toInsert;
                tail = toInsert;


            } else {
                int pos = 0;
                Node<Album> current = this.head;
                while (pos < position && current.next != null) {
                    current = current.next;
                    pos++;
                }
                if ((pos + 1) == position)
                    return this.append(Album1);
                if (pos != position && ((pos != position)))
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

public Node<Album> shuffle(){
    if (this.head == null)
        return this.head;
    else {
        Node<Album> current = this.head;
        ArrayList<Album> arraylistalbum = new ArrayList<Album>();
        while (current != null) {

            arraylistalbum.add(current.album);
            current = current.next;

        }
        current = this.head;
        int tempSize = arraylistalbum.size() - (arraylistalbum.size() % 2);
        for (int i = 0; i < tempSize; i = i + 2) {
            Collections.swap(arraylistalbum, i, i + 1);
        }

        current = this.head;
        for (int i = 0; i < tempSize; i++) {

            current.album = arraylistalbum.get(i);
            current = current.next;

        }
    }
return this.head;
    }
    public Node<Album> deletePos(int delposition) {
        IllegalArgumentException IAe = new IllegalArgumentException();
        if (delposition < 0) {
            throw IAe;
        }
        Node<Album> toDelete;
        if (head == null) {
            throw IAe;
        } else if (delposition == 0) {
            toDelete = head;
            head = head.next;
            if (head != null) {
                head.previous = null;
            }
        } else {
            Node<Album> current = head;
            int pos = 0;
            while (pos < delposition - 1 && current.next != null) {
                current = current.next;
                pos++;
            }
            if (current.next == null) {
                throw IAe;
            }
            toDelete = current.next;
            current.next = toDelete.next;
            if (toDelete.next != null) {
                toDelete.next.previous = current;
            }
        }
        toDelete.next = null;
        toDelete.previous = null;
        return toDelete;
    }

    public int getIndex(Album album) {
        int index = 0;
        Node<Album> current = this.head;
        while (current != null) {
            if (current.album.equals(album)) {

                return index;
            }
            current = current.next;
            index++;
        }
        return -1;
    }

    @Override
    public String toString() {
        StringBuilder stb = new StringBuilder();
        if (head == null) {//checks if the current node is equal to null
            stb.append("");
        } else {
            Node<Album> current = head;
            while (current != null) { //if not it appends the next block to add a number and the arrow
                stb.append(current.album.albumID);
                stb.append("-->");
                current = current.next;
            }
            stb.append("NULL");//if it is null it adds the null and ends the linked list
        }
        return stb.toString();
    }
}