package homework.date.utils;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Locale;

public class CustomDateFormatter {
        private static DateTimeFormatter stupidFormatter = DateTimeFormatter.ofPattern("dd=MM=yyyy_hh+mm+ss-a");

        public static LocalDateTime convertStringToDate(String date){
            LocalDateTime localDateTime = LocalDateTime.parse(date, stupidFormatter);
            return localDateTime;
        }

        public static String convertDateToString(LocalDateTime date) {
            return stupidFormatter.format(date);
        }

    }
