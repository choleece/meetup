package cn.choleece.j8;

/**
 * @author choleece
 * @description: cn.choleece.j8
 * @date 2018/7/13 8:03
 */
public class InterfaceOverride implements InterfaceDemo {
    @Override
    public void testInterfaceDefaultFunc() {
        System.out.println("parent override interface default func");
    }
}
