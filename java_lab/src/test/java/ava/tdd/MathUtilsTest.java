package ava.tdd;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.number.IsCloseTo.closeTo;
import static org.junit.jupiter.api.Assertions.assertThrows;

class MathUtilsTest {

    @ParameterizedTest(name = "factorial({0}) = {1}")
    @CsvSource({"0, 1", "4, 24", "5, 120"})
    void factorial(int value, int answer) {
        assertThat(MathUtils.factorial(value), is(answer));
    }

    @ParameterizedTest(name = "{0} * {1} = {2}")
    @CsvSource({"0, 1, 0", "-1, 3, -3", "-3, -3, 9"})
    void multiply(double a, double b, double answer) {
        assertThat(MathUtils.multiply(a, b), closeTo(answer, 0.00001));
    }

    @ParameterizedTest(name = "{0} / {1} = {2}")
    @CsvSource({"0, 3, 0", "-1, 2 ,-0.5", "-4, -2, 2"})
    void divide(double a, double b, double answer) {
        assertThat(MathUtils.divide(a, b), closeTo(answer, 0.00001));
    }

    @Test
    @DisplayName("factorial with negative argument")
    void testFactorialForNegativeVariable() {
        assertThrows(IllegalArgumentException.class, () -> MathUtils.factorial(-1));
    }

    @Test
    @DisplayName("dividing by zero")
    void testDividingByZero(){
        assertThat(MathUtils.divide(1, 0), is(Double.POSITIVE_INFINITY));
        assertThat(MathUtils.divide(-1, 0), is(Double.NEGATIVE_INFINITY));
        assertThat(MathUtils.divide(0, 0), is(Double.NaN));
    }
}