package cn.choleece.annotations;

import java.lang.annotation.*;

/**
 * @author choleece
 * @description: cn.choleece.annotations
 * @date 2018/7/20 9:54
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface FruitColor {

    /**
     * 枚举颜色
     */
    enum Color {BLUE, RED, GREEN};

    /**
     * 颜色属性
     * @return
     */
    Color fruitColor() default Color.GREEN;
}
