package ex2;

import ex1.BankAccount;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Bank {
    private List<BankAccount> bankAccounts = new ArrayList<>();

    public Bank() {
    }
    public void addAccount(String owner, double balance) {
        this.bankAccounts.add(new BankAccount(owner, balance));
    }

    public void printAccounts() {
        this.bankAccounts.sort(Comparator.comparingDouble(BankAccount::getBalance).reversed());
        for (int i = 0; i < this.bankAccounts.size() ; i++) {
            System.out.println(this.bankAccounts.get(i).toString());
        }
    }
    public void printAccounts(double minBalance, double maxBalance) {
        this.bankAccounts.sort(Comparator.comparingDouble(BankAccount::getBalance).reversed());
        for (int i = 0; i < this.bankAccounts.size(); i++) {
            if ((minBalance < this.bankAccounts.get(i).getBalance()) && (maxBalance > this.bankAccounts.get(i).getBalance())) {
                System.out.println(this.bankAccounts.get(i).toString());
            }
        }
    }

    public List<BankAccount> getBankAccounts() {
        return bankAccounts;
    }
}
