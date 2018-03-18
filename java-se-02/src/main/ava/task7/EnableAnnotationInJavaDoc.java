package main.ava.task7;

import java.lang.annotation.*;

@Documented
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface EnableAnnotationInJavaDoc {
    String value();
}