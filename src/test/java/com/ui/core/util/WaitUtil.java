package com.ui.core.util;

public class WaitUtil {

    public static void sleep(long milliseconds) {
        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException e) {
            throw new RuntimeException("An exception occurred while sleeping.", e);
        }
    }
}
