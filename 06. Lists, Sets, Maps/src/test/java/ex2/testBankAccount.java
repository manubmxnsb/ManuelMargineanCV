package ex2;

import ex1.BankAccount;
import ex3.Bank2;
import org.junit.jupiter.api.Test;

import java.util.Comparator;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class testBankAccount {
    @Test
    void testBankAccount() {
        Bank bank = new Bank();
        bank.addAccount("Marin",180);
        bank.addAccount("Dorin",280);
        bank.addAccount("Sorin",150);
        bank.addAccount("Gorin",300);
        bank.addAccount("Tarin",235);
        bank.printAccounts();
        System.out.println('\n');
        bank.printAccounts(200,300);
        System.out.println('\n');
        List<BankAccount> bankAccounts = bank.getBankAccounts();
        bankAccounts.sort(Comparator.comparing(BankAccount::getOwner));
        bankAccounts.forEach(System.out::println);
    }
    @Test
    void testBankAccount2() {
        Bank2 bank2 = new Bank2();
        bank2.addAccount("Marin",180);
        bank2.addAccount("Dorin",280);
        bank2.addAccount("Sorin",150);
        bank2.addAccount("Gorin",300);
        bank2.addAccount("Tarin",235);
        System.out.println(bank2.getBankAccount("Tarin"));

    }
}
