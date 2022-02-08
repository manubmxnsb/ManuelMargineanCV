package ex3;

import ex1.BankAccount;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.TreeSet;

public class Bank2 {
    private TreeSet<BankAccount> bankAccounts = new TreeSet<>();

    public Bank2() {
    }

    public void addAccount(String owner, double balance) {
        this.bankAccounts.add(new BankAccount(owner, balance));
    }

    public void printAccounts() {
        this.bankAccounts.forEach(System.out::println);
    }

    public void printAccounts(double minBalance, double maxBalance) {
        this.bankAccounts.stream()
                .filter(bankAccount -> bankAccount.getBalance() >= minBalance && bankAccount.getBalance() <= maxBalance)
                .forEach(System.out::println);
    }

    public BankAccount getBankAccount(String owner) {
        return this.bankAccounts.stream()
                .filter(bankAccount -> bankAccount.getOwner().equals(owner))
                .findFirst()
                .orElse(null);
    }
}
