package homework.java8;

import java.util.function.Consumer;

/**
 * @author Evgeny Borisov
 */
public interface ActionMaker<T> {
    void doAction(T t);
}
