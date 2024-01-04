package org.lecture.convert;

public class ConvertFactory {
    /**
     * Creates and returns an instance of a NumberSystemConverter implementation.
     *
     * @return An instance of a class implementing the NumberSystemConverter interface.
     */
    public static NumberSystemConverter createInstance() {
        return new Convert();
    }
}
