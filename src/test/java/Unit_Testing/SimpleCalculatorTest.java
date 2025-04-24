package Unit_Testing;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class SimpleCalculatorTest {

    @Test
    void addTwoNumbers() {
        SimpleCalculator numbers = new SimpleCalculator();
        assertEquals(4,numbers.add(2,2));

    }


}