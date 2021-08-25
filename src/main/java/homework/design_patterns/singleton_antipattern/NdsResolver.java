package homework.design_patterns.singleton_antipattern;

/**
 * @author Evgeny Borisov
 */
public interface NdsResolver {
    double getNds();
    default int getX(){return 5;}


}
