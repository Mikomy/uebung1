package org.lecture;

import lombok.extern.slf4j.Slf4j;
import org.lecture.binCalculator.BinCalculate;
import org.lecture.binCalculator.BinCalculateFactory;
import org.lecture.convert.NumberSystemConverter;
import org.lecture.convert.Convert;
import org.lecture.convert.ConvertFactory;
import org.lecture.dezCalculate.DezimalCalculate;
import org.lecture.dezCalculate.DezimalCalculateFactory;

import java.util.Scanner;

/**
 * The MenuNumberSystemConverter class represents a menu-driven number system converter.
 * It allows users to input numbers in various number systems, perform arithmetic operations, and convert between number systems.
 * The menu-driven interface guides the user through the conversion process.
 */
@Slf4j
public class MenuNumberSystemConverter {
    private Scanner scanner = new Scanner(System.in);

    private CalculatorRAM calculatorRAM;
        //CalculatorRAM instance for storing and managing input data.

    private BinCalculate binaryBinCalculate = BinCalculateFactory.createInstance();
        //Binary number calculator instance.

    private DezimalCalculate dezimalCalculate = DezimalCalculateFactory.createInstance();
        //Decimal number calculator instance.

    private NumberSystemConverter convert = ConvertFactory.createInstance();
        //Number system converter instance.

    private SaveResult saveResult = new SaveResult();
    private String result = null;
    public MenuNumberSystemConverter(CalculatorRAM calculatorRAM) {
        this.calculatorRAM = calculatorRAM;
        this.scanner = new Scanner(System.in);
    }
    public void runMenu() {
/*
        String menu = """
                     
                     ------------              -----------             -----------              ----------
                    |  Press 1  |             |  Press 2  |           |  Press 3  |            |  Press 9 |
                    |    for    |             |    for    |           |    for    |            |    for   |
                     ------------              ------------            -----------               ----------
                    Enter  - number              Select                  Enter           ==      result
                  a Number   system             Operation                3.Part
                """;
  */
        String menu = """
                 -----------------------------------------------------
                 \uD83D\uDCAC  Press 1  |  Enter a number in a specific system
                 \uD83D\uDCAC  Press 2  |  Choose an operation (Convert, Addition, Subtraction, etc.)
                 \uD83D\uDCAC  Press 3  |  Enter additional details
                 \uD83D\uDCAC  Press 9  |  Calculate or convert
                 \uD83D\uDCAC  Press 0  |  EXIT
                 -----------------------------------------------------
                Enter your choice: """;
        calculatorRAM.createInput0(calculatorRAM);
        EnterInput enterInput = new EnterInput(calculatorRAM, System.in);
        boolean loop = true;
        System.out.println("\n---\nWelcom to the Number Converter!\n---\n");
        while (loop) {
            System.out.println(menu);
            calculatorRAM.printCalculatorRAM();
            String input = scanner.nextLine();

            switch (input) {
                case "1" -> {
                    log.debug("Enter a number");
                    enterInput.enterNumber();
                }
                case "2" -> {
                    log.debug("Select an operation");
                    enterInput.enterOperation();
                }
                case "3" -> {
                    log.debug("Enter the 3.part");
                    enterInput.enter3PArt();
                }
                case "9" -> {
                    log.debug("binaryCalculate");
                    calculate(calculatorRAM);
                }
                case "0" -> loop = false;
                default -> System.out.println("invalid input " + input);
            }
        }

    }

    /**
     * Performs the calculation based on user inputs and saves the result.
     *
     * @param calculatorRAM The CalculatorRAM instance.
     */
    private void calculate(CalculatorRAM calculatorRAM) {
        String numberSystem1 = calculatorRAM.getInputs().get(0).getNumberSystem1();
        String numberSystem2 = calculatorRAM.getInputs().get(0).getNumberSystem2();
        String operation = calculatorRAM.getInputs().get(0).getOperator();
        if (numberSystem1 != null && operation != null && numberSystem2 != null) {
            if (numberSystem1.equalsIgnoreCase("BINARY") && numberSystem2.equalsIgnoreCase("BINARY")) {
                result = binaryBinCalculate.binaryCalculate(calculatorRAM);
                saveResult.saveResult(calculatorRAM, result);
            }
            else if (numberSystem1.equalsIgnoreCase("DECIMAL") && numberSystem2.equalsIgnoreCase("DECIMAL")) {
                result = dezimalCalculate.dezimalCalculate(calculatorRAM);
                saveResult.saveResult(calculatorRAM, result);
            }
            else if (!numberSystem1.equals(numberSystem2) && operation.equalsIgnoreCase("CONVERT")) {
                result = convert.convert(calculatorRAM);
                saveResult.saveResult(calculatorRAM, result);
            }else {
                System.out.println("\n---[INFO]---\nIf the number system are different, only the convert operation will be working\n---\n");
            }
        }else {
            System.out.println("\n---[INFO]---\nResult expected only after filling in the subfields\n---\n");
        }
    }

}
