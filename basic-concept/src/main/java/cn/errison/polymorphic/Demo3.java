package cn.errison.polymorphic;

public class Demo3 {

    static class A {
        A get() {
            return this;
        }
    }

    static class B extends A {
        B get() {
            return this;
        }

        void message() {
            System.out.println("welcome to covariant return type");
        }
    }

    public static void main(String[] args) {
        System.out.println(new B().get().message());;
    }
}


