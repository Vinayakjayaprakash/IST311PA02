
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
        assertEquals("ID: 1 NUMBER OF SONGS 5--[Test Artist 1,Test Artist 2,] -- NULL", album1.toString());
    }
    @Test
    public void TestShuffle() {
        DoubleLinkedList dll = new DoubleLinkedList();
        Album album1 = new Album(1, new ArrayList<>(Arrays.asList("Test Artist 1")),"Test Title 1", 5);
        Album album2 = new Album(2, new ArrayList<>(Arrays.asList("Test Artist 2")),"Test Title 2", 5);
        Album album3 = new Album(3, new ArrayList<>(Arrays.asList("Test Artist 3")),"Test Title 3", 5);
        Album album4 = new Album(4, new ArrayList<>(Arrays.asList("Test Artist 4")),"Test Title 4", 5);
        Album album5 = new Album(5, new ArrayList<>(Arrays.asList("Test Artist 5")),"Test Title 5", 5);
        Album album6 = new Album(6, new ArrayList<>(Arrays.asList("Test Artist 6")),"Test Title 6", 5);
        dll.append(album1);
        dll.append(album2);
        dll.append(album3);
        dll.append(album4);
        dll.append(album5);
        dll.append(album6);
    dll.shuffle();
        assertEquals("2-->1-->4-->3-->6-->5-->NULL", dll.toString());

    }

    @Test
    public void testPartition() {
        DoubleLinkedList dll = new DoubleLinkedList();
        Album album1 = new Album(1, new ArrayList<>(Arrays.asList("Test Artist 1")),"Test Title 1", 5);
        Album album2 = new Album(2, new ArrayList<>(Arrays.asList("Test Artist 2")),"Test Title 2", 5);
        Album album3 = new Album(3, new ArrayList<>(Arrays.asList("Test Artist 3")),"Test Title 3", 5);
        Album album4 = new Album(4, new ArrayList<>(Arrays.asList("Test Artist 4")),"Test Title 4", 5);
        dll.append(album1);
        dll.append(album2);
        dll.append(album3);
        dll.append(album4);
        Node <Album> partitionedgreaterthan =  dll.partition(3);
        // Check that the partition first value is correct
        assertEquals(3, partitionedgreaterthan.album.albumID);
        assertEquals(4, partitionedgreaterthan.next.album.albumID);
        try {
            int id = partitionedgreaterthan.next.next.album.albumID;
            fail("Expected NullPointerException to be thrown");
        } catch (NullPointerException e) {
            // expected exception
        }
    }

    @Test
    public void testCompareTo() {
        // Create two albums with the same number of songs
        Album album1 = new Album(1, new ArrayList<>(Arrays.asList("Test Artist 1")),"Test Title 1", 5);
        Album album2 = new Album(2, new ArrayList<>(Arrays.asList("Test Artist 2")),"Test Title 2", 5);

        // Test that compareTo returns 0 when compared to itself
        assertEquals(0, album1.compareTo(album1));

        // Test that compareTo returns 0 when compared to another album with the same number of songs
        assertEquals(0, album1.compareTo(album2));

        // Test that compareTo returns -1 when compared to an album with more songs
        Album album3 = new Album(3, new ArrayList<>(Arrays.asList("Test Artist 3")),"Test Title 3", 15);
        assertEquals(-1, album1.compareTo(album3));

        // Test that compareTo returns -1 when compared to an album with fewer songs
        Album album4 = new Album(4, new ArrayList<>(Arrays.asList("Test Artist 4")),"Test Title 4", 1);
        assertEquals(-1, album1.compareTo(album4));
    }


}