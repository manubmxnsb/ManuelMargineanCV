package Ex4;

import java.util.Scanner;

public class Ex4 {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        System.out.println("Enter the array length");
        int length = console.nextInt();
        int [] myArray = new int[length];
        System.out.println("Enter the array elements");
        int max = 0;
        for(int i = 0; i < length; i++){
            myArray[i]=console.nextInt();
            if(myArray[i] > max)
                max = myArray[i];
        }
        System.out.println(max + " is the maximum element of the array");
    }
}
