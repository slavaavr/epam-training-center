package ava.java_school.java_se_02.task1;

import java.util.Objects;

public class Pen {
    private String vendorCode;
    private PenColor penColor;
    private InkColor inkColor;
    private int price;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pen pen = (Pen) o;
        return Objects.equals(vendorCode, pen.vendorCode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(vendorCode);
    }

    @Override
    public String toString() {
        return "Pen{" +
                "vendorCode='" + vendorCode + '\'' +
                ", penColor=" + penColor +
                ", inkColor=" + inkColor +
                ", price=" + price +
                '}';
    }
}
