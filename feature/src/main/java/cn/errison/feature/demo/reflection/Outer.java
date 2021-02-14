package cn.errison.feature.demo.reflection;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;

public class Outer {

    public void myPublic() {
        System.out.println("public method");
    }

    private void myPrivate() {
        System.out.println("private method");
    }

    class Inside {
        public void nestedPublic() {
        }
    }


    class NestedInside1 {

        class NestedInside2 {

        }
    }

    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Outer containInside = new Outer();
        Method method = containInside.getClass().getDeclaredMethod("myPrivate");
        NestedInside1 nested1 = containInside.new NestedInside1();
        System.out.println(nested1.getClass().isNestmateOf(Outer.class));
        System.out.println(nested1.getClass().getNestHost());
        Class<?>[] members = containInside.getClass().getNestMembers();
        Arrays.stream(members).forEach(System.out::println);
    }
}
