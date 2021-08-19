package homework.lab3;

import com.github.javafaker.Faker;
import homework.lab3.heroes.*;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Random;

import static homework.lab3.random.utils.Random.randomName;

enum HEROES {
    Hobbit {
        public Hobbit getHero() {
            String heroName = randomName();
            return new Hobbit(heroName);
        }
    },
    Elf {
        public Elf getHero() {
            String heroName = randomName();
            return new Elf(heroName);
        }
    },
    King {
        public King getHero() {
            String heroName = randomName();
            return new King(heroName);
        }
    },
    Knight {
        public Knight getHero() {
            String heroName = randomName();
            return new Knight(heroName);
        }
    }
}

public class HeroFactory {
    public Hero createHero() throws InvocationTargetException, NoSuchMethodException, IllegalAccessException {
        int randHero = (new Random()).nextInt(HEROES.values().length);
        Faker faker = new Faker();
        String heroName = faker.gameOfThrones().character();

        try {
            HEROES heroType = HEROES.values()[randHero];
            Method method = heroType.getClass().getMethod("getHero");

            System.out.println(heroType.name() + " created");
            return (Hero) method.invoke(heroType);
        } catch (Exception e) {
            throw e;
        }
    }
}
