package utils;


import org.apache.commons.lang3.RandomStringUtils;

public class MockDataGenerator {

//    public MockDataGenerator () {};

    public static String emailGenerator () {
        return RandomStringUtils.randomAlphanumeric(20) + "@imaginarymail.com";
    }
}
