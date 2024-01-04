package org.lecture;

import lombok.Builder;
import lombok.Getter;
/**
 * The Inputs class represents the input values for calculations in various number systems.
 * It includes information such as the first number, its number system, the operator, the second number,
 * its number system, and the result of the calculation.
 */
@Getter
@Builder
public class Inputs {
    private final String num1;
    private final String numberSystem1;
    private final String operator;
    private final String num2;
    private final String numberSystem2;
    private final String result;

    public Inputs(String num1, String numberSystem1, String operator, String num2, String numberSystem2, String result) {
        this.num1 = num1;
        this.numberSystem1 = numberSystem1;
        this.operator = operator;
        this.num2 = num2;
        this.numberSystem2 = numberSystem2;
        this.result = result;
    }

    public String getNum1() {
        return num1;
    }

    public String getNumberSystem1() {
        return numberSystem1;
    }

    public String getOperator() {
        return operator;
    }

    public String getNum2() {
        return num2;
    }

    public String getNumberSystem2() {
        return numberSystem2;
    }

    public String getResult() {
        return result;
    }
}
