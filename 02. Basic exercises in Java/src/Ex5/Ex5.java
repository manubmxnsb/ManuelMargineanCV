package Ex5;

import java.util.Scanner;

public class Ex5 {
    static void bubbleSort(int arr[], int n)
    {
        int i, j, temp;
        boolean swapped;
        for (i = 0; i < n - 1; i++)
        {
            swapped = false;
            for (j = 0; j < n - i - 1; j++)
            {
                if (arr[j] > arr[j + 1])
                {
                    // swap arr[j] and arr[j+1]
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapped = true;
                }
            }

            // IF no two elements were
            // swapped by inner loop, then break
            if (swapped == false)
                break;
        }
    }

    static void printArray(int arr[], int size)
    {
        int i;
        for (i = 0; i < size; i++)
            System.out.print(arr[i] + " ");
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        int [] myArray = new int[10];
        int max = 0;
        for(int i = 0; i < 10; i++){
            myArray[i]=(int)(Math.random() * (25 - 0));
        }
        System.out.println("Unsorted array ");
        printArray(myArray,10);
        Ex5 ob = new Ex5();
        bubbleSort(myArray,10);
        System.out.println("Sorted array ");
        printArray(myArray,10);

    }
}