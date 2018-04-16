package ava.task1;

import java.math.BigDecimal;

public class Account implements Comparable<Account> {
    private int id;
    private String holder;
    private BigDecimal money;

    public Account(int id, String holder, BigDecimal money) {
        this.id = id;
        this.holder = holder;
        this.money = money;
    }

    private int getId() {
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
            this.money = this.money.subtract(money);
            return true;
        } else {
            return false;
        }

    }

    public void deposit(BigDecimal money){
        this.money = this.money.add(money);
    }

    @Override
    public int compareTo(Account o) {
        if(this.getId() > o.getId())
            return 1;
        else if(this.getId() < o.getId())
            return -1;
        return 0;
    }
}
