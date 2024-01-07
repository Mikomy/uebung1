package org.lecture;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class EnterInputTest {
    private CalculatorRAM calculatorRAM;
    private EnterInput enterInput;

    @BeforeEach
    void setUp() {
        calculatorRAM = new CalculatorRAM();
    }

    @Test
    void enterNumber() {
        // Provide custom input for testing
        String input = "2\n1\n1\n";
        InputStream inputStream = new ByteArrayInputStream(input.getBytes());
        enterInput = new EnterInput(calculatorRAM, inputStream);

        // Call the method that reads from the custom input stream
        enterInput.enterNumber();

        
    }

    @Test
    void enterOperation() {
    }

    @Test
    void enter3PArt() {
    }
}