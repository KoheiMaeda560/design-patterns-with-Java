package iterator;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Iterator;

import org.junit.jupiter.api.Test;

class BookShelfTest {

    @Test
    void testAppendBookAndGetBookAt() {
        BookShelf bookShelf = new BookShelf(5);
        Book book1 = new Book("Design Patterns");

        bookShelf.appendBook(book1);

        assertEquals("Design Patterns", bookShelf.getBookAt(0).getName(), "The first book should be 'Design Patterns'");
    }

    @Test
    void testGetLength() {
        BookShelf bookShelf = new BookShelf(5);
        assertEquals(0, bookShelf.getLength(), "BookShelf should initially be empty");

        bookShelf.appendBook(new Book("Effective Java"));
        assertEquals(1, bookShelf.getLength(), "BookShelf length should be 1 after adding a book");
    }

    @Test
    void testIterator() {
        BookShelf bookShelf = new BookShelf(3);
        Book book1 = new Book("Clean Code");
        Book book2 = new Book("Refactoring");


        bookShelf.appendBook(book1);
        bookShelf.appendBook(book2);

        Iterator<Book> iterator = bookShelf.iterator();
        assertTrue(iterator.hasNext(), "Iterator should have next element");
        assertEquals("Clean Code", iterator.next().getName(), "The first book should be 'Clean Code'");
        assertEquals("Refactoring", iterator.next().getName(), "The second book should be 'Refactoring'");
        assertFalse(iterator.hasNext(), "Iterator should have no more elements");
    }
}