package org.lecture.binCalculator;

import org.lecture.CalculatorRAM;
/**
 * The BinCalculate interface defines the contract for classes that perform binary calculations.
 * Classes implementing this interface should provide the logic for binary calculations based on the provided CalculatorRAM.
 */
public interface BinCalculate {
     /**
      * Performs binary calculation based on the given CalculatorRAM.
      *
      * @param calculatorRAM The CalculatorRAM containing input values and the operation to be performed.
      * @return The result of the binary calculation.
      */
     String binaryCalculate(CalculatorRAM calculatorRAM);

}
