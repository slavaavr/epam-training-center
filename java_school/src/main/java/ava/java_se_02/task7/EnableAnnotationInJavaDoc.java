package ava.java_se_02.task7;

import java.lang.annotation.*;

@Documented
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface EnableAnnotationInJavaDoc {
    String value();
}