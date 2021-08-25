package homework.my_spring;

import homework.my_spring.annotations_lab.InjectRandomInt;
import homework.utils.RandomUtil;
import lombok.Getter;
import lombok.SneakyThrows;

import java.lang.reflect.Field;

/**
 * @author Evgeny Borisov
 */
public class ObjectFactory {
    @Getter
    private static ObjectFactory instance = new ObjectFactory();
    private Config config = new JavaConfig();

    @SneakyThrows
    public <T> T createObject(Class<T> type) {
        if (type.isInterface()) {
            type = config.getImplClass(type);
        }

        T t = type.getDeclaredConstructor().newInstance();

        Field[] fields = t.getClass().getDeclaredFields();

        for (Field field : fields) {
            if (field.isAnnotationPresent(InjectRandomInt.class)) {
                InjectRandomInt annotation = field.getAnnotation(InjectRandomInt.class);
                field.setInt(t, RandomUtil.between(annotation.fromValue(), annotation.toValue()));
            }
        }


        return t;
    }




}
