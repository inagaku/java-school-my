package real_spring_backup;

import lombok.Setter;
import my_spring.InjectRandomName;

import javax.annotation.PostConstruct;
import java.util.List;

/**
 * @author Evgeny Borisov
 */
public class TalkingRobot {

    @InjectRandomName
    private String name;

    @Setter
    private List<Quoter> quoters;

    @PostConstruct
    public void talk() {
        System.out.println(name);
        quoters.forEach(Quoter::sayQuote);
    }
}
