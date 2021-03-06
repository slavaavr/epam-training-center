package ava.java_se_07.task1;

import java.math.BigDecimal;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Account implements Comparable<Account> {
    private int id;
    private String holder;
    private BigDecimal money;
    private Lock lock = new ReentrantLock();

    public Account(int id, String holder, BigDecimal money) {
        this.id = id;
        this.holder = holder;
        this.money = money;
    }

    public int getId() {
        return id;
    }

    public String getHolder() {
        return holder;
    }

    public void setHolder(String holder) {
        this.holder = holder;
    }

    public BigDecimal getMoney() {
        return money;
    }

    public boolean withdraw(BigDecimal money){
        if(this.money.compareTo(money) >= 0){
            lock.lock();
            this.money = this.money.subtract(money);
            lock.unlock();
            return true;
        } else {
            return false;
        }

    }

    public void deposit(BigDecimal money){
        lock.lock();
        this.money = this.money.add(money);
        lock.unlock();
    }

    @Override
    public int compareTo(Account o) {
        if(this.getId() > o.getId())
            return 1;
        else if(this.getId() < o.getId())
            return -1;
        return 0;
    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", holder='" + holder + '\'' +
                ", money=" + money +
                '}';
    }
}
