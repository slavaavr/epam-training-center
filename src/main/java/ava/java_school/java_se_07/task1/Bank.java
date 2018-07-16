package ava.java_school.java_se_07.task1;

import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Bank {
    private Map<Integer, Account> accounts;
    private Deque<Transaction> transactions;

    public Bank() {
        this.accounts = new TreeMap<>();
        this.transactions = new ArrayDeque<>();
    }

    public Account getAccountById(int id) {
        return this.accounts.get(id);
    }

    public void addAccount(Account account) {
        this.accounts.put(account.getId(), account);
    }

    public void addAccount(Map<Integer, Account> accounts) {
        this.accounts.putAll(accounts);
    }

    public void addTransaction(Transaction transaction) {
        this.transactions.add(transaction);
    }

    public void addTransaction(Deque<Transaction> transaction) {
        this.transactions.addAll(transaction);
    }

    public void executeTransactions() {
        ExecutorService threadPool = Executors.newFixedThreadPool(5);
        Transaction pointer;
        while ((pointer = this.transactions.poll()) != null) {
            threadPool.execute(pointer);
        }
        threadPool.shutdown();
        try {
            threadPool.awaitTermination(3, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void printAccounts() {
        System.out.println(this.accounts.values());
    }

}
