package ex2;

public class Author {
    private String name;
    private String email;
    private char gender;

    public Author(String myName, String myEmail, char myGender) {
        name = myName;
        email = myEmail;
        if ((myGender == 'm') || (myGender == 'f')) {
            gender = myGender;
        } else {
            System.out.println("Write only m or f");
        }
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public char getGender() {
        return gender;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String toString() {
        return this.name + " (" + this.gender + ") at " + this.email;
    }
}
