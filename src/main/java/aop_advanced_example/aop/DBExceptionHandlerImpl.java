package aop_advanced_example.aop;

import aop_advanced_example.DBException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

@Component
public class DBExceptionHandlerImpl implements DBExceptionHandler {
    @Value("${mails}")
    private String[] mails;

    private List<Integer> handledExceptions = new ArrayList<Integer>();

    @Override
    public void handle(DBException ex) {
        if (handledExceptions.indexOf(ex.hashCode()) < 0) {
            Arrays.stream(mails).forEach(s -> System.out.println("mail to " + s + " " + ex.getMessage()));
            handledExceptions.add(ex.hashCode());
        }
    }
}
