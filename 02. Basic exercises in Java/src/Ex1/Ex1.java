package Ex1;

import java.util.Scanner;

public class Ex1 {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Enter a number");
        int firstNumber = keyboard.nextInt();
        System.out.println("Enter another number");
        int secondNumber = keyboard.nextInt();
        if (firstNumber > secondNumber) {
            System.out.println(firstNumber + " is greater than " + secondNumber);
        } else {
            System.out.println(secondNumber + " is greater than " + firstNumber);
        }
    }
}
