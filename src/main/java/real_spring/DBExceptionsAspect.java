package real_spring;

import lombok.SneakyThrows;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;


@Aspect
@Component
public class DBExceptionsAspect {
    @Value("${emails}")
    private String emails;

    @Autowired
    private MessengerEMail messengerEMail;

    @AfterThrowing(value = "execution(* real_spring..*.*(..))", throwing = "DBException")
    @SneakyThrows
    public void handleDBExceptions(JoinPoint jp, Throwable DBException) {
        for (String email : emails.split(",")) {
            messengerEMail.sendMessage(email, DBException.getMessage());
        }
    }
}





