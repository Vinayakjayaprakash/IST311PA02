public class Node <Album>{
    Album album; //Means that the data can be of any type
    Node <Album> next; //Acts as a point to the next node
    Node <Album> previous; //Acts as a point to the previous node

    public Node(Album album){
        this.album = album;
        this.next = null;
        this.previous = null;


    }
}
