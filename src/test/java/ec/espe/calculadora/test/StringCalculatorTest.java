package ec.espe.calculadora.test;

import ec.espe.calculadora.model.StringCalculator;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class StringCalculatorTest {

    @Test
    void emptyStringReturnsZero() {
        assertEquals(0, new StringCalculator().add(""));
    }

    @Test
    void singleNumberReturnsItself() {
        assertEquals(1, new StringCalculator().add("1"));
    }

    @Test
    void twoNumbersReturnSum() {
        assertEquals(3, new StringCalculator().add("1,2"));
    }

    @Test
    void manyNumbersReturnSum() {
        assertEquals(6, new StringCalculator().add("1,2,3"));
        assertEquals(10, new StringCalculator().add("1,2,3,4"));
    }

    @Test
    void newLinesAreSeparatorsToo() {
        assertEquals(6, new StringCalculator().add("1\n2,3"));
    }

    @Test
    void customDelimiterWorks() {
        assertEquals(3, new StringCalculator().add("//;\n1;2"));
    }

    @Test
    void negativesThrowException() {
        assertThrows(
            IllegalArgumentException.class,
            () -> new StringCalculator().add("1,-2,3")
        );
    }
}
