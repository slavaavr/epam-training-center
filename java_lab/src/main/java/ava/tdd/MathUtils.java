package ava.tdd;

import lombok.experimental.UtilityClass;

import java.util.stream.IntStream;

@UtilityClass
public class MathUtils {

    public int factorial(int value) {
        if (value < 0) {
            throw new IllegalArgumentException();
        }
        return IntStream.range(1, value + 1).reduce(1, (a, b) -> a * b);
    }

    public double multiply(double a, double b) {
        return a * b;
    }

    public double divide(double a, double b) {
        return a / b;
    }
}
