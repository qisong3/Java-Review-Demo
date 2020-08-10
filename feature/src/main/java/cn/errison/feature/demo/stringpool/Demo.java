package cn.errison.feature.demo.stringpool;

public class Demo {

    public static void main(String[] args) {
        String name1 = "errison.cn";
        String name2 = "errison.cn";
        String name3 = new String("errison.cn");
        String name4 = new String("errison.cn").intern();// since JDK1.3

        System.out.println(name1 == name2); // true
        System.out.println(name1 == name3); // false
        System.out.println(name1 == name4); // true
    }
}
