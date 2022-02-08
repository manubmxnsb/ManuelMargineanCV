package Ex3;

import ex3.decryptFileService;
import ex3.encryptFileService;

import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        System.out.println(" 1. Encrypt file \n 2. Decrypt file \n 3. Quit program \n Enter a choice : ");
        int choice = console.nextInt();
        boolean continua = true;
        while(continua) {
            switch(choice) {
                case 1:
                    encryptFileService.encryptAndSaveContent("D:\\Scoala\\ISP\\30123_1_marginean_manuel_adrian_isp_labs\\Laborator7\\src\\main\\java\\ex3\\testFile.txt");
                    break;
                case 2:
                    decryptFileService.decryptAndSaveContent("D:\\Scoala\\ISP\\30123_1_marginean_manuel_adrian_isp_labs\\Laborator7\\src\\main\\java\\ex3\\testFile.txt");
                    break;
                case 3:
                    continua = false;
                    break;
                default:
                    System.out.println("Enter numbers between 1 and 3 only \n");
                    break;
            }
        }
    }
}