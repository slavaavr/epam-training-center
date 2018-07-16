package ava.java_school.java_se_07.task1;

import java.math.BigDecimal;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Transaction implements Runnable{
    private final Account sender;
    private final Account recipient;
    private BigDecimal money;

    public Transaction(Account sender, Account recipient, BigDecimal money) {
        this.sender = sender;
        this.recipient = recipient;
        this.money = money;
    }

    @Override
     public void run() {
        synchronized (this.sender){
            if(this.sender.withdraw(this.money)) {
                synchronized (this.recipient){
                    this.recipient.deposit(this.money);
                }
            } else {
                System.err.printf("Error! %s can't send %s$ to %s (not enough money)\n", sender.getHolder(), money.toString(), recipient.getHolder());
            }
        }
        Lock lock = new ReentrantLock();
        lock.lock();
    }
}
