package ava.java_school.java_se_02.task3.chancery;

public class CopyBook extends Chancery {
    private int countOfPages;

    public CopyBook(String title, int price, int countOfPages) {
        super(title, price);
        this.countOfPages = countOfPages;
    }

    public CopyBook(String title, int price) {
        super(title, price);
    }

}
