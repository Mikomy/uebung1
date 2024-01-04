package org.lecture;

import java.util.Scanner;

public class EnterInput {
    private CalculatorRAM calculatorRAM;
    private static Scanner scanner = new Scanner(System.in);

    public EnterInput(CalculatorRAM calculatorRAM) {
        this.calculatorRAM = calculatorRAM;
    }

    public void enterNumber() {

        //System.out.println("Supported number systems:\n 1 Decimal,\n 2 Binary,\n 3 Hexadecimal,\n 4 Octal\n");
        saveNumber();
    }

    public void enterOperation() {
        saveOperators();
    }

    public void enter3PArt() {
        String operator = calculatorRAM.getInputs().get(0).getOperator();
        if (operator != null) {
            switch (operator) {
                case "ADDITION ( + )":
                case "SUBTRACTION ( - )":
                case "MULTIPLICATION ( * )":
                case "DIVISION ( / )":
                    enterNum2();
                    break;
                case "CONVERT":
                    selectConvertResult();
                    break;
                default:
                    break;
            }
        } else {
            System.out.println("\n---[INFO]---\nPlease first select the operator");
            return;
        }
    }

    private void selectConvertResult() {
        String convertResultSystem = null;
        while (convertResultSystem == null) {
            convertResultSystem = validnumberSystem();
            if (convertResultSystem == null) {
                System.out.println("\n---[INFO]---\nInvalid number system. Please select a valid option.");
            }
        }
        addConvertResultSystemCalculatorRAM(convertResultSystem);

    }

    private void addConvertResultSystemCalculatorRAM(String convertResultSystem) {
        Inputs existingInput = calculatorRAM.getInputs().get(0);
        Inputs.InputsBuilder inputBuilder = new Inputs.InputsBuilder();

        //Copy the existing values from the ID=0
        inputBuilder.num1(existingInput.getNum1());
        inputBuilder.num2(null);
        inputBuilder.operator(existingInput.getOperator());
        inputBuilder.numberSystem1(existingInput.getNumberSystem1());
        inputBuilder.numberSystem2(convertResultSystem);
        Inputs updatedInputs = inputBuilder.build();

        //Replace the existing Inputs with the updated
        calculatorRAM.set(0, updatedInputs);
    }

    private void enterNum2() {
        String numberSystem2 = null;
        String num2 = null;
        while (numberSystem2 == null) {
            numberSystem2 = validnumberSystem();
            if (numberSystem2 == null) {
                System.out.println("\n---[INFO]---\nInvalid number system. Please select a valid option.");
            }
        }
        while (num2 == null) {
            num2 = validNum(numberSystem2);
            if (num2 == null) {
                System.out.println("\n---[INFO]---\nInvalid input number. Please enter a valid number.");
            }
        }

        addNewNum2ToCalculatorRAM(num2, numberSystem2);

    }

    private void addNewNum2ToCalculatorRAM(String num2, String numberSystem2) {
        Inputs existingInput = calculatorRAM.getInputs().get(0);
        Inputs.InputsBuilder inputBuilder = new Inputs.InputsBuilder();

        //Copy the existing values from the ID=0
        inputBuilder.num1(existingInput.getNum1());
        inputBuilder.num2(num2);
        inputBuilder.operator(existingInput.getOperator());
        inputBuilder.numberSystem1(existingInput.getNumberSystem1());
        inputBuilder.numberSystem2(numberSystem2);
        Inputs updatedInputs = inputBuilder.build();

        //Replace the existing Inputs with the updated
        calculatorRAM.set(0, updatedInputs);
    }


    private void saveOperators() {
        String numberSystem1 = calculatorRAM.getInputs().get(0).getNumberSystem1();
        String operator = null;
        while (operator == null) {
            if ((numberSystem1 == "DECIMAL") || (numberSystem1 == "BINARY")) {
                operator = validOperator();
            } else {
                operator = onlyConvert();
            }
            if (operator == null) {
                System.out.println("\n---[INFO]---\nInvalid number system. Please select a valid option.");

            }
            if (operator == "CONVERT") {
                addNewNum2ToCalculatorRAM(null, null);
            }
        }
        addNewOperatorToCalculatorRAM(operator);
    }

    private static String onlyConvert() {
        System.out.println("\n---[INFO]---\nWith different number systems you can only convert\n---\n");
        System.out.println("Supported operators:\n 5 Convert \n");
        System.out.println("Enter the number of the Supported number system please");
        String numberSystem1 = scanner.nextLine();
        switch (numberSystem1) {
            case "5" -> {
                return "CONVERT";
            }
            default -> {
                return null;
            }
        }
    }

