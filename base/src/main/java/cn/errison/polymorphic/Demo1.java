package cn.errison.polymorphic;

public class Demo1 {

    public class A {
        public String show(D obj){
            return ("A and D");
        }
        public String show(A obj){
            return ("A and A");
        }
    }
    public class B extends A {
        public String show(B obj){
            return ("B and B");
        }
        public String show(A obj){
            return ("B and A");
        }
    }

    public class C extends B {

    }

    public class D extends B{

    }

    public void test1(){
        A a1 = new A();
        A a2 = new B();
        B b = new B();
        C c = new C();
        D d = new D();
        System.out.println("1--" + a1.show(b));
        System.out.println("2--" + a1.show(c));
        System.out.println("3--" + a1.show(d));
        System.out.println("4--" + a1.show(b));
        System.out.println("5--" + a1.show(c));
        System.out.println("6--" + a1.show(d));
        System.out.println("7--" + a1.show(b));
        System.out.println("8--" + a1.show(c));
        System.out.println("9--" + a1.show(d));


    }

    public static void main(String[] args) {

        Demo1 demo1 = new Demo1();
        demo1.test1();

    }
}
