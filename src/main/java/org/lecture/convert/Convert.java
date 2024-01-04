package org.lecture.convert;

import org.lecture.CalculatorRAM;
import org.lecture.convert.NumberSystemConverter;
import org.lecture.SaveResult;

public class Convert implements NumberSystemConverter {
    String result = null;
    private final SaveResult saveResult = new SaveResult();

    /**
     * Performs number system conversion based on the given CalculatorRAM.
     *
     * @param calculatorRAM The CalculatorRAM containing input values and the number systems to be converted.
     * @return The result of the number system conversion.
     */
    @Override
    public String convert(CalculatorRAM calculatorRAM) {
        String operator = calculatorRAM.getInputs().get(0).getOperator();
        String num1 = calculatorRAM.getInputs().get(0).getNum1();
        String num1System = calculatorRAM.getInputs().get(0).getNumberSystem1();


        if (num1System != null) {
            switch (num1System) {
                case "DECIMAL" -> {
                    convertDecimalTo(calculatorRAM);
                }
                case "BINARY" -> {
                    convertBinaryTo(calculatorRAM);
                }
                case "HEXADECIMAL" -> {
                    convertHexadecimalTo(calculatorRAM);
                }
                case "OCTAL" -> {
                    convertOctalTo(calculatorRAM);
                }
                default -> {

                }
            }
            if (result != null) {
                return result;
            }
        } else {
            System.out.println("\n---\nplease first select the operator\n---\n");
        }
        return null;
    }


    private void convertHexadecimalTo(CalculatorRAM calculatorRAM) {
        String num1 = calculatorRAM.getInputs().get(0).getNum1();
        String num2System = calculatorRAM.getInputs().get(0).getNumberSystem2();

        switch (num2System) {
            case "DECIMAL" -> {
                result = convertToDecimal(num1, 8);
            }
            case "BINARY" -> {
                String num1Decimal = convertToDecimal(num1, 16);
                result = convertDecimalToGivenSystem(num1Decimal, 2);
            }
            case "OCTAL" -> {
                String num1Decimal = convertToDecimal(num1, 16);
                result = convertDecimalToGivenSystem(num1Decimal, 8);
            }
            default -> {

            }
        }
    }

    private void convertOctalTo(CalculatorRAM calculatorRAM) {
        String num1 = calculatorRAM.getInputs().get(0).getNum1();
        String num2System = calculatorRAM.getInputs().get(0).getNumberSystem2();

        switch (num2System) {
            case "DECIMAL" -> {
                result = convertToDecimal(num1, 8);
            }
            case "BINARY" -> {
                String num1Decimal = convertToDecimal(num1, 8);
                result = convertDecimalToGivenSystem(num1Decimal, 2);
            }
            case "HEXADECIMAL" -> {
                String num1Decimal = convertToDecimal(num1, 8);
                result = convertDecimalToGivenSystem(num1Decimal, 16);
            }
            default -> {

            }
        }
    }

    protected void convertBinaryTo(CalculatorRAM calculatorRAM) {
        String num1 = calculatorRAM.getInputs().get(0).getNum1();
        String num2System = calculatorRAM.getInputs().get(0).getNumberSystem2();

        switch (num2System) {
            case "DECIMAL" -> {
                result = convertToDecimal(num1, 2);
            }
            case "HEXADECIMAL" -> {
                String num1Decimal = convertToDecimal(num1, 2);
                result = convertDecimalToGivenSystem(num1Decimal, 16);
            }
            case "OCTAL" -> {
                String num1Decimal = convertToDecimal(num1, 2);
                result = convertDecimalToGivenSystem(num1Decimal, 8);
            }
            default -> {

            }
        }
    }

    private void convertDecimalTo(CalculatorRAM calculatorRAM) {
        String num1 = calculatorRAM.getInputs().get(0).getNum1();
        String num2System = calculatorRAM.getInputs().get(0).getNumberSystem2();

        switch (num2System) {
            case "BINARY" -> {
                result = convertDecimalToGivenSystem(num1, 2);
            }
            case "HEXADECIMAL" -> {
                result = convertDecimalToGivenSystem(num1, 16);
            }
            case "OCTAL" -> {
                result = convertDecimalToGivenSystem(num1, 8);
            }
            default -> {

            }
        }
    }

    /**
     * Converts a number from a given number system ( binary, octal) to its decimal equivalent.
     *
     * @param num1         The number in the specified number system.
     * @param numberSystem The base of the number system ( 2 for binary, 8 for octal).
     * @return The decimal equivalent of the given number in the specified number system.
     */
    protected String convertToDecimal(String num1, int numberSystem) {
        int sum = 0;
        int powerOf = 1;

        for (int i = (num1.length() - 1); i >= 0; i--) {
            String digit = String.valueOf(num1.charAt(i));
            if (numberSystem == 16) {
                digit = hexadecimalWriteFormToDecimal(digit);
            }
            int digitValue = Integer.parseInt(digit);

            sum += digitValue * powerOf;
            powerOf *= numberSystem;  // Update the power of the number for the next digit
        }
        return String.valueOf(sum);
    }

    /**
     * Converts a decimal number to the specified number system (binary, octal, etc.).
     *
     * @param num1         The decimal number to be converted.
     * @param numberSystem The base of the number system to convert the decimal number into (2 for binary, 8 for octal).
     * @return The string representation of the given decimal number in the specified number system.
     */
    protected String convertDecimalToGivenSystem(String num1, int numberSystem) {
        StringBuilder sbresult = new StringBuilder();
        int num1Int = Integer.parseInt(num1);
        do {
            String partialResult = String.valueOf((num1Int % numberSystem));
            num1Int /= numberSystem;
            if (numberSystem == 16) {
                partialResult = getHexadecimal(partialResult);
            }
            sbresult.insert(0, partialResult);
        } while (num1Int != 0);
        return sbresult.toString();
    }

    /**
     * Change the partial number of input to hexadecimal character
     */
    private String getHexadecimal(String hexadecimalChar) {
        if (hexadecimalChar.equals("10")) {
            hexadecimalChar = "A";
        }
        if (hexadecimalChar.equals("11")) {
            hexadecimalChar = "B";
        }
        if (hexadecimalChar.equals("12")) {
            hexadecimalChar = "C";
        }
        if (hexadecimalChar.equals("13")) {
            hexadecimalChar = "D";
        }
        if (hexadecimalChar.equals("14")) {
            hexadecimalChar = "E";
        }
        if (hexadecimalChar.equals("15")) {
            hexadecimalChar = "F";
        }
        return hexadecimalChar;
    }

    /**
     * Change the partial hexadecimal number of the input to  decimal number
     */
    private String hexadecimalWriteFormToDecimal(String hexadecimalDigit) {
        if (hexadecimalDigit.equals("A")) {
            return "10";
        }
        if (hexadecimalDigit.equals("B")) {
            return "11";
        }
        if (hexadecimalDigit.equals("C")) {
            return "12";
        }
        if (hexadecimalDigit.equals("D")) {
            return "13";
        }
        if (hexadecimalDigit.equals("E")) {
            return "14";
        }
        if (hexadecimalDigit.equals("F")) {
            return "15";
        }
        return hexadecimalDigit;
    }
}
