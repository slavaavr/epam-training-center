package ava.task1;

import java.math.BigDecimal;

public class Account {
    private int id;
    private String holder;
    private BigDecimal money;

    public Account(int id, String holder, BigDecimal money) {
        this.id = id;
        this.holder = holder;
        this.money = money;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public void setMoney(BigDecimal money) {
        this.money = money;
    }
}
