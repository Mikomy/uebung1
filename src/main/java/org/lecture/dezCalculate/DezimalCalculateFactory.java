package org.lecture.dezCalculate;
/**
 * The DezimalCalculateFactory class is responsible for creating instances of the DezimalCalculate interface.
 * It provides a static method to create a new instance of a class implementing the DezimalCalculate interface.
 */
public class DezimalCalculateFactory {
    /**
     * Creates and returns a new instance of a class implementing the DezimalCalculate interface.
     *
     * @return A new instance of a class implementing the DezimalCalculate interface.
     */
    public static DezimalCalculate createInstance() {return new DezimalCalculate();
    }
}
