package org.lecture.binCalculator;

public class BinCalculateFactory {

    /**
     * Creates and returns an instance of BinCalculate.
     *
     * @return A new instance of BinCalculate.
     */
    public static BinCalculate createInstance() {
        return new BinaryCalculate();
    }
}
