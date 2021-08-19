package homework.lab3.heroes;

import homework.lab3.Hero;

import java.util.Random;

public class King extends Hero {
    public King(String heroName) {
        setName(heroName);
        setHp(new Random().nextInt(11) + 5);
        setPower(new Random().nextInt(11) + 5);
    }
}
