package homework.my_spring_old;

import org.reflections.Reflections;

import java.util.Set;

public class ImplResolverMapOrPackage implements ImplResolver {
    private Config config = new JavaConfig();
    private Reflections scanner = new Reflections("my_spring");

    @Override
    public <T> Class<T> resolveImpl(Class<T> type) {
        if (type.isInterface()) {
            Class<T> implClass = config.getImplClass(type);
            if (implClass == null) {
                Set<Class<? extends T>> classes = scanner.getSubTypesOf(type);
                if (classes.size() != 1) {
                    throw new IllegalStateException(type + " has 0 or more than one impl was found, please update your config");
                }
                implClass = (Class<T>) classes.iterator().next();
            }
            type = implClass;
        }
        return type;
    }
}
