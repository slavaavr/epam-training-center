package ava.tdd;

import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.LongStream;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNot.not;

@FieldDefaults(level = AccessLevel.PRIVATE)
class RangeTest {

    static Range rangeLow;
    static Range rangeLow2;
    static Range rangeAverage;
    static Range rangeHigh;

    @BeforeAll
    static void beforeAll() {
        rangeLow = new Range(1, 10);
        rangeLow2 = new Range(1, 10);
        rangeAverage = new Range(7, 20);
        rangeHigh = new Range(25, 35);
    }

    @Test
    void isBefore() {
        assertThat(rangeLow.isBefore(rangeHigh), is(true));
    }

    @Test
    void isAfter() {
        assertThat(rangeHigh.isAfter(rangeAverage), is(true));
    }

    @Test
    void isConcurrent() {
        assertThat(rangeLow.isConcurrent(rangeLow2), is(true));
    }

    @Test
    void isNotConcurrent() {
        assertThat(rangeLow.isConcurrent(rangeAverage), not(true));
    }

    @Test
    void contains() {
        assertThat(rangeHigh.contains(30), is(true));
    }

    @Test
    void notContains() {
        assertThat(rangeLow.contains(11), not(true));
    }

    @Test
    void asList() {
        List<Long> rangeList = LongStream
                .range(rangeLow.getLowerBound(), rangeLow.getUpperBound() + 1)
                .boxed()
                .collect(Collectors.toList());
        assertThat(rangeList, hasSize(rangeLow.asList().size()));
        assertThat(rangeList, is(rangeLow.asList()));
    }

    @Test
    void asIterator() {
        Iterator<Long> it = rangeAverage.asIterator();
        rangeAverage.asList().forEach(e -> assertThat(it.next(), is(e)));
    }
}