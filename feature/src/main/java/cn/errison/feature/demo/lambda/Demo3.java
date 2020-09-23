package cn.errison.feature.demo.lambda;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Demo3 {

    private static void testStaticMethod(){
        Stream<Car> stream = Stream.of(new Benz("aaa"), new Benz("bbb"), new Benz("ccc"));
        List list = stream.map(value -> value::move).collect(Collectors.toList());
        stream.peek(value -> Benz::engineStart);

    }

    public static void main(String[] args) {

    }
}
