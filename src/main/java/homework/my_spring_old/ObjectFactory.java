package homework.my_spring_old;

import lombok.Getter;
import lombok.SneakyThrows;

public class ObjectFactory {
    @Getter
    public static ObjectFactory instance = new ObjectFactory();

    private int testPar;

    @SneakyThrows
    public <T> T createObject(Class<T> type) {
        ImplResolver implResolver = new ImplResolverMapOrPackage();
        FieldsBuilder fieldsBuilder = new FieldsBuilderByAnnotations();

        type = implResolver.resolveImpl(type);
        fieldsBuilder.buildFields(type);

        T t = type.getDeclaredConstructor().newInstance();

//        for (Field field : fields) {
//            if (field.isAnnotationPresent(InjectRandomInt.class)) {
//                InjectRandomInt annotation = field.getAnnotation(InjectRandomInt.class);
//                field.setInt(t, RandomUtil.between(annotation.fromValue(), annotation.toValue()));
        return t;
    }

}
