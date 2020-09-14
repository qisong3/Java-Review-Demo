package cn.errison.feature.demo.annotation.processor;

import java.lang.annotation.*;

@Documented
@Inherited
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.CLASS)
public @interface BookFactory {

    String author() default "Errison";
    String sn() default "1111111";
}
