package homework.my_spring_old;

import homework.my_spring_old.annotations_lab.InjectByType;

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
