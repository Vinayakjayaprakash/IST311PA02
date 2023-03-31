
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class DoubleLinkedListTest {
    @Test
    public void dllTest() {


        DoubleLinkedList dll = new DoubleLinkedList();
        assertNull(dll.head);
        assertNull(dll.tail);

    }

    @Test
    public void appendDLL() { //To test adding a node at the end of the list
        DoubleLinkedList dll = new DoubleLinkedList();
        Album album1 = new Album(1, new ArrayList<>(Arrays.asList("Test Artist 1")),"Test Title 1", 5);
        Album album2 = new Album(2, new ArrayList<>(Arrays.asList("Test Artist 2")),"Test Title 2", 5);
        dll.append(album1);
        assertEquals(dll.head.album.albumTitle, "Test Title 1");
        assertEquals(dll.tail.album.albumTitle, "Test Title 1");
        dll.append(album2);
        assertEquals(dll.head.album.albumTitle, "Test Title 1");
        assertEquals(dll.tail.album.albumTitle, "Test Title 2");
    }

    @Test
    public void insertDLL() { //to test adding a node anywhere in the list
        DoubleLinkedList dll = new DoubleLinkedList();
        Album album1 = new Album(1, new ArrayList<>(Arrays.asList("Test Artist 1")),"Test Title 1", 5);
        dll.insert(0, album1);
        Album album2 = new Album(2, new ArrayList<>(Arrays.asList("Test Artist 2")),"Test Title 2", 5);
        dll.insert(1, album2);
        Album album3 = new Album(3, new ArrayList<>(Arrays.asList("Test Artist 3")),"Test Title 3", 5);
        dll.insert(2, album3);
        Album album4 = new Album(4, new ArrayList<>(Arrays.asList("Test Artist 4")),"Test Title 4", 5);
        dll.insert(1, album4);
        assertEquals("Test Title 1", dll.head.album.albumTitle);
        assertEquals("Test Title 3", dll.tail.album.albumTitle);
    }

    @Test
    public void testDeletePos() {
        DoubleLinkedList dll = new DoubleLinkedList();

        Album album1 = new Album(1, new ArrayList<>(Arrays.asList("Test Artist 1")),"Test Title 1", 5);
        Album album2 = new Album(2, new ArrayList<>(Arrays.asList("Test Artist 2")),"Test Title 2", 5);
        Album album3 = new Album(3, new ArrayList<>(Arrays.asList("Test Artist 3")),"Test Title 3", 5);
        dll.append(album1);
        dll.append(album2);
        dll.append(album3);
        Node<Album> deletedNode = dll.deletePos(1); //deleted node at position 2 (album2)
        assertEquals(album2, deletedNode.album);
        assertEquals(1,dll.getIndex(album3));
        Node<Album> deletedNode2 = dll.deletePos(1);//deleted node at position 1 (album3) which is now at position 1
        assertEquals(album3, deletedNode2.album);

        try{
            Node<Album> deletedNode3 = dll.deletePos(2);
            fail("Expected error to be thrown");
        }

        catch( IllegalArgumentException e){

        }
        //assertEquals(1,dll.getIndex(album3));

    }

    @Test
    public void testgetIndex() {
        DoubleLinkedList dll = new DoubleLinkedList();
        Album album1 = new Album(1, new ArrayList<>(Arrays.asList("Test Artist 1")),"Test Title 1", 5);
        Album album2 = new Album(2, new ArrayList<>(Arrays.asList("Test Artist 2")),"Test Title 2", 5);
        Album album3 = new Album(3, new ArrayList<>(Arrays.asList("Test Artist 3")),"Test Title 3", 5);
        dll.append(album1);
        dll.append(album2);
        dll.append(album3);

        assertEquals(0,dll.getIndex(album1));
        assertEquals(1,dll.getIndex(album2));
        assertEquals(2,dll.getIndex(album3));
        Album album4 = new Album(4, new ArrayList<>(Arrays.asList("Test Artist 4")),"Test Title 4", 5);
        assertEquals(-1,dll.getIndex(album4));
    }
@Test
    public void toStringTest() {

        DoubleLinkedList dll = new DoubleLinkedList();
    Album album1 = new Album(1, new ArrayList<>(Arrays.asList("Test Artist 1")),"Test Title 1", 5);
    Album album2 = new Album(2, new ArrayList<>(Arrays.asList("Test Artist 2")),"Test Title 2", 5);
    Album album3 = new Album(3, new ArrayList<>(Arrays.asList("Test Artist 3")),"Test Title 3", 5);
        dll.append(album1);
        dll.append(album2);
        dll.append(album3);
        assertEquals("1-->2-->3-->NULL", dll.toString());
    Album album4 = new Album(4, new ArrayList<>(Arrays.asList("Test Artist 4")),"Test Title 4", 5);
    dll.append(album4);
    assertEquals("1-->2-->3-->4-->NULL", dll.toString());
    }
    @Test
    public void TestAlbumTostring() {

        DoubleLinkedList dll = new DoubleLinkedList();
        Album album1 = new Album(1, new ArrayList<>(Arrays.asList("Test Artist 1","Test Artist 2")),"Test Title 1", 5);
        dll.append(album1);
        assertEquals("1: 5--[Test Artist 1,Test Artist 2,]", album1.toString());
    }
}