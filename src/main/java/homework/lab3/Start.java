package homework.lab3;

import com.github.javafaker.Faker;
import homework.lab3.heroes.*;

public class Start {
    public static void main(String[] args) {
        Faker faker = new Faker();
        String heroName = faker.gameOfThrones().character();
        for (int i = 0; i < 20; ++i) {
            System.out.println(faker.gameOfThrones().character());
        }
    }
}
