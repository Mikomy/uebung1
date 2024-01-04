package org.lecture.dezCalculate;

import org.lecture.CalculatorRAM;
import org.lecture.dezCalculate.DezCalculate;
import org.lecture.SaveResult;

public class DezimalCalculate implements DezCalculate {
    private final SaveResult saveResult = new SaveResult();

    @Override
    public String dezimalCalculate(CalculatorRAM calculatorRAM) {
        String operator = calculatorRAM.getInputs().get(0).getOperator();
        int num1 = Integer.parseInt(calculatorRAM.getInputs().get(0).getNum1());
        int num2 = Integer.parseInt(calculatorRAM.getInputs().get(0).getNum2());
        int result = 0;
        if (operator != null) {
            switch (operator) {
                case "ADDITION ( + )":
                    result = num1 + num2;
                    break;
                case "SUBTRACTION ( - )":
                    result = num1 - num2;
                    break;
                case "MULTIPLICATION ( * )":
                    result = num1 * num2;
                    break;
                case "DIVISION ( / )":
                    result = num1 / num2;
                    break;
                default:
                    break;
            }
            if (result != 0) {
                return String.valueOf(result);
            }
        } else {
            System.out.println("please first select the operator");
        }
        return null;
    }
}
