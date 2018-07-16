package ava.java_school.java_se_02.task3.chancery;

public abstract class Chancery {
    protected String title;
    protected int price;

    public Chancery(String title, int price) {
        this.title = title;
        this.price = price;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Chancery{" +
                "title='" + title + '\'' +
                ", price=" + price +
                '}';
    }
}
