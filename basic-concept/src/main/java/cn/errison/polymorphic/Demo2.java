package cn.errison.polymorphic;

import java.io.Serializable;

public class Demo2 {

    public static void hello(char a){
        System.out.println();
    }

    public static void hello(byte a){
        System.out.println("a from Character");
    }

    public static void hello(short a){
        System.out.println("a from Character");
    }


    public static void hello(int a){
        System.out.println("a from int");
    }

    public static void hello(long a){
        System.out.println("a from long");
    }

    public static void hello(float a){
        System.out.println("a from float");
    }

    public static void hello(double a){
        System.out.println("a from double");
    }

    public static void hello(Character a){
        System.out.println("a from Character");
    }

    public static void hello(Serializable a){
        System.out.println("a from Serializable");
    }

    public static void hello(Comparable a){
        System.out.println("a from Comparable");
    }


    public static void hello(char... a){
        System.out.println("a from char...");
    }

    public static void main(String[] args) {
        hello('a');
    }
}
