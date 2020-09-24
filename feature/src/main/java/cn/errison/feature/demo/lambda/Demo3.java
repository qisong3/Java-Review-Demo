package cn.errison.feature.demo.lambda;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.Function;

public class Demo3 {

    private void testStaticMethod() {
        List<String> list = Arrays.asList("aaa", "bbb", "ccc");
        System.out.println("from StaticMethod reference");
        // method reference
        list.forEach(System.out::println);
        // lambda
//        list.forEach(value -> System.out.println(value));
//        // normal
//        for (String string : list) {
//            System.out.println(string);
//        }
    }

    private void testInstanceMethod() {
        final List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        System.out.println("from InstanceMethod reference");
        final MyComparator myComparator = new MyComparator(0);
        // Method reference
        Collections.sort(list, myComparator::compare);
        list.forEach( x -> System.out.println(x));
        // Lambda expression
//        Collections.sort(list, (a, b) -> myComparator.compare(a, b));
    }


    private void testTypeInstanceMethod() {
        final List<MyComparator> list = Arrays.asList(new MyComparator(1), new MyComparator(2), new MyComparator(3));
        System.out.println("number from TypeInstanceMethod reference");
        // Method reference
        list.forEach(MyComparator::count);
        // Lambda expression
//        list.forEach(value -> value.count());
//        // normal
//        for (final MyComparator comparator : list) {
//            comparator.count();
//        }
    }


    private void testConstructor(){
        ComparatorFactory factory = MyComparator::new;
        MyComparator comparator = factory.getComparator(100);
        System.out.println("number from constructor reference");
        comparator.count();
    }

    @FunctionalInterface
    private interface ComparatorFactory{
        MyComparator getComparator(Integer i);
    }


    private static class MyComparator {

        private Integer integer;

        public MyComparator(Integer i) {
            this.integer = i;
        }

        public int compare(final Integer a, final Integer b) {
            return a.compareTo(b);
        }

        public void count() {
            System.out.println(integer);
        }
    }



    public static void main(String[] args) {

        Demo3 demo3 = new Demo3();
        demo3.testStaticMethod();
        demo3.testInstanceMethod();
        demo3.testTypeInstanceMethod();
        demo3.testConstructor();
    }
}
