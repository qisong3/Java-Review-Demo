package cn.errison.feature.demo.optional;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.Optional;

public class Demo {

    @Getter
    @Setter
    class Job {
        private int id;
        private String name;
    }

    private void test() {

        Optional<Job> optionalJob = Optional.ofNullable(null);
        optionalJob.ifPresent(x -> {
            System.out.println(x.id);
            System.out.println(x.name);
        });
        Job neverNullJob = optionalJob.orElse(new Job());
        System.out.println(neverNullJob);

    }

    public static void main(String[] args) {
        Demo demo = new Demo();
        demo.test();
    }
}
