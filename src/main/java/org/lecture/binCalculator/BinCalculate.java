package org.lecture.binCalculator;

import org.lecture.CalculatorRAM;
/**
 * Interface for binary calculation operations in a calculator.
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
