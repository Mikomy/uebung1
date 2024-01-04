package org.lecture;

public class SaveResult {
    private CalculatorRAM calculatorRAM;

    public SaveResult() {
    }

    protected void saveResult(CalculatorRAM calculatorRAM, String result) {
        Inputs existingInput = calculatorRAM.getInputs().get(0);
        Inputs.InputsBuilder inputBuilder = new Inputs.InputsBuilder();

        //Copy the existing values from the ID=0
        inputBuilder.num1(existingInput.getNum1());
        inputBuilder.num2(existingInput.getNum2());
        inputBuilder.operator(existingInput.getOperator());
        inputBuilder.numberSystem1(existingInput.getNumberSystem1());
        inputBuilder.numberSystem2(existingInput.getNumberSystem2());
        inputBuilder.result(result);
        Inputs updatedInputs = inputBuilder.build();

        //Replace the existing Inputs with the updated
        calculatorRAM.set(0, updatedInputs);
    }
}
