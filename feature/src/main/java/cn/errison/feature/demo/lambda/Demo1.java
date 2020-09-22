package cn.errison.feature.demo.lambda;

import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.BiPredicate;
import java.util.function.IntSupplier;

public class Demo1 {

    @FunctionalInterface
    interface ConsumerInterface {

        void testBiConsumer(int a, int b);
    }

    private static void compare() {
        ConsumerInterface interface1 = new ConsumerInterface() {
            @Override
            public void testBiConsumer(int a, int b) {
                System.out.println("传统定义方式");
            }
        };

        ConsumerInterface interface2 = (a, b) -> System.out.println("Lambda语句");
        interface1.testBiConsumer(1,2);
        interface2.testBiConsumer(1,2);
    }


    // 有输入有输入
    private static void defineLambdaFunction() {
        BiFunction<Integer, Long, String> biFunction = (a, b) -> "BiFunction return: a :" + a + "  b: " + b;
        String str = biFunction.apply(1, Long.MAX_VALUE);
        System.out.println(str);
    }

    // 有输入无返回
    private static void defineLambdaConsumer() {
        BiConsumer<Integer, Long> biConsumer = (a, b) -> System.out.println("BiConsumer a :" + a + "  b: " + b);
        biConsumer.accept(1, Long.MAX_VALUE);
    }

    // 有入参有返回
    private static void defineLambdaPredict() {
        BiPredicate<Integer, Integer> biPredicate = (a, b) -> a > b;
        System.out.println("Predict result : " + biPredicate.test(2, 4));;
    }

    // 没有参数
    private static void defineLambdaSupplier() {
        IntSupplier supplier = () -> 3;
        System.out.println("Supplier : " + supplier.getAsInt());
    }


    public static void main(String[] args) {

        compare();
        defineLambdaFunction();
        defineLambdaConsumer();
        defineLambdaPredict();
        defineLambdaSupplier();

    }
}
