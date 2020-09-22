package cn.errison.feature.demo.lambda;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class Demo2 {


    private static void createStream() {
        // empty
        Stream<String> streamEmpty = Stream.empty();
        // stream of array
        Stream<String> stringStream = Stream.of("a", "b", "c");
        // stream of list
        List<Integer> list = Arrays.asList(1, 2, 3);
        Stream<Integer> integerStream = list.stream();
        // builder
        Stream<String> builderStream = Stream.<String>builder().add("a").add("b").add("c").build();
        // generate
        Stream<String> stringStream1 = Stream.generate(() -> "what a long story").limit(10);
        // iterate
        Stream<Integer> streamIterated = Stream.iterate(40, n -> n + 2).limit(20);
        streamIterated.forEach( x -> System.out.print(x));
    }

    private static void foreachExample() {
        List<Integer> list = Arrays.asList(1, 2, 3);
        list.forEach(x -> {
            if (x > 3) {
                System.out.println("numbers bigger than " + x);
            }
        });

        for (Integer i : list) {
            if (i > 3) {
                System.out.println("numbers bigger than " + i);
            }

        }
    }


    public static void main(String[] args) {
        createStream();
        foreachExample();
    }
}
