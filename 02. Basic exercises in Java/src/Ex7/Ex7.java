package Ex7;

import java.util.Scanner;

public class Ex7 {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        int N = (int) (Math.random() * (6 - 1) + 1);
        int tries = 3;
        System.out.println("Pick a number between 6 and 1");
        System.out.println("Tries left " + tries + " /3");
        boolean guessed = false;
        while((tries > 0) && (!guessed))
        {
            int myNumber = console.nextInt();
            if(myNumber == N)
            {
                System.out.println("You guessed it! ");
                guessed = true;
            }
            else
            {
                if(myNumber > N)
                {
                    System.out.println("Your number is too high. Try again.");
                    tries = tries - 1;
                    System.out.println("Tries left " + tries + " /3");
                }
                else
                {
                    System.out.println("Your number is too low. Try again");
                    tries = tries - 1;
                    System.out.println("Tries left " + tries + " /3");
                }
            }
        }
    }
}