    private void addNewOperatorToCalculatorRAM(String operator) {
        Inputs existingInput = calculatorRAM.getInputs().get(0);
        Inputs.InputsBuilder inputBuilder = new Inputs.InputsBuilder();

        //Copy the existing values from the ID=0
        inputBuilder.num1(existingInput.getNum1());
        inputBuilder.num2(existingInput.getNum2());
        inputBuilder.operator(operator);
        inputBuilder.numberSystem1(existingInput.getNumberSystem1());
        inputBuilder.numberSystem2(existingInput.getNumberSystem2());
        Inputs updatedInputs = inputBuilder.build();

        //Replace the existing Inputs with the updated
        calculatorRAM.set(0, updatedInputs);
    }

    private static String validOperator() {
        System.out.println("Supported operators:\n 1 Addition ( + ),\n 2 Subtraction ( - ),\n 3 Multiplication ( * ),\n 4 Division ( / ),\n 5 Convert \n");
        System.out.println("Which operator would you like to use?");
        System.out.println("Enter the number of the Supported number system please");
        String numberSystem1 = scanner.nextLine();
        switch (numberSystem1) {
            case "1" -> {
                return "ADDITION ( + )";
            }
            case "2" -> {
                return "SUBTRACTION ( - )";
            }
            case "3" -> {
                return "MULTIPLICATION ( * )";
            }
            case "4" -> {
                return "DIVISION ( / )";
            }
            case "5" -> {

                return "CONVERT";
            }
            default -> {
                return null;
            }
        }
    }

    private void saveNumber() {
        String numberSystem1 = null;
        String num1 = null;
        while (numberSystem1 == null) {
            numberSystem1 = validnumberSystem();
            if (numberSystem1 == null) {
                System.out.println("Invalid number system. Please select a valid option.");
            }
        }
        while (num1 == null) {
            num1 = validNum(numberSystem1);
            if (num1 == null) {
                System.out.println("Invalid input number. Please enter a valid number.");
            }
        }

        addNewNum1ToCalculatorRAM(num1, numberSystem1);

    }

    private void addNewNum1ToCalculatorRAM(String num1, String numberSystem1) {
        Inputs existingInput = calculatorRAM.getInputs().get(0);
        Inputs.InputsBuilder inputBuilder = new Inputs.InputsBuilder();

        //Copy the existing values from the ID=0
        inputBuilder.num1(num1);
        inputBuilder.num2(existingInput.getNum2());
        inputBuilder.operator(existingInput.getOperator());
        inputBuilder.numberSystem1(numberSystem1);
        inputBuilder.numberSystem2(existingInput.getNumberSystem2());
        Inputs updatedInputs = inputBuilder.build();

        //Replace the existing Inputs with the updated
        calculatorRAM.set(0, updatedInputs);
    }

    private String validNum(String numberSystem1) {
        System.out.println("Enter a number you want to use");
        String num1 = scanner.nextLine();
        if (isValidNum1(num1, numberSystem1)) {
            System.out.println("Valid input number");
            return num1;
        } else {
            System.out.println("invalid input number");
            return null;
        }
    }

    private String validnumberSystem() {
        System.out.println("Which number system would you like to use?");
        System.out.println("Supported number systems:\n 1 Decimal,\n 2 Binary,\n 3 Hexadecimal,\n 4 Octal\n");
        System.out.println("Enter the number of the Supported number system please");
        String numberSystem1 = scanner.nextLine();
        switch (numberSystem1) {
            case "1" -> {
                return "DECIMAL";
            }
            case "2" -> {
                return "BINARY";
            }
            case "3" -> {
                return "HEXADECIMAL";
            }
            case "4" -> {
                return "OCTAL";
            }
            default -> {
                return null;
            }
        }
    }


    private boolean isValidNum1(String num1, String numberSystem1) {
        switch (numberSystem1) {
            case "DECIMAL" -> {
                return num1.matches("[0-9]+");
            }
            case "BINARY" -> {
                return num1.matches("[01]+");
            }
            case "HEXADECIMAL" -> {
                return num1.matches("[0-9A-Fa-f]+");
            }
            case "OCTAL" -> {
                return num1.matches("[0-7]+");
            }
            default -> {
                return false;
            }
        }
    }
}
