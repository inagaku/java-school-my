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
            return new Hobbit(randomName());
        }
    },
    Elf {
        public Elf getHero() {
            return new Elf(randomName());
        }
    },
    King {
        public King getHero() {
            return new King(randomName());
        }
    },
    Knight {
        public Knight getHero() {
            return new Knight(randomName());
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
