package real_spring_backup;

import lombok.SneakyThrows;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;

import javax.security.auth.DestroyFailedException;

/**
 * @author Evgeny Borisov
 */
public class BeanDefinitionValidatorBeanFactoryPostProcessor implements BeanFactoryPostProcessor {
    @SneakyThrows
    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        String[] definitionNames = beanFactory.getBeanDefinitionNames();
        for (String definitionName : definitionNames) {
            BeanDefinition beanDefinition = beanFactory.getBeanDefinition(definitionName);
            if (beanDefinition.getScope() != null && beanDefinition.getScope().equals("prototype") && beanDefinition.getDestroyMethodName() != null) {
                StringBuilder destroyExceptionString = new StringBuilder();
                destroyExceptionString.append(beanDefinition.getBeanClassName()).append(".")
                        .append(beanDefinition.getDestroyMethodName()).append(" method never works in this scope");
                throw new DestroyFailedException(destroyExceptionString.toString());
            }
        }
    }
}
