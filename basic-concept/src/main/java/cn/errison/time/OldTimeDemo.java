package cn.errison.time;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class OldTimeDemo {

    private static void createTime() {
        Date date = new Date();
        System.out.println(date.toString());
    }

    private static void printTime() throws ParseException {
        SimpleDateFormat format = new SimpleDateFormat();
        Date date = format.parse("Thu Oct 08 15:49:11 CST 2020");
        System.out.println(date);
    }





    public static void main(String[] args) throws ParseException {
        createTime();
        printTime();
    }
}
