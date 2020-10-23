package cn.errison.time;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.*;

public class Java8DateTime {

    private static void localDate() {
        LocalDate date = LocalDate.of(2020, Month.OCTOBER, 20);
        System.out.println(date.atTime(15, 58, 0, 0));
        System.out.println(date);
        LocalDate update = date.withDayOfMonth(11);
        System.out.println(update);
        System.out.println(date.getEra());
        System.out.println(date.lengthOfYear());
        System.out.println(date.getChronology());
        System.out.println(date.isLeapYear());

    }

    private static void localTime() {
        LocalTime time = LocalTime.of(19, 19, 19, 19);
        System.out.println(time.getHour());
        System.out.println(LocalTime.MAX);
        System.out.println(LocalTime.MIDNIGHT);

    }

    private static void localDateTime() {
        TemporalQuery query = new FamilyBirthDay();
        System.out.println(query.queryFrom(LocalDateTime.now()));
    }

    private static void instant() {
        Instant instant = Instant.from(LocalDateTime.now());
    }

    private static void duration() {
        Duration duration = Duration.between(LocalTime.now(), LocalTime.of(22, 22, 22));
        System.out.println(duration.getSeconds());
        System.out.println(duration.getNano());
        duration.get(ChronoUnit.YEARS);
    }

    private static void period() {
        Period period = Period.between(LocalDate.of(2020, 2, 28), LocalDate.of(2021, 2, 28));
        System.out.println(period.getYears());
        System.out.println(period.getMonths());
        System.out.println(period.getDays());
    }

    private static void zoneDateTime() {
        ZoneOffset offset = ZoneOffset.ofHours(8);
        System.out.println(offset.getId());


        ZoneId zoneId = ZoneId.of("Asia/Shanghai");
        ZoneId same = ZoneId.ofOffset("UTC", offset);

        ZonedDateTime zonedDateTime = ZonedDateTime.now().withZoneSameLocal(zoneId);
        System.out.println(zonedDateTime.toString());

        zonedDateTime = ZonedDateTime.now().withZoneSameLocal(same);
        System.out.println(zonedDateTime.toString());

    }

    private static void formatter(){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("");
    }


    public static class FamilyBirthDay implements TemporalQuery {

        @Override
        public Object queryFrom(TemporalAccessor temporal) {
            return isFamilyBirthday(temporal);
        }

        private Boolean isFamilyBirthday(TemporalAccessor date) {
            int month = date.get(ChronoField.MONTH_OF_YEAR);
            int day = date.get(ChronoField.DAY_OF_MONTH);

            // Angie's birthday is on April 3.
            if ((month == Month.APRIL.getValue()) && (day == 3))
                return Boolean.TRUE;

            // Sue's birthday is on June 18.
            if ((month == Month.JUNE.getValue()) && (day == 18))
                return Boolean.TRUE;

            // Joe's birthday is on May 29.
            if ((month == Month.MAY.getValue()) && (day == 29))
                return Boolean.TRUE;

            return Boolean.FALSE;
        }

    }


    public static void main(String[] args) {
//        localDate();
//        localTime();
//        localDateTime();
        duration();
//        period();
//        zoneDateTime();
    }
}
