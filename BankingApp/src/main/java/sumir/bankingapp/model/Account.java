package sumir.bankingapp.model;

public class Account {

    private int accNo;
    private String name;
    private int balance;

    public Account() {

    }

    public Account(int accNo, String name, int balance) {
        this.accNo = accNo;
        this.name = name;
        this.balance = balance;
    }

    public void setAccNo(int accNo) {
        this.accNo = accNo;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public int getAccNo() {
        return this.accNo;
    }

    public String getName() {
        return this.name;
    }

    public int getBalance() {
        return this.balance;
    }

    @Override
    public String toString() {
        return "Account no: " + this.accNo + " Name: " + this.name + " Balance: " + this.balance;
    }
}
