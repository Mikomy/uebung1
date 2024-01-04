package org.lecture;
/**
 * The Number System Converter allows users to perform arithmetic operations and conversions
 * on numbers in different systems (binary, decimal, hexadecimal, and octal). The user-friendly
 * menu interface facilitates entering numbers, selecting operations, and obtaining results.
 *
 * The program comprises several components:
 * - CalculatorRAM: Manages and stores input data for calculations.
 * - BinCalculate: Performs binary-specific calculations.
 * - DezimalCalculate: Performs decimal-specific calculations.
 * - NumberSystemConverter: Converts numbers between different number systems.
 * - MenuNumberSystemConverter: Main menu interface for user interaction.
 * - MainNumberSystemConverter: Entry point that initializes the application and launches the main menu.
 *
 * Informative messages guide user interactions.
 *
 * @author Miklos Komlosy
 * @version 1.0
 * @since 2024-01-04
 */
public class MainNumberSystemConverter {

    private static final CalculatorRAM calculatorRAM = new CalculatorRAM();

    public static void main(String[] args) {
      MenuNumberSystemConverter menu = new MenuNumberSystemConverter(calculatorRAM);
      menu.runMenu();
    }


   
}
