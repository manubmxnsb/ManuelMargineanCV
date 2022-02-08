package Ex3;

import java.util.Scanner;

public class Ex3 {
    static boolean isPrime(int n)
    {
        if (n <= 1)
            return false;
        for (int i = 2; i < n; i++)
            if (n % i == 0)
                return false;
        return true;
    }

    public static void main(String[] args) {
        int primes = 0;
        Scanner console = new Scanner(System.in);
        System.out.println("Enter a number");
        int a = console.nextInt();
        System.out.println("Enter another number");
        int b = console.nextInt();
        for (int i=a; i<b; i++){
            if(isPrime(i)) {
                System.out.println(i + " ");
                primes++;
            }
        }
        System.out.println("There are " + primes + " prime numbers.");
    }
}
