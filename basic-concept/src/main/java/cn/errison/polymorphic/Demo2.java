package cn.errison.polymorphic;

public class Demo2 {

    public class A {

        int a;
        public String show() {
            return ("show() in A");
        }

        public String show(A obj) {
            return ("show(A) from A");
        }

        public String show(D obj) {
            return ("show(D) from A");
        }

    }

    public class B extends A {

        int b;
        public String show() {
            return ("show() in B");
        }

        public String show(C obj) {
            return ("show(C) from B");
        }
    }

    public class C extends B {

    }

    public class D extends C {

    }


    public void test1() {

        A a1 = new A();
        A a2 = new B();

        System.out.println("1--" + a1.show());
        System.out.println("2--" + a2.show());
    }

    public void test2() {

        A a1 = new A();
        A a2 = new B();
        B b = new B();
        C c = new C();
        D d = new D();

        System.out.println("3--" + a2.show(a1));
        System.out.println("4--" + a2.show(a2));

        System.out.println("5--" + b.show(a1));
        System.out.println("6--" + b.show(b));
        System.out.println("7--" + b.show(c));
        System.out.println("8--" + b.show(d));
    }

    public static void main(String[] args) {

        Demo2 demo1 = new Demo2();
        demo1.test1();
        demo1.test2();

    }
}
