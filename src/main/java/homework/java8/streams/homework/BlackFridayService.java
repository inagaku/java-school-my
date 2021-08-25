package homework.java8.streams.homework;

import javax.swing.*;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.util.stream.Collectors;

public class BlackFridayService {

    public static void printBlackFridayPerYearSorted(int startYear, int endYear) {

        LocalDate startDate = LocalDate.of(startYear, 1, 13);
        LocalDate endDate = LocalDate.of(endYear, 12, 13);

        startDate.datesUntil(endDate, Period.ofMonths(1))
                .filter(date -> date.getDayOfMonth() == 13 && date.getDayOfWeek() == DayOfWeek.FRIDAY)
                .collect(Collectors.groupingBy(LocalDate::getYear, Collectors.counting()))
                .entrySet().stream()
                .sorted((d1, d2) -> (int) (d2.getValue() - d1.getValue()))
                .forEach(System.out::println);
    }

    public static void main(String[] args) {
        printBlackFridayPerYearSorted(1970, 2020);
    }
}
