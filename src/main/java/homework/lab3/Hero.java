package homework.lab3;

import lombok.Data;

import java.util.Random;

@Data
abstract public class Hero {
    private String name;
    private int hp;
    private int power;

    public String kick(Hero enemy) {
        enemy.setHp(enemy.getHp() - (new Random().nextInt(this.power) + 1));
        return battleStat(enemy);
    }

    protected String battleStat(Hero enemy) {
        StringBuilder stringBuilder = new StringBuilder();
        return stringBuilder.append(this.getName()).append(": ").append(this.getHp()).append("HP - ")
                .append(enemy.getName()).append(": ").append(enemy.getHp()).append("HP").toString();
    }
}
