package ex3;

import ex2.Author;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestBook {
    @Test
    void testBook3Args() {
        Author author = new Author("Agatha","agatha@gmail.com",'f');
        Book book = new Book("John's Life",author,12);
        assertEquals("John's Life",book.getName());
        assertEquals(12,book.getPrice());
        assertEquals("Agatha (f) at agatha@gmail.com",book.getAuthor().toString());
    }
    @Test
    void testBook4Args() {
        Author author = new Author("Agatha","agatha@gmail.com",'f');
        Book book = new Book("John's Life",author,12,5);
        assertEquals("John's Life",book.getName());
        assertEquals(12,book.getPrice());
        assertEquals("Agatha (f) at agatha@gmail.com",book.getAuthor().toString());
        assertEquals(5,book.getQtyInStock());
        book.setPrice(10);
        assertEquals(10,book.getPrice());
        book.setQtyInStock(3);
        assertEquals(3,book.getQtyInStock());
    }
}
