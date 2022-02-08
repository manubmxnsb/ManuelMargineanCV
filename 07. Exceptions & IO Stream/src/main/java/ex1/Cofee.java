package ex1;

public class Cofee {
    private int temp;
    private int conc;
    private static int number = 0;

    Cofee(int t, int c) {
        temp = t;
        conc = c;
        number++;
    }

    int getTemp() {
        return temp;
    }

    int getConc() {
        return conc;
    }

    int getNumber() {
        return number;
    }

    public String toString() {
        return "[cofee temperature=" + temp + ":concentration=" + conc + "]";
    }
}
