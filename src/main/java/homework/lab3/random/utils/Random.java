package homework.lab3.random.utils;

import com.github.javafaker.Faker;

public class Random {
    public static String randomName() {
        Faker faker = new Faker();
        return faker.gameOfThrones().character();
    }
}
