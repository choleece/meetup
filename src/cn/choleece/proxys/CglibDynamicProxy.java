package cn.choleece.proxys;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @author choleece
 * @description: 代理模式之CGLIB的动态代理--CglibDynamicProxy代理类
 * @description: CglibDynamicProxy,在代理模式中，叫做代理类，增强DynamicProxyImpl实现类
 * @description: 一个代理类，实现了MethodInterceptor接口，JDK代理是实现了InvocationHandler接口
 * @description: CGLIB的动态代理与静态代理的区别句在这个代理类，静态代理类直接实现接口，而CGLIB的动态代理类不直接实现具体的接口，而是实现了MethodInterceptor接口
 * @date 2018/7/16 12:57
 */
public class CglibDynamicProxy implements MethodInterceptor {

    /**
     * 目标实现类，也就是某个接口的实现类，这里的target_class, 可以看着是一种抽象
     */
    private Object target_class;

    /**
     * 创建代理对象
     * @param target_class
     * @return
     */
    public Object getInstance(Object target_class) {
        this.target_class = target_class;
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(this.target_class.getClass());
        /**
         * 回调方法
         */
        enhancer.setCallback(this);
        /**
         * 创建代理对象
         */
        return enhancer.create();
    }

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("introduced by wg");
        methodProxy.invoke(o, objects);
        System.out.println("married....");
        return null;
    }
}
