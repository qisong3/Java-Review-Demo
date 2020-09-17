package cn.errison.feature.demo.number;

public class Demo {

    private static void printNum(){
        // 十进制
        int a = 52;
        // 十六进制
        int b = 0x34;
        // 八进制
        int c = 064;
        // 二进制
        int d = 0b110100;
        // 二进制横线
        int d1 = 0b11_0_100;
        System.out.println(a == b && a == c && a == d && a == d1);
    }

    public static void main(String[] args) {
        printNum();
    }
}
