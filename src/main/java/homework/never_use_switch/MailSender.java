package homework.never_use_switch;

import static homework.never_use_switch.MailType.postMailAction;

/**
 * @author Evgeny Borisov
 */
public class MailSender {

    public void send(MailInfo mailInfo) {
        //todo refactor this to beautiful code
        //50 lines of code which send welcome mail
        postMailAction(mailInfo);
    }
}
