package real_spring;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author Evgeny Borisov
 */
public class Main {
    public static void main(String[] args) {
//        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("context.xml");

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DBExceptionConfig.class);
        context.close();
    }
}
