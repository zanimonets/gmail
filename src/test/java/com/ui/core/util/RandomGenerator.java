package com.ui.core.util;

import java.security.SecureRandom;

public class RandomGenerator {

    private static final String AB = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
    private static final int DEFAULT_LENGTH = 5;
    private static SecureRandom rnd = new SecureRandom();

    private RandomGenerator() {
    }

    public static synchronized String randomString() {
        return randomString(DEFAULT_LENGTH);
    }

    public static synchronized String randomString(int length) {
        return generate(length);
    }

    private static String generate(int length) {
        StringBuilder sb = new StringBuilder(length);

        for (int i = 0; i < length; i++) {
            sb.append(AB.charAt(rnd.nextInt(AB.length())));
        }
        return sb.toString();
    }
}
