package cn.choleece.proxys;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author choleece
 * @description: 代理模式之JDK动态代理， JDKDynamicProxy代理类
 * @description: JDKDynamicProxy，在代理模式中，增强DynamicProxyImpl实现类
 * @descritpion: 一个代理类，实现了InvocationHandler接口
 * @description: JDK的动态代理，与静态代理的区别就在这个代理类，静态代理类直接实现接口，而JDK的动态代理类不直接实现具体的接口，而是实现了JDK提供的InvocationHandler接口
 * @date 2018/7/16 12:30
 */
public class JDKDynamicProxy implements InvocationHandler {
    /**
     * 目标实现类，也就是某个接口的实现类，这里的target_interface_impls可以看作是一种抽象
     */
    private Object target_interface_impls;

    /**
     * 类似于带参数的构造方法，把带目标实现类的对象作为参数传递进去，这里不是覆盖具体某个实现类的构造方法，而是抽象出来的一个方法
     * @param target_interface_impls
     * @return
     */
    public Object dynamicBindImplToProxyClass(Object target_interface_impls) {
        this.target_interface_impls = target_interface_impls;
        /**
         * 取得代理对象
         */
        return Proxy.newProxyInstance(target_interface_impls.getClass().getClassLoader(), target_interface_impls.getClass().getInterfaces(), this);
        // JDK的动态代理依赖具体的接口，需要绑定接口，如果一个类没有接口实现，则不能使用JDK的动态代理
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object result = null;
        System.out.println("introduced by wg");
        result = method.invoke(target_interface_impls, args);
        System.out.println("married....");
        return result;
    }
}
