package Ex3_Author;

public class TestAuthor {
    public static void main(String[] args) {
        Author a1 = new Author("Marty","martiness99@gmail.com", 'm');
        System.out.println("Author name : " + a1.getName());
        System.out.println("Author mail : " + a1.getEmail());
        System.out.println("Author gender : " + a1.getGender());
        a1.setEmail("marty99@gmail.com");
        System.out.println(a1.toString());
    }
}
