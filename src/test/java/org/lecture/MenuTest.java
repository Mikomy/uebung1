package org.lecture;

import org.junit.jupiter.api.Test;
import org.lecture.binCalculator.BinCalculate;
import org.lecture.convert.NumberSystemConverter;
import org.lecture.binCalculator.BinaryCalculate;
import org.lecture.convert.Convert;
import org.lecture.dezCalculate.DezimalCalculate;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

public class MenuTest {
    ByteArrayOutputStream bo = new ByteArrayOutputStream();

    @Test
    void caseCenarioTest() {
         Scanner scanner = new Scanner(System.in);
         CalculatorRAM calculatorRAM = new CalculatorRAM();
         BinCalculate binaryBinCalculate = new BinaryCalculate();
         DezimalCalculate dezimalCalculate = new DezimalCalculate();
         NumberSystemConverter convert = new Convert();
         SaveResult saveResult = new SaveResult();
        MenuNumberSystemConverter menu = new MenuNumberSystemConverter(calculatorRAM);
        InputStream originalInput = System.in;
        String input = "1\n2\n11\n2\n1\n3\n1\n2\n11\n9";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        menu.runMenu();
        String result = calculatorRAM.getInputs().get(0).getResult();
        assertEquals("110",result);
        System.setIn(originalInput);
    }


    /*
    Reader.ReaderBuilder newReaderBuilder = new Reader.ReaderBuilder();
        Reader reader5 = newReaderBuilder.readersName("Alex")
                .build();
        readersBook.add(reader5);
        InputStream originalInput = System.in;
        ByteArrayInputStream testInput = new ByteArrayInputStream("Alex\nBOULEVARD,sport\n".getBytes());
        System.setIn(testInput);
        newsService = new NewsService(newsBook, readersBook);
        newsService.addCategoryForReader();
        List<Category> subscribedCategories = reader5.getSubscribedCategoris();
        assertEquals(2, subscribedCategories.size());
        assertTrue(subscribedCategories.contains(Category.BOULEVARD));
        assertTrue(subscribedCategories.contains(Category.SPORT));
        System.setIn(originalInput);
     */
}
