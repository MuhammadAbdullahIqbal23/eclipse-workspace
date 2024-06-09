package i222504_LAB1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Account {
    private int accountNum;
    private double balance;
    private String accountType;

    public Account(int accountNum, String accountType) {
        this.accountNum = accountNum;
        this.accountType = accountType;
        this.balance = 0;
    }

    public int getaccountNum() {
        return accountNum;
    }

    public double getBalance() {
        return balance;
    }

    public String getaccountType() {
        return accountType;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposited Successfully.");
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    public boolean withdraw(double amount) {
        if (amount > 0 && balance >= amount) {
            balance -= amount;
            System.out.println("Withdrawal Successful. New Balance: " + balance);
            return true;
        } else {
            System.out.println("Insufficient balance or invalid withdrawal amount.");
            return false;
        }
    }

    public void display() {
    	System.out.println("Account number: " + accountNum);
        System.out.println("Balance: " + balance);
        System.out.println("Account type: " + accountType);
    }
}

class Customer {
    private int customerId;
    private String name;
    private List<Account> accounts;

    public Customer(int customerId, String name) {
        this.customerId = customerId;
        this.name = name;
        this.accounts = new ArrayList<>();
    }

    public int getCustomerId() {
        return customerId;
    }

    public String getName() {
        return name;
    }

    public void addAccount(Account account) {
        accounts.add(account);
    }

    public Account getAccount(int accountNum) {
        for (Account account : accounts) {
            if (account.getaccountNum() == accountNum) {
                return account;
            }
        }
        return null;
    }

    
}

public class task3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter customer ID:");
        int customerId = scanner.nextInt();

        System.out.println("Enter customer name:");
        String name = scanner.next();

        Customer customer = new Customer(customerId, name);

        while (true) {
            System.out.println("1. Add account");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Display account info");
            System.out.println("5. Exit");

            System.out.println("Enter your choice:");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Enter account number:");
                    int accountNumber = scanner.nextInt();

                    System.out.println("Enter account type (Savings/Current):");
                    String accountType = scanner.next();

                    Account account = new Account(accountNumber, accountType);
                    customer.addAccount(account);
                    break;
                case 2:
                    System.out.println("Enter account number:");
                    int depositAccountNumber = scanner.nextInt();

                    System.out.println("Enter amount to deposit:");
                    double depositAmount = scanner.nextDouble();

                    Account depositAccount = customer.getAccount(depositAccountNumber);
                    if (depositAccount != null) {
                        depositAccount.deposit(depositAmount);
                    } else {
                        System.out.println("Account not found");
                    }
                    break;
                case 3:
                    System.out.println("Enter account number:");
                    int withdrawAccountNumber = scanner.nextInt();

                    System.out.println("Enter amount to withdraw:");
                    double withdrawAmount = scanner.nextDouble();

                    Account withdrawAccount = customer.getAccount(withdrawAccountNumber);
                    if (withdrawAccount != null) {
                        if (withdrawAccount.withdraw(withdrawAmount)) {
                            System.out.println("Withdrawal successful");
                        } else {
                            System.out.println("Insufficient balance");
                        }
                    } else {
                        System.out.println("Account not found");
                    }
                    break;
                case 4:
                    System.out.println("Enter account number:");
                    int displayAccountNumber = scanner.nextInt();

                    Account displayAccount = customer.getAccount(displayAccountNumber);
                    if (displayAccount != null) {
                        displayAccount.display();
                    } else {
                        System.out.println("Account not found");
                    }
                    break;
                case 5:
                    scanner.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice");
            }
        }
    }
}
