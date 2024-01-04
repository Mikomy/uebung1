package org.lecture.binCalculator;

import org.lecture.binCalculator.BinCalculate;
import org.lecture.CalculatorRAM;

import java.util.ArrayList;
import java.util.List;

public class BinaryCalculate implements BinCalculate {


    private CalculatorRAM calculatorRAM;

    //public BinaryCalculate(CalculatorRAM calculatorRAM) {this.calculatorRAM = calculatorRAM;}


    String result = null;

    @Override
    public String binaryCalculate(CalculatorRAM calculatorRAM) {
        String operator = calculatorRAM.getInputs().get(0).getOperator();
        String binNum1 = calculatorRAM.getInputs().get(0).getNum1();
        String binNum2 = calculatorRAM.getInputs().get(0).getNum2();

        if (operator != null) {
            switch (operator) {
                case "ADDITION ( + )":
                    result = calculatAddition(binNum1, binNum2);
                    break;
                case "SUBTRACTION ( - )":
                    result = calculatSubtraction(binNum1, binNum2);
                    break;
                case "MULTIPLICATION ( * )":
                    result = calculatMultiplication(binNum1, binNum2);
                    break;
                case "DIVISION ( / )":
                    result = calculatDivision(binNum1, binNum2);
                    break;
                default:
                    break;
            }
            if (result != null) {
                return result;
            }
        } else {
            System.out.println("please first select the operator");
        }
        return null;
    }




    protected String calculatAddition(String binNum1, String binNum2) {
        int binNum1Length = binNum1.length();
        int binNum2Length = binNum2.length();

        while (binNum1Length < binNum2Length) {
            binNum1 = "0" + binNum1;
            binNum1Length ++;
        }
        while (binNum1Length > binNum2Length) {
            binNum2 = "0" + binNum2;
            binNum2Length ++;
        }
        StringBuilder sbResult = new StringBuilder();
        int carry = 0;
        for (int i = binNum1Length-1; i >= 0; i--) {
            char char1 = binNum1.charAt(i);
            char char2 = binNum2.charAt(i);

            int bit1 = (char1 == '1') ? 1 : 0;
            int bit2 = (char2 == '1') ? 1 : 0;

            int sum = bit1 + bit2 + carry;
            char charResult = (sum % 2 == 0) ? '0' : '1';

            /*
            sbResult.insert(0, ... ): This part inserts the character calculated in the previous step at the beginning
            (index 0) of the result string using the insert method. It effectively adds the binary digit to the result
            string from right to left, maintaining the proper order.
             */
            sbResult.insert(0, charResult);
            carry = sum / 2;
        }
        if (carry > 0) {
            sbResult.insert(0, '1');
        }

        return sbResult.toString();
    }

    protected String calculatSubtraction(String binNum1, String binNum2) {
        int binNum1Length = binNum1.length();
        int binNum2Length = binNum2.length();

        while (binNum1Length < binNum2Length) {
            binNum1 = "0" + binNum1;
            binNum1Length ++;
        }
        while (binNum1Length > binNum2Length) {
            binNum2 = "0" + binNum2;
            binNum2Length ++;
        }
        StringBuilder sbResult = new StringBuilder();
        int carry = 0;
        for (int i = binNum1Length-1; i >= 0; i--) {
            char char1 = binNum1.charAt(i);
            char char2 = binNum2.charAt(i);

            int bit1 = (char1 == '1') ? 1 : 0;
            int bit2 = (char2 == '1') ? 1 : 0;

            int sum = bit1 - bit2 - carry;
            char charResult = (sum  == 0) ? '0' : '1';

            /*
            sbResult.insert(0, ... ): This part inserts the character calculated in the previous step at the beginning
            (index 0) of the result string using the insert method. It effectively adds the binary digit to the result
            string from right to left, maintaining the proper order.
             */
            sbResult.insert(0, charResult);
            carry = (sum < 0) ? 1 : 0;
        }


        return sbResult.toString();
    }

    protected String calculatMultiplication(String binNum1, String binNum2) {
        String resultMultiplication = "0";
        List<String> partialResult = new ArrayList<>();
        partialResult.add(0,"0");
        partialResult.add(1,"0");

        for (int i = 0; i <= (binNum2.length()-1); i++) {
            StringBuilder sbPartialResult = new StringBuilder();
            char char2 = binNum2.charAt(i);
            for (int j = (binNum1.length()-1); j >= 0; j--) {
                if ((i <= (binNum2.length()-2)) && (j <= (binNum2.length()-2) )) {
                    sbPartialResult.append( '0');
                }

                char char1 = binNum1.charAt(j);

                int bit1 = (char1 == '1') ? 1 : 0;
                int bit2 = (char2 == '1') ? 1 : 0;

                int sum = bit1 * bit2;
                char charResult = (sum == 0) ? '0' : '1';


                sbPartialResult.insert(0, charResult);
            }

            partialResult.add(0, sbPartialResult.toString());
            resultMultiplication = calculatAddition(partialResult.get(0), resultMultiplication);
        }
        return resultMultiplication;
    }

    protected String calculatDivision(String binNum1, String binNum2) {

        StringBuilder sbPartialResult = new StringBuilder();
        StringBuilder sbResult = new StringBuilder();
        int num2 = Integer.parseInt(binNum2);

        for (int i = 0; i <= (binNum1.length()-1); i++) {
            char nextCharNum2 = binNum1.charAt(i);
            sbPartialResult.append(nextCharNum2);

            int partialNum1 = Integer.parseInt(String.valueOf(sbPartialResult));
                if(partialNum1 >= num2) {
                    sbPartialResult= new StringBuilder(calculatSubtraction(String.valueOf(sbPartialResult), binNum2));
                    sbResult.append("1");
                } else {
                    sbResult.append("0");
                }
            }
        return String.valueOf(sbResult);
    }
}
