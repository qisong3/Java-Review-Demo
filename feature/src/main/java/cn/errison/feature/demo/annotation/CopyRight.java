package cn.errison.feature.demo.annotation;

import java.lang.annotation.*;

@Documented
@Inherited
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface CopyRight {

    String author() default "nobody";
    int duration() default 365;
}
