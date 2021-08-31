package real_spring_backup;

import lombok.Setter;

import java.util.List;

/**
 * @author Evgeny Borisov
 */
public class TerminatorQuoter implements Quoter {

    @Setter
    private List<String> messages;

    @Override
    public void sayQuote() {
        messages.forEach(System.out::println);
    }



    public void terminate(){
        System.out.println("you are terminated...");
    }

}


