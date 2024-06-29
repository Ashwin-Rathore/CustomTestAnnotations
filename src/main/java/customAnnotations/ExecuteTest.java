package customAnnotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Author : Ashwin Rathore
 * Date : 29-06-2024
 * Email - ashwin.rathore001@gmail.com
 */


@Target({ElementType.TYPE,ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface ExecuteTest {

    String[] TestType() default "";
    int Priority() default 0;
    boolean Positive() default false;
    boolean Negative() default false;
    String[] TicketId() default "";
    String[] EpicId() default "";
    String[] FeaturePackId() default "";
}