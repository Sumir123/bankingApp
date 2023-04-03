package sumir.bankingapp.controller;

import java.sql.ResultSet;
import java.util.ArrayList;
import sumir.bankingapp.model.Account;

public class BankController {

    DBController dbConn;

    public BankController() {
        dbConn = new DBController("jdbc:mysql://localhost:3306/bca", "root", "password");
    }

    public int newAccount(Account acc) {
        dbConn.iud("INSERT INTO accounts (accNo, name, balance) VALUES ('" + acc.getAccNo() + "', '" + acc.getName() + "', " + acc.getBalance() + ");");
        return 1;
    }

    public ArrayList<Account> listAll() {
        ArrayList<Account> accountList = new ArrayList<>();
        ResultSet rs = dbConn.select("SELECT * FROM accounts;");
        try {
            while (rs.next()) {
                Account acc = new Account(rs.getInt("accNo"), rs.getString("name"), rs.getInt("balance"));
                accountList.add(acc);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return accountList;
    }

    public Account search(int accNo) {
        ResultSet rs = dbConn.select("SELECT * FROM accounts WHERE accNo=" + accNo + ";");
        try {
            if (rs != null && rs.next()) {
                Account acc = new Account(rs.getInt("accNo"), rs.getString("name"), rs.getInt("balance"));
                return acc;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return null;
    }

    public int deleteAccount(int accNo) {
        int result = dbConn.iud("DELETE FROM accounts WHERE accNo=" + accNo + ";");
        return result;
    }

    public int updateAccount(Account acc) {
        int result = dbConn.iud("UPDATE accounts SET name='" + acc.getName() + "', balance=" + acc.getBalance() + " WHERE accNo=" + acc.getAccNo() + ";");
        return result;
    }
}
