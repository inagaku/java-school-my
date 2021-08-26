package homework.my_spring_old.reflection_examples;/**
 * @author Evgeny Borisov
 */

import java.lang.annotation.Retention;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Retention(RUNTIME)
public @interface TestMethod {
    int numberOfInvocations();
}
