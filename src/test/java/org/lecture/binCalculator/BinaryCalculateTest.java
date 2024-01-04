package org.lecture.binCalculator;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BinaryCalculateTest {

    @Test
    void testCalculateAddition() {
        BinaryCalculate calculator = new BinaryCalculate();

        String result1 = calculator.calculatAddition("1011", "110");
        assertEquals("10001", result1);

        String result2 = calculator.calculatAddition("1000", "1110");
        assertEquals("10110", result2);

        String result3 = calculator.calculatAddition("1111", "1111");
        assertEquals("11110", result3);

        String result4 = calculator.calculatAddition("1101", "1001");
        assertEquals("10110", result4);

        String result5 = calculator.calculatAddition("1101", "0");
        assertEquals("1101", result5);
    }

    @Test
    void testCalculateSubtraction() {
        BinaryCalculate calculator = new BinaryCalculate();

        String result1 = calculator.calculatSubtraction("1011", "110");
        assertEquals("0101", result1);

        String result2 = calculator.calculatSubtraction("1110", "1011");
        assertEquals("0011", result2);

        String result3 = calculator.calculatSubtraction("1010", "1101");
        assertEquals("1101", result3);
    }

    @Test
    void testCalculatMultiplication() {
        BinaryCalculate calculator = new BinaryCalculate();

        String result1 = calculator.calculatMultiplication("1011", "11");
        assertEquals("100001", result1);

        String result2 = calculator.calculatMultiplication("1011", "101");
        assertEquals("110111", result2);
    }

    @Test
    void testCalculateDivision() {
        BinaryCalculate calculator = new BinaryCalculate();

        String result1 = calculator.calculatDivision("1100", "11");
        assertEquals("0100", result1);

        String result2 = calculator.calculatDivision("1011", "11");
        assertEquals("0011", result2);
    }
}