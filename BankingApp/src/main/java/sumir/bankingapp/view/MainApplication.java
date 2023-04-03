package sumir.bankingapp.view;

import java.util.ArrayList;
import java.util.Scanner;
import sumir.bankingapp.controller.BankController;
import sumir.bankingapp.model.Account;

public class MainApplication {

    BankController bc;

    MainApplication() {
        bc = new BankController();
    }

    public void showMenu() {
        System.out.println("================================");
        System.out.println("Welcome to Chor pani bank pani");
        System.out.println("================================");
        System.out.println("");
        System.out.println("1. Create New Bank Account.");
        System.out.println("2. List all Accounts.");
        System.out.println("3. Search Account");
        System.out.println("4. Update Account");
        System.out.println("5. Delete Account");
        System.out.println("");
        System.out.println("Enter your Choice: ");
    }

    public int getChoice() {
        Scanner sc = new Scanner(System.in);
        return sc.nextInt();

    }

    public void searchAccount() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the acc no to search:");
        int accNo = sc.nextInt();
        Account acc = bc.search(accNo);
        if (acc != null) {
            System.out.println("Account found! The acc detail is:");
            System.out.println(acc.toString());
        } else {
            System.out.println("Account could not be found! Better luck next time");

        }

    }

    public void listAllAccounts() {
        ArrayList<Account> allAcc = bc.listAll();
        for (Account a : allAcc) {
            System.out.println(a.toString());
        }
    }

    public void createNewAccount() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Account No: ");
        int accNo = sc.nextInt();
        sc.nextLine();

        System.out.println("Enter Name: ");
        String name = sc.nextLine();

        System.out.println("Enter Balance: ");
        int balance = sc.nextInt();

        Account newAccount = new Account(accNo, name, balance);
        if (bc.newAccount(newAccount) == -1) {
            System.out.println("Cannot create the account.");
        } else {
            System.out.println("Account created successfully!");
        }

    }

    public void updateAccount() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the acc no to update:");
        int accNo = sc.nextInt();
        Account acc = bc.search(accNo);
        if (acc != null) {
            System.out.println("Account found! The current acc detail is:");
            System.out.println(acc.toString());

            System.out.println("Enter new Name or press enter to skip: ");
            sc.nextLine();
            String name = sc.nextLine();
            if (!name.equals("")) {
                acc.setName(name);
            }

            System.out.println("Enter new Balance or press enter to skip: ");
            String balanceStr = sc.nextLine();
            if (!balanceStr.equals("")) {
                int balance = Integer.parseInt(balanceStr);
                acc.setBalance(balance);
            }

            bc.updateAccount(acc);
            System.out.println("Account updated successfully!");
        } else {
            System.out.println("Account could not be found! Better luck next time");

        }
    }

    public void deleteAccount() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the acc no to delete:");
        int accNo = sc.nextInt();
        Account acc = bc.search(accNo);
        if (acc != null) {
            if (bc.deleteAccount(accNo) == -1) {
                System.out.println("Cannot delete the account.");
            } else {
                System.out.println("Account deleted successfully!");
            }
        } else {
            System.out.println("Account could not be found! Better luck next time");
        }
    }

    public static void main(String[] args) {
        MainApplication ma = new MainApplication();
        //1. display the menu.
        while (true) {
            ma.showMenu();
            int userChoice = ma.getChoice();

            switch (userChoice) {
                case 1:
                    ma.createNewAccount();
                    break;
                case 2:
                    ma.listAllAccounts();
                    break;
                case 3:
                    ma.searchAccount();
                    break;
                case 4:
                    ma.updateAccount();
                    break;
                case 5:
                    ma.deleteAccount();
                    break;
                default:
                    System.out.println("Please enter valid choice.");

            }
        }
    }

}
