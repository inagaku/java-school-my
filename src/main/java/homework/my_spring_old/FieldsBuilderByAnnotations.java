package homework.my_spring_old;

import homework.my_spring_old.annotations_lab.InjectByType;
import homework.my_spring_old.annotations_lab.InjectRandomInt;
import homework.utils.RandomUtil;
import lombok.SneakyThrows;

import java.lang.reflect.Field;
import java.util.Arrays;

public class FieldsBuilderByAnnotations implements FieldsBuilder {

    @Override
    public void buildFields(Class t) {
        buildByInjectRandomInt(t);
        buildByInjectByType(t);
    }

    private void buildByInjectRandomInt(Class t) {
        Field[] fields = t.getClass().getDeclaredFields();
        Arrays.stream(fields)
                .filter(f -> f.isAnnotationPresent(InjectRandomInt.class))
                .peek(f -> f.setAccessible(true))
                .peek(f -> {
                    try {
                        f.setInt(t, RandomUtil.between(f.getAnnotation(InjectRandomInt.class).fromValue(), f.getAnnotation(InjectRandomInt.class).toValue()));
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    }
                });
    }

    @SneakyThrows
    private void buildByInjectByType(Class t) {
        Field[] fields = t.getClass().getDeclaredFields();
        Arrays.stream(fields)
                .filter(f -> f.isAnnotationPresent(InjectByType.class))
                .peek(f -> f.setAccessible(true))
                .peek(f -> new ImplResolverMapOrPackage().resolveImpl(f.getClass()))
                .peek(f -> {
                    try {
                        f.set(t, ObjectFactory.getInstance().createObject(f.getClass()));
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    }
                });
    }
}
