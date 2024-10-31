package iterator;

import static org.junit.jupiter.api.Assertions.*;

import java.util.NoSuchElementException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BookShelfIteratorTest {

    private BookShelf bookShelf;

    @BeforeEach
    void setUp() {
        bookShelf = new BookShelf(2);
        Book book1 = new Book("Effective Java");
        Book book2 = new Book("Java Concurrency in Practice");
        bookShelf.appendBook(book1);
        bookShelf.appendBook(book2);
    }

    @Test
    void testHasNext() {
        BookShelfIterator iterator = new BookShelfIterator(bookShelf);
        assertTrue(iterator.hasNext(), "Iterator should have a next element initially");

        iterator.next(); // Move to next
        assertTrue(iterator.hasNext(), "Iterator should have a next element after first call to next");

        iterator.next(); // Move to next (end of collection)
        assertFalse(iterator.hasNext(), "Iterator should not have a next element at end of collection");
    }

    @Test
    void testNext() {
        BookShelfIterator iterator = new BookShelfIterator(bookShelf);

        assertEquals("Effective Java", iterator.next().getName(), "The first book should be 'Effective Java'");
        assertEquals("Java Concurrency in Practice", iterator.next().getName(), "The second book should be 'Java Concurrency in Practice'");
    }

    @Test
    void testNextThrowsExceptionWhenNoMoreElements() {
        BookShelfIterator iterator = new BookShelfIterator(bookShelf);
        iterator.next();
        iterator.next();

        assertThrows(NoSuchElementException.class, iterator::next, "Calling next when no elements are left should throw NoSuchElementException");
    }
}
