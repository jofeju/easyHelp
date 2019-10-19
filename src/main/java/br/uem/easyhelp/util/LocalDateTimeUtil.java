package br.uem.easyhelp.util;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneId;
import java.util.Date;

public class LocalDateTimeUtil {

    public static LocalDate toLocalDate(Date date) {
        return date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
    }

    public static LocalTime toLocalTime(Date date) {
        return date.toInstant().atZone(ZoneId.systemDefault()).toLocalTime();
    }

    public static boolean isNextDay(LocalDate target, LocalDate comparing) {
        return target.isAfter(comparing)
                && target.isBefore(comparing.plusDays(2));
    }

    public static boolean isSameDay(Date target, Date comparing) {
        return toLocalDate(target).isEqual(toLocalDate(comparing));
    }

    public static boolean isBetween(Date init, Date comparing, Date end) {
        LocalTime initTime = toLocalTime(init);
        LocalTime comparingTime = toLocalTime(comparing);
        LocalTime endTime = toLocalTime(end);

        return (comparingTime.equals(initTime) || comparingTime.isAfter(initTime))
                && (comparingTime.isBefore(endTime) || comparingTime.equals(endTime));
    }

    public static LocalDate incioDoMesAtual() {
        return LocalDate.now().withDayOfMonth(1);
    }
}
