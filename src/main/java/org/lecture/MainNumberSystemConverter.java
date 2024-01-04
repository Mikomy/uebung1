package org.lecture;

public class MainNumberSystemConverter {

    private static final CalculatorRAM calculatorRAM = new CalculatorRAM();

    public static void main(String[] args) {
      MenuNumberSystemConverter menu = new MenuNumberSystemConverter(calculatorRAM);
      menu.runMenu();
    }


   
}
