package homework.my_spring_old;

import homework.lab3.Hero;
import homework.my_spring_old.annotations_lab.InjectByType;
import lombok.Getter;
import lombok.SneakyThrows;

import java.lang.reflect.Field;

public class RobotFactory {

    @Getter
    private static RobotFactory instance = new RobotFactory();
    
    @SneakyThrows
    public IRobot createRobot(Class<IRobot> iRobotClass) {
        IRobot iRobot = iRobotClass.getDeclaredConstructor().newInstance();

        Field[] fields = iRobot.getClass().getDeclaredFields();

        for (Field field : fields) {
            if (field.isAnnotationPresent(InjectByType.class)) {
                InjectByType annotation = field.getAnnotation(InjectByType.class);
                field.set(iRobot, field.getClass().getDeclaredConstructor().newInstance());
            }
        }

        return iRobot;
    }

    public static void main(String[] args) {
        IRobot robot = RobotFactory.instance.createRobot(IRobot.class);
        Hero hero = ObjectFactory.instance.createObject(Hero.class);

        System.out.println(hero.toString());
        robot.cleanRoom();
    }
}
