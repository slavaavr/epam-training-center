package ava.tdd;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.LongStream;

@Getter
@Setter
@EqualsAndHashCode
public class Range {

    private long lowerBound;
    private long upperBound;

    public Range(long lowerBound, long upperBound) {
        if (lowerBound > upperBound) {
            throw new IllegalArgumentException();
        }
        this.lowerBound = lowerBound;
        this.upperBound = upperBound;
    }

    public boolean isBefore(Range otherRange) {
        return this.upperBound < otherRange.lowerBound;
    }

    public boolean isAfter(Range otherRange) {
        return this.lowerBound > otherRange.upperBound;
    }

    public boolean isConcurrent(Range otherRange) {
        return this.equals(otherRange);
    }

    public boolean contains(long value) {
        return this.lowerBound <= value && this.upperBound >= value;
    }

    public List<Long> asList() {
        return LongStream.range(this.lowerBound, this.upperBound + 1)
                .boxed()
                .collect(Collectors.toList());
    }

    public Iterator<Long> asIterator() {
        return asList().iterator();
    }
}
