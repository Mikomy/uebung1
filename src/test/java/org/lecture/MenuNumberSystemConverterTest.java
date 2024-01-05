package org.lecture;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.*;

import static org.junit.jupiter.api.Assertions.*;

class MenuNumberSystemConverterTest {


    private CalculatorRAM calculatorRAM;
    private SaveResult saveResult;
    private ByteArrayOutputStream outputStream;
    EnterInput enterInput;
    MenuNumberSystemConverter menu;
    @BeforeEach
    public void setUp() {
        calculatorRAM = new CalculatorRAM();
        saveResult = new SaveResult();
        calculatorRAM.createInput0(calculatorRAM);
        outputStream = new ByteArrayOutputStream();
        enterInput = new EnterInput(calculatorRAM);
        menu = new MenuNumberSystemConverter(calculatorRAM);
    }

    @Test
    void runMenu_whenInputtingNumber_shouldUpdateCalculatorRAMWithNum1() {


        InputStream original = System.in;
        String input = "1\n1\n2\n1\n3\n1\n1\n9\n";
        ByteArrayInputStream bais = new ByteArrayInputStream("1\n1\n2\n1\n3\n1\n1\n9\n".getBytes());
        System.setIn(bais);
        System.setOut(new PrintStream(outputStream));

        // Act
        menu.runMenu();
        System.setIn(original);
        System.setOut(new PrintStream(new FileOutputStream(FileDescriptor.out)));
        // Assert
        Inputs updatedInputs = calculatorRAM.getInputs().get(0);
        assertEquals("DECIMAL", updatedInputs.getNumberSystem1());
        // Add more assertions for other updated values as needed
    }

}