package homework.lab3;

import homework.my_spring.annotations_lab.InjectRandomInt;
import lombok.Data;

import java.util.Random;

@Data
abstract public class Hero {
    private String name;

    @InjectRandomInt(fromValue = 1, toValue = 10)
    private int hp;
    @InjectRandomInt(fromValue = 10, toValue = 20)
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
