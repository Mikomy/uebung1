package org.lecture.convert;

import org.lecture.CalculatorRAM;

public interface NumberSystemConverter {
    /**
     * Performs conversion between different number systems based on the given CalculatorRAM.
     *
     * @param calculatorRAM The CalculatorRAM containing input values and number systems for conversion.
     * @return The result of the conversion between number systems.
     */
    String convert(CalculatorRAM calculatorRAM);

}
