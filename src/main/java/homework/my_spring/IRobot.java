package homework.my_spring;

import homework.my_spring.annotations_lab.InjectByType;

/**
 * @author Evgeny Borisov
 */

public class IRobot {
    //todo make support for @InjectByType
    @InjectByType
    private Speaker speaker;
    @InjectByType
    private Cleaner cleaner;

    public void cleanRoom(){
        speaker.speak("Я начал работать");
        cleaner.clean();
        speaker.speak("Я закончил работать");
    }
}
