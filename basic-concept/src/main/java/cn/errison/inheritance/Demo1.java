package cn.errison.inheritance;

import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;
import org.omg.CORBA.ObjectHelper;

public class Demo1 {

    interface Interface0{
        int value = 0;
    }

    interface Interface1 {
        int value1 = 1;
    }

    interface Interface2 extends Interface1{
        int value = 2;
    }

    public static class ParentClass implements Interface1{

        static {
            System.out.println("from parent class");
        }
        public static int value = 5;
    }

    public static class SubClass extends ParentClass implements Interface2{
        static {
            System.out.println("from child class");
        }
        public static int value = 7;
    }

    public static class OtherClass {

        static {
            System.out.println("from other class");
        }
    }

    public static void main(String[] args) {
        System.out.println(ParentClass.value);
    }
}
