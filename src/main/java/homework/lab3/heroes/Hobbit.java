package homework.lab3.heroes;

import homework.lab3.Hero;

public class Hobbit extends Hero {
    public Hobbit(String heroName) {
        setName(heroName);
        setHp(3);
        setPower(0);
    }

    @Override
    public String kick(Hero enemy) {
        return this.cry() + battleStat(enemy);
    }

    private String cry() {
        return this.getName() + ": I'm crying!\n";
    }
}
