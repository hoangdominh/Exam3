package Model;

import java.io.Serializable;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Account implements Comparator<Account>, Serializable {
    private int id;
    private String fullName;
    private int accountNumber;
    private double amount;
    private AccountHistory accountHistories;

    static int count=0;
    public Account() {
        id = ++count;
    }

    public Account(int id) {
        id = ++count;
    }

    public Account(String fullName, int accountNumber, double amount) {
        id = ++count;
        this.fullName = fullName;
        this.accountNumber = accountNumber;
        this.amount = amount;
    }

    public Account(String fullName, int accountNumber, double amount, AccountHistory accountHistories) {
        id = ++count;
        this.fullName = fullName;
        this.accountNumber = accountNumber;
        this.amount = amount;
        this.accountHistories = accountHistories;
    }

    public int getId() {
        return id;
    }

    public String getFullName() {
        return fullName;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public double getAmount() {
        return amount;
    }

    public AccountHistory getAccountHistories() {
        return accountHistories;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public void setAccountHistories(AccountHistory accountHistories) {
        this.accountHistories = accountHistories;
    }

    public void input(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhap fullName: ");
        fullName = scanner.nextLine();
        System.out.println("Nhap accountNumber: ");
        accountNumber = Integer.parseInt(scanner.nextLine());
        System.out.println("Nhap amount:");
        amount = Integer.parseInt(scanner.nextLine());
    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", fullName='" + fullName + '\'' +
                ", accountNumber=" + accountNumber +
                ", amount=" + amount +
                ", accountHistories=" + accountHistories +
                '}';
    }
    @Override
    public int compare(Account account1, Account account2) {
        return account2.fullName.compareTo(account1.fullName);
    }

}
