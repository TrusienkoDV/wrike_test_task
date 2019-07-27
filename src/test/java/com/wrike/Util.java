package com.wrike;

import org.apache.commons.lang3.RandomStringUtils;

public class Util {
    private static final int NUMBER_OF_LETTERS = 10;

    public static String generateRandomString() {
        return RandomStringUtils.random(NUMBER_OF_LETTERS, true, true);
    }
}
