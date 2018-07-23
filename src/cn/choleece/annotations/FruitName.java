package cn.choleece.annotations;

import java.lang.annotation.*;

/**
 * @author choleece
 * @description: 水果名称注解
 * @date 2018/7/20 9:57
 */

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface FruitName {
    String value() default "";
}
