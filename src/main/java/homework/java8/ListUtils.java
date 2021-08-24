package homework.java8;

import lombok.SneakyThrows;

import java.util.List;


public class ListUtils {
    public static <T> void forEachWithDelay(List<T> list, int delay, ActionMaker<T> actionMaker){
        list.forEach(t -> {
            try {
                actionMaker.doAction(t, delay);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        //todo finish this
    }

}
