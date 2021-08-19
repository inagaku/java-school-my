package homework.lab3;

import com.github.javafaker.Faker;
import homework.lab3.heroes.*;

import java.util.Random;

public class Start {
    public static void main(String[] args) {
        Faker faker = new Faker();
        String heroName = faker.gameOfThrones().character();

    }
}
