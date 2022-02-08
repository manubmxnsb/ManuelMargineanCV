package Ex6;

import java.util.Scanner;

public class Ex6 {

    public static long recursive_factorial(int number)
    {
        if (number >= 1)
            return number * recursive_factorial(number - 1);
        else
            return 1;
    }

    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        int[] myArray = new int[10];
        int N = (int) (Math.random() * (10 - 0));
        System.out.println("Write 1 for non recursive method, 2 for recursive ");
        int choice = console.nextInt();
        if(choice == 1)
        {
            int N_fac = 1;
            if(N == 0) {
                N_fac = 1;
            }
            else {
                for(int i = 2; i<N+1; i++)
                    N_fac = N_fac * i;
            }
            System.out.println("Factorial of " + N + " is " + N_fac);
        }
        else
        {
            if(choice == 2)
            {
                long factorial = recursive_factorial(N);
                System.out.println("Factorial of " + N + " is " + factorial);
            }
            else
            {
                System.out.println("Try again using only 1 or 2");
            }
        }
    }
}