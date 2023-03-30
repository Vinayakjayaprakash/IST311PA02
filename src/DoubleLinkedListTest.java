
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DoubleLinkedListTest {
    @Test
    public void dllTest() {


        DoubleLinkedList dll = new DoubleLinkedList();
        assertNull(dll.head);
        assertNull(dll.tail);

    }


}