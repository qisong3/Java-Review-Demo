package cn.errison.feature.demo.lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
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
        streamIterated.forEach(x -> System.out.print(x));
    }

    private static void testFilter() {
        Stream<Integer> integerStream = Stream.of(1, 2, 3, 4, 5);
        Stream<Integer> subStream = integerStream.filter(x -> x > 3);
        subStream.forEach(x -> System.out.println(x));
    }

    private static void testMap() {
        Stream<String> stream = Stream.of("aaa", "bbb", "ccc", "ddd");
        stream.map(x -> x.toUpperCase()).forEach(x -> System.out.println(x));
    }

    private static void testFlatMap() {
        List<String> stringList = new ArrayList<>();

        stringList.add("One flew over the cuckoo's nest");
        stringList.add("To kill a muckingbird");
        stringList.add("Gone with the wind");

        Stream<String> stream = stringList.stream();

        stream.flatMap((value) -> {
            String[] split = value.split(" ");
            return Arrays.asList(split).stream();
        }).forEach((value) -> System.out.println(value));
    }


    private static void testDistinct() {
        Stream<Integer> stream = Arrays.asList(1, 2, 3, 4, 5, 6, 1, 2, 3).stream();
        stream.distinct().forEach(x -> System.out.println(x));
    }

    private static void testLimit() {
        Stream<Integer> stream = Arrays.asList(1, 2, 3, 4, 5, 6, 1, 2, 3).stream();
        stream.limit(3).forEach(x -> System.out.println(x));
    }

    private static void testPeek() {
        Stream<Integer> stream = Arrays.asList(1, 2, 3, 4, 5, 6, 1, 2, 3).stream();
        stream.peek(x -> x = x + 1).forEach(x -> System.out.println(x));
    }

    private static void testAllMatch() {
        List<String> stringList = new ArrayList<String>();

        stringList.add("One flew over the cuckoo's nest");
        stringList.add("To kill a muckingbird");
        stringList.add("Gone with the wind");

        Stream<String> stream = stringList.stream();

        boolean allMatch = stream.allMatch((value) -> value.startsWith("One"));
        System.out.println(allMatch);
    }

    private static void testReduce() {
        List<String> stringList = new ArrayList<>();

        stringList.add("text 1");
        stringList.add("text 2");
        stringList.add("text 3");

        Stream<String> stream = stringList.stream();

        Optional<String> string = stream.reduce((x, value) -> x + value + "  ");
        System.out.println(string);

    }

    private static void testForeach() {
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

    private static void testCollect() {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6);
        List collect = list.stream().filter(x -> x % 2 == 0).collect(Collectors.toList());
        collect.forEach(x-> System.out.println(x));
    }


    public static void main(String[] args) {
        createStream();
        testFilter();
        testMap();
        testFlatMap();
        testLimit();
        testPeek();
        testAllMatch();
        testReduce();
        testDistinct();
        testForeach();
        testCollect();
    }
}
