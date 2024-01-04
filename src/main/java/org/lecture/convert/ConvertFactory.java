package org.lecture.convert;

public class ConvertFactory {

    public static NumberSystemConverter createInstance() {
        return new Convert();
    }
}
