package ex2;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.Scanner;

public class Character {
    public static void main(String args[]) throws FileNotFoundException {
        int nr = 0;
        Scanner console = new Scanner(System.in);
        System.out.println("Enter a character");
        char character = console.next().charAt(0);
        try {
            Reader fileInput = new FileReader("D:\\Scoala\\ISP\\30123_1_marginean_manuel_adrian_isp_labs\\Laborator7\\src\\main\\java\\ex2\\test.txt");
            int ch = fileInput.read();
            while (ch != -1) {
                if ((char) ch == character) {
                    nr++;
                }
                ch = fileInput.read();
            }
            fileInput.close();
        } catch (Exception charac) {
            System.out.println(charac.getMessage());
        }

        System.out.println("Number of times that " + character + " appeared: " + nr);
    }
}