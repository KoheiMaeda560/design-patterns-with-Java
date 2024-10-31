package iterator;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class BookTest {

    @Test
    void testSetNameAndGetName() {
        Book book = new Book("");
        book.setName("Effective Java");

        assertEquals("Effective Java", book.getName(), "Book name should be set and retrieved correctly");
    }
}
