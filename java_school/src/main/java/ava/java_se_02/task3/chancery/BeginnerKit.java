package ava.java_se_02.task3.chancery;

import java.util.Arrays;
import java.util.List;

public class BeginnerKit {
    private List<Chancery> beginnerKit;

    public BeginnerKit() {
        Chancery pen = new Pen("Ручка шариковая масляная Pilot", 56);
        Chancery pencil = new Pencil("Простой карандаш koh-i-noor", 45);
        Chancery copyBook1 = new CopyBook("Тетрадь, 48 листов", 28);
        Chancery copyBook2 = new CopyBook("Тетрадь, 48 листов", 31);
        Chancery glue = new Glue("Клей-карандаш Erich Krause 15 гр", 54);
        beginnerKit = Arrays.asList(pen, pencil, copyBook1, copyBook2, glue);
    }

    public BeginnerKit(List<Chancery> beginnerKit) {
        this.beginnerKit = beginnerKit;
    }

    public List<Chancery> getBeginnerKit() {
        return beginnerKit;
    }

    public void setBeginnerKit(List<Chancery> beginnerKit) {
        this.beginnerKit = beginnerKit;
    }
}
