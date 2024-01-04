package org.lecture;


import lombok.Getter;
import lombok.Setter;

import java.util.Map;
import java.util.TreeMap;

@Getter
@Setter
public class CalculatorRAM {
    private final Map<Integer, Inputs> inputMap = new TreeMap<>();

    public void add(Integer id, Inputs inputs) {
        this.inputMap.put(id, inputs);
    }

    public void remove(Integer id) {
        this.inputMap.remove(id);
    }

    public Map<Integer, Inputs> getInputs() {
        return this.inputMap;
    }

    public void createInput0(CalculatorRAM calculatorRAM) {
        Inputs.InputsBuilder inputBuilder = new Inputs.InputsBuilder();
        Inputs inputs = inputBuilder.build();
        calculatorRAM.add(0, inputs);
    }

    public void set(int i, Inputs updatedInputs) {
        if (inputMap.containsKey(i)) {
            inputMap.put(i, updatedInputs);
        } else {
            System.out.println("No Inputs objct found ");
        }

    }

    public void printCalculatorRAM() {
        for (Map.Entry<Integer, Inputs> entry : this.inputMap.entrySet()) {
            int id = entry.getKey();
            String num1 = entry.getValue().getNum1();
            String numSystem1 = entry.getValue().getNumberSystem1();
            String operator = entry.getValue().getOperator();
            String num2 = entry.getValue().getNum2();
            String numSystem2 = entry.getValue().getNumberSystem2();
            String result = entry.getValue().getResult();
            if (operator == "CONVERT") {
                System.out.printf("   %-10s %-17s %-20s  %-18s ==     %-5s", num1, numSystem1, operator, numSystem2, result + "\n");
            } else {
                System.out.printf("   %-10s %-17s %-20s %-8s %-13s ==     %-5s", num1, numSystem1, operator, num2, numSystem2, result + "\n");
            }
        }
    }

}
