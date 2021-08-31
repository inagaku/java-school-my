package real_spring;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.PropertySource;


@Configuration
@PropertySource("classpath:quotes.properties")
@ComponentScan(basePackages = "real_spring")
@EnableAspectJAutoProxy
public class QuoterConfig {


}
