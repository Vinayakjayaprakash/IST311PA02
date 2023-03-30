
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DoubleLinkedListTest {
    @Test
    public void dllTest() {


        DoubleLinkedList dll = new DoubleLinkedList();
        assertNull(dll.head);
        assertNull(dll.tail);

    }
    @Test
    public void appendDLL() {
        DoubleLinkedList dll = new DoubleLinkedList();
        Album album1 = new Album(1, "Test Title 1", 5);
        Album album2 = new Album(2, "Test Title 2", 5);
        dll.append(album1);
        assertEquals(dll.head.album.albumTitle, "Test Title 1");
        assertEquals(dll.tail.album.albumTitle, "Test Title 1");
        dll.append(album2);
        assertEquals(dll.head.album.albumTitle, "Test Title 1");
        assertEquals(dll.tail.album.albumTitle, "Test Title 2");
    }
    @Test
    public void insertDLL(){
        DoubleLinkedList dll = new DoubleLinkedList();
        Album album1 = new Album(1,"Test Title 1",5);
        dll.insert(0,album1);
        Album album2 = new Album(2,"Test Title 2",5);
        dll.insert(1,album2);
        Album album3 = new Album(3,"Test Title 3",5);
        dll.insert(2,album3);
        Album album4 = new Album(4,"Test Title 4",5);
        dll.insert(3,album4);
        assertEquals("Test Title 4",dll.tail.album.albumTitle);
    }
    @Test
    public void testDeletePos() {
        DoubleLinkedList dll = new DoubleLinkedList();
        Album album1 = new Album(1, "Test Title 1", 5);
        Album album2 = new Album(2, "Test Title 2", 5);
        Album album3 = new Album(3, "Test Title 3", 5);
        dll.append(album1);
        dll.append(album2);
        dll.append(album3);
        Node<Album> deletedNode = dll.deletePos(2);
        assertEquals(album2, deletedNode.album);

    }


}