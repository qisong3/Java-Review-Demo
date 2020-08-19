package cn.errison.feature.demo.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Demo1 {

    public static void test1(){
        String content1 = "This is Chaitanya " +
                "from Beginnersbook.com.";
        String content2 = "This is Chaitanya " +
                "from booikscom+";

        Pattern pattern = Pattern.compile(".*book.*");
        Matcher matcher = pattern.matcher(content1);
        System.out.println("The content1 contains 'book'? " + matcher.find());
        matcher = pattern.matcher(content2);
        System.out.println("The content2 contains 'book'? " + matcher.find());
    }

    public static void test2(){
        String content = "ZZZ AA PP AA QQQ AAA ZZ";

        String string = "AA";
        Pattern pattern = Pattern.compile(string);
        Matcher matcher = pattern.matcher(content);

        while(matcher.find()) {
            System.out.println("Found at: "+ matcher.start()
                    +
                    " - " + matcher.end());
        }
    }

    public static void main(String[] args){
        test1();
        test2();
    }

}
