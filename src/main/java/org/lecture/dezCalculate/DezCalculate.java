package org.lecture.dezCalculate;

import org.lecture.CalculatorRAM;

public interface DezCalculate {

    /**
     * Performs a decimal calculation using the information stored in the CalculatorRAM.
     *
     * @param calculatorRAM The CalculatorRAM instance containing input values for the calculation.
     * @return The result of the decimal calculation as a String.
     */
    public String dezimalCalculate(CalculatorRAM calculatorRAM);
}
