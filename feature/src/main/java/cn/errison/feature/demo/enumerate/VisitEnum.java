package cn.errison.feature.demo.enumerate;

import java.util.EnumSet;

public class VisitEnum {

    public static void getAll(){
        Day[] days = Day.values();
        System.out.println(days);
    }

    public static void getSingle(){
        Day day = Day.FRIDAY;
        System.out.println(day.getIndex());
        System.out.println(day.getName());
    }

    public static void getWithSet(){
        EnumSet<Day> set = EnumSet.allOf(Day.class);
        set.remove(Day.FRIDAY);
        System.out.println(set.toString());
    }

    public static void getDayByMethod(){
        Day day = Day.getDayByName("周六");
        System.out.println(day);
    }

    public static void main(String[] args) {
        getAll();
        getSingle();
        getWithSet();
        getDayByMethod();
    }
}
