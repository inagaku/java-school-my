package homework.my_spring;

import homework.my_spring.annotations_lab.InjectRandomInt;
import homework.utils.RandomUtil;
import lombok.Getter;
import lombok.SneakyThrows;

import java.lang.reflect.Field;

public class ObjectFactory {
    @Getter
    public static ObjectFactory instance = new ObjectFactory();
    private Config config = new JavaConfig();

    private int testPar;

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
