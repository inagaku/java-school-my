package homework.my_spring;

/**
 * @author Evgeny Borisov
 */
public class CleanerImpl implements my_spring.Cleaner {

    //@InjectRandomInt(min=3,max = 5)
    private int repeat;

    @Override
    public void clean() {
        for (int i = 0; i < repeat; i++) {
            System.out.println("VVVVVVVvvvvvvvvvvvvvvvvv");
        }
    }
}
