package homework.lab3.heroes;

import homework.lab3.Hero;

public class Elf extends Hero {
    public Elf(String heroName) {
        setName(heroName);
        setHp(10);
        setPower(10);
    }

    @Override
    public String kick(Hero enemy) {
        String battleInfo = "";
        if (enemy.getPower() < this.getPower()) {
            enemy.setHp(0);
            battleInfo = this.getName() + "killed " + enemy.getName() + "\n";
        } else {
            enemy.setPower(enemy.getPower() - 1);
            battleInfo = enemy.getName() + "'s power: " + enemy.getPower() + "\n";
        }

        return battleInfo + battleStat(enemy);
    }
}
