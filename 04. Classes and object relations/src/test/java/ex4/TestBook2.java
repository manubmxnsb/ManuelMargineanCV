package ex4;

import ex2.Author;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestBook2 {
    @Test
    void testBook3Args() {
        Author author = new Author("Agatha","agatha@gmail.com",'f');
        Author author2 = new Author("Christe","christe@gmail.com",'f');
        Author[] authors = new Author[]{author, author2};
        Book2 book = new Book2("John's Life",authors,12);
        assertEquals("John's Life",book.getName());
        assertEquals(12,book.getPrice());
        assertEquals("Autorii sunt :  Agatha (f) at agatha@gmail.com Christe (f) at christe@gmail.com",book.printAuthors());
    }
    @Test
    void testBook4Args() {
        Author author = new Author("Agatha","agatha@gmail.com",'f');
        Author author2 = new Author("Christe","christe@gmail.com",'f');
        Author[] authors = new Author[]{author, author2};
        Book2 book = new Book2("John's Life",authors,12,5);
        assertEquals("John's Life",book.getName());
        assertEquals(12,book.getPrice());
        assertEquals(5,book.getQtyInStock());
        book.setPrice(10);
        assertEquals(10,book.getPrice());
        book.setQtyInStock(3);
        assertEquals(3,book.getQtyInStock());
        assertEquals("Autorii sunt :  Agatha (f) at agatha@gmail.com Christe (f) at christe@gmail.com",book.printAuthors());
    }
}
