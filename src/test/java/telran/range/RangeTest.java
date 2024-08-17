package telran.range;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Iterator;
import java.util.NoSuchElementException;

import org.junit.jupiter.api.Test;

import telran.range.exceptions.OutOfRangeMaxValueException;
import telran.range.exceptions.OutOfRangeMinValueException;

public class RangeTest {
    private static final int MIN = 50;
    private static final int MAX = 100;
    Range range = Range.getRange(MIN, MAX);
    @Test
    void wrongRangeCtreatingTest() {
        assertThrowsExactly(IllegalArgumentException.class, () -> Range.getRange(MAX, MIN) );
    }
    @Test
    void rightNumberTest() throws Exception {
        range.checkNumber(55);
    }
    void wrongNumberTest() throws Exception {
        assertThrowsExactly(OutOfRangeMaxValueException.class,
         () -> range.checkNumber(MAX + 1));
         assertThrowsExactly(OutOfRangeMinValueException.class, () -> range.checkNumber(MIN - 1));
    }

@Test
    void iteratorTest() {
        Range rangeIt = Range.getRange(0, 5);
        rangeIt.setPredicate((i) -> i % 2 == 0);
    
        Iterator<Integer> it = rangeIt.iterator();
        Integer[] expected = { 0, 2, 4 };
        Integer[] actual = new Integer[expected.length];;

        int index = 0;
        while (it.hasNext()) {
            actual[index++] = it.next();
        }

        assertArrayEquals(expected, actual);
        assertThrows(NoSuchElementException.class, it::next);
    }
}