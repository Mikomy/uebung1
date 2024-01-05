package org.lecture;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.*;

import static org.junit.jupiter.api.Assertions.*;
class EnterInputTest {
    private CalculatorRAM calculatorRAM;
    private SaveResult saveResult;
    private ByteArrayOutputStream outputStream;
    private EnterInput enterInput;

    @BeforeEach
    public void setUp() {
        calculatorRAM = new CalculatorRAM();
        outputStream = new ByteArrayOutputStream();
        enterInput = new EnterInput(calculatorRAM);
        System.setOut(new PrintStream(outputStream, true));
    }

    @Test
    void enterNumber() {
        InputStream original = System.in;
        String input = "1\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        System.setOut(new PrintStream(outputStream));

        enterInput.enterNumber();

        assertEquals("Which number system would you like to use?", outputStream.toString().trim());

        System.setIn(original);
        System.setOut(new PrintStream(new FileOutputStream(FileDescriptor.out)));
    }

    @Test
    void enterOperation() {
    }

    @Test
    void enter3PArt() {
    }
}