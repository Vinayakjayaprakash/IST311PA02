
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

}