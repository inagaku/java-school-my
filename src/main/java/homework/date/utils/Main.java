package homework.date.utils;

import java.time.LocalDateTime;

public class Main {
    public static void main(String[] args) {
        System.out.println(CustomDateFormatter.convertStringToDate("20=02=2021_12+15+51-PM"));
        System.out.println(CustomDateFormatter.convertDateToString(LocalDateTime.now()));
    }
}
