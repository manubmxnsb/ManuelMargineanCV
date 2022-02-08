package ex2;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestAuthor {
    @Test
    void testAuthor() {
        Author author = new Author("John","John@gmail.com",'m');
        assertEquals("John",author.getName());
        assertEquals("John@gmail.com",author.getEmail());
        assertEquals('m',author.getGender());
    }
    @Test
    void testTOString() {
        Author author = new Author("John","John@gmail.com",'m');
        assertEquals("John (m) at John@gmail.com",author.toString());
    }
}
