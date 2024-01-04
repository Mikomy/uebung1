package org.lecture;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SaveResultTest {
    private CalculatorRAM calculatorRAM;
    private SaveResult saveResult;

    @BeforeEach
    public void setUp() {
        calculatorRAM = new CalculatorRAM();
        saveResult = new SaveResult();
        calculatorRAM.createInput0(calculatorRAM);
    }

    @Test
    public void saveResult() {
        saveResult.saveResult(calculatorRAM, "123");
        Inputs resultInputs = calculatorRAM.getInputs().get(0);
        assertEquals("123", resultInputs.getResult());
    }

    @Test
    public void savedata() {
        // Set initial values in calculatorRAM
        Inputs initialInputs = new Inputs.InputsBuilder()
                .num1("10")
                .numberSystem1("DECIMAL")
                .operator("ADDITION ( + )")
                .num2("5")
                .numberSystem2("BINARY")
                .result(null)
                .build();
        calculatorRAM.add(0, initialInputs);

        // Call saveResult with a new result
        saveResult.saveResult(calculatorRAM, "30");

        // Check that other fields are preserved
        Inputs updatedInputs = calculatorRAM.getInputs().get(0);
        assertEquals("10", updatedInputs.getNum1());
        assertEquals("DECIMAL", updatedInputs.getNumberSystem1());
        assertEquals("ADDITION ( + )", updatedInputs.getOperator());
        assertEquals("5", updatedInputs.getNum2());
        assertEquals("BINARY", updatedInputs.getNumberSystem2());
        assertEquals("30", updatedInputs.getResult());
    }
}