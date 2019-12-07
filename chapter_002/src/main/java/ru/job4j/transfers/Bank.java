package ru.job4j.transfers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Bank {
    private Map<User, ArrayList<Account>> bankAccounts = new HashMap<>();

    public void addUser(User user) {
        this.bankAccounts.put(user, new ArrayList<>());
    }

    public User getUser(String passport) {
        User result = null;
        if (this.bankAccounts.keySet().stream().anyMatch(u -> u.getPassport().equals(passport))) {
            result = this.bankAccounts.keySet().stream().filter(u -> u.getPassport().equals(passport)).findFirst().get();
        }
        return result;
    }

    private Account getAccount(User user, Account account) {
        ArrayList<Account> list = this.bankAccounts.get(user);
        return list.get(list.indexOf(account));
    }

    public void deleteUser(User user) {
        this.bankAccounts.remove(user);
    }

    public void addAccountToUser(String passport, Account account) {
        if (getUser(passport) != null) {
            this.bankAccounts.get(getUser(passport)).add(account);
        }
    }

    public void deleteAccountFromUser(String passport, Account account) {
        if (getUser(passport) != null) {
            this.bankAccounts.get(getUser(passport)).remove(account);
        }
    }

    public List<Account> getUserAccounts(String passport) {
        List<Account> result = new ArrayList<>();
        if (getUser(passport) != null) {
            result = this.bankAccounts.get(getUser(passport));
        }
        return result;
    }

    public boolean transferMoney(String srcPassport, String srcRequisite, String destPassport, String dstRequisite, double amount) {
        User user1 = getUser(srcPassport);
        User user2 = getUser(destPassport);
        Account account1 = new Account(0, srcRequisite);
        Account account2 = new Account(0, dstRequisite);
        return this.bankAccounts.get(user1).contains(account1)
                && this.bankAccounts.get(user2).contains(account2)
                && getAccount(user1, account1).transfer(getAccount(user2, account2), amount);
    }
}
