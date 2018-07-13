package cn.choleece.j8;

/**
 * @author choleece
 * @description: cn.choleece.j8
 * @date 2018/7/13 8:01
 */
public class Main {
    public static void main(String[] args) {
        // Java 8 支持interface可以有自己的方法体，必须是static 或者default类型，static类型为类方法，default类型为实例方法
        InterfaceDemo.testInterfaceStaticFunc();
        InterfaceDemo interfaceDemo = new InterfaceDemoImpl();
        interfaceDemo.testInterfaceDefaultFunc();
        // interface具体的实现一样可以重写interface的实例方法
        InterfaceDemo interfaceDemo1 = new InterfaceOverride();
        interfaceDemo1.testInterfaceDefaultFunc();
    }
}
