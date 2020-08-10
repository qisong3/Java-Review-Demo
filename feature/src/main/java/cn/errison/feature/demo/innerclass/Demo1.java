package cn.errison.feature.demo.innerclass;

public class Demo1 {

    private String innerValue = "inner value";

    private String innerMethod() {
        return "inner method";
    }

    private class InnerClass {

        private void printResult() {
            System.out.println("Get innerValue from OuterClass" + innerValue);
            System.out.println("Gent innerMethod from OuterClass" + innerMethod());
        }
    }

    private void methodWithInnerClass() {

        int num = 23;
        // method-local inner class
        class MethodInnerClass {
            public void print() {
                System.out.println("This is method inner class " + num);
            }
        } // end of inner class

        // Accessing the inner class
        MethodInnerClass inner = new MethodInnerClass();
        inner.print();
    }

    abstract class AnonymousInnerClass{

        protected void abstractMethod(){

        }
    }

    public static void main(String[] args) {
        Demo1 demo1 = new Demo1();
        // 1 Normal nner class
        // 注意内部类的声明方式
        Demo1.InnerClass innerClass = demo1.new InnerClass();
        innerClass.printResult();
        // 2 local method inner class
        demo1.methodWithInnerClass();
        // 3 Anonymous Class
        AnonymousInnerClass anonymousInnerClass = demo1.new AnonymousInnerClass(){
            protected void abstractMethod(){
                System.out.println("Method from Anonymous Inner class");
            }
        };
        anonymousInnerClass.abstractMethod();
    }
}
