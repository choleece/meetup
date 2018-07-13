package cn.choleece.j8;

/**
 * @author choleece
 * @description: cn.choleece.j8
 * @date 2018/7/13 7:59
 */
public interface InterfaceDemo {
    static void testInterfaceStaticFunc() {
        System.out.println("test interface static func");
    }

    default void testInterfaceDefaultFunc() {
        System.out.println("test interface default func");
    }
}
