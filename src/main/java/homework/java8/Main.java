package homework.java8;

import java.util.List;

import static homework.java8.ListUtils.forEachWithDelay;


public class Main {
    public static void main(String[] args) {
        forEachWithDelay(List.of(1, 2, 7, 51, 125, 2, 5), 1000, (t, delay) -> {
            System.out.println(t);
            Thread.sleep(delay);
        });
    }
}
