package ru.job4j.transfers;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.hamcrest.core.Is.is;

public class BankTest {
    Bank bank = new Bank();
    User user = new User("Vadim", "123456");
    Account account1 = new Account(1000, "987");
    Account account2 = new Account(2000, "654");
    Account account3 = new Account(3000, "321");
    Account account4 = new Account(4000, "123");
    Account account5 = new Account(5000, "456");
    Account account6 = new Account(6000, "789");

    @Before
    public void start() {
        bank.addUser(user);
        bank.addAccountToUser(user.getPassport(), account1);
        bank.addAccountToUser(user.getPassport(), account2);
        bank.addAccountToUser(user.getPassport(), account3);
        bank.addAccountToUser(user.getPassport(), account4);
        bank.addAccountToUser(user.getPassport(), account5);
        bank.addAccountToUser(user.getPassport(), account6);
    }

    @Test
    public void whenGetUserAccounts() {
        List<Account> result = bank.getUserAccounts(user.getPassport());
        List<Account> expected = List.of(account1, account2, account3, account4, account5, account6);
        Assert.assertThat(result, is(expected));
    }
}
