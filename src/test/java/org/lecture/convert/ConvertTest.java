package org.lecture.convert;

import org.junit.jupiter.api.Test;
import org.lecture.CalculatorRAM;
import org.lecture.convert.Convert;

import static org.junit.jupiter.api.Assertions.*;

class ConvertTest {
    private CalculatorRAM calculatorRAM;



    @Test
    void testConvertDecimalToBinary() {
        Convert convert = new Convert();

        String result1 = convert.convertDecimalToGivenSystem("145",2);
        assertEquals("10010001", result1);

        String result2 = convert.convertDecimalToGivenSystem("234",2);
        assertEquals("11101010", result2);
    }
    @Test
    void testConvertDecimalToOctal() {
        Convert convert = new Convert();

        String result1 = convert.convertDecimalToGivenSystem("145", 8);
        assertEquals("221", result1);

        String result2 = convert.convertDecimalToGivenSystem("116", 8);
        assertEquals("164", result2);
    }

    @Test
    void testConvertDecimalToHexadecimal() {
        Convert convert = new Convert();

        String result1 = convert.convertDecimalToGivenSystem("20388", 16);
        assertEquals("4FA4", result1);

        String result2 = convert.convertDecimalToGivenSystem("314", 16);
        assertEquals("13A", result2);
    }

    @Test
    void testConvertBinaryToDecimal() {
        Convert convert = new Convert();

        String result1 = convert.convertToDecimal("10010001",2);
        assertEquals("145", result1);

        String result2 = convert.convertToDecimal("11101010",2);
        assertEquals("234", result2);
    }

    @Test
    void testConvertOtalToDecimal() {
        Convert convert = new Convert();

        String result1 = convert.convertToDecimal("221", 8);
        assertEquals("145", result1);

        String result2 = convert.convertToDecimal("164",8);
        assertEquals("116", result2);
    }

    @Test
    void testConvertHexadecimalToDecimal () {
        Convert convert = new Convert();

        String result1 = convert.convertToDecimal("4FA4", 16);
        assertEquals("20388", result1);

        String result2 = convert.convertToDecimal("13A", 16);
        assertEquals("314", result2);
    }
}