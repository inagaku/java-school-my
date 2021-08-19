package homework.lab3.heroes;

import homework.lab3.Hero;

import java.util.Random;

public class Knight extends Hero {
    public Knight(String heroName) {
        setName(heroName);
        setHp(new Random().nextInt(11) + 2);
        setPower(new Random().nextInt(11) + 2);
    }
}
