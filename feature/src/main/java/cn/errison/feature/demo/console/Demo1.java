package cn.errison.feature.demo.console;

import java.io.Console;

public class Demo1 {

    private static void testConsole() {
        Console c = System.console();
        System.out.println("Enter your name: ");
        String n = c.readLine();
        System.out.println("Welcome " + n);
    }

    public static void main(String[] args) {
        testConsole();
    }
}
