package homework.lab1;

import java.util.Arrays;
import java.util.List;

/**
 * @author Evgeny Borisov
 */
public class Main {
    public static void main(String[] args) throws InterruptedException {
        List<Integer> listInts = Arrays.asList(1, 2);
        ArraySuperIntegerList myList = new ArraySuperIntegerList(listInts);

        myList.add(8);
        myList.printAll();
        myList.removeByIndex(2);
        myList.printAll();
        myList.removeByValue(2);
        myList.printAll();
        myList.get(4);
    }
}
