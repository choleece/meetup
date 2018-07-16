package cn.choleece.proxys;

/**
 * @author choleece
 * @description: cn.choleece.proxys
 * @date 2018/7/16 12:28
 */
public class ProxyDemo {
    public static void main(String[] args) {
        // 静态代理模式，由程序员写好的代理模式，编译器执行编译
        System.out.println("I am the static proxy model");
        StaticProxyInterfaceImpl staticProxyInterface = new StaticProxyInterfaceImpl();
        StaticProxy staticProxy = new StaticProxy(staticProxyInterface);
        staticProxy.loveBaby();

        // JDK动态代理
        System.out.println("I am the jdk dynamic model");
        JDKDynamicProxy jdkDynamicProxy = new JDKDynamicProxy();
        ProxyInterface dynamicProxy = (ProxyInterface) jdkDynamicProxy.dynamicBindImplToProxyClass(new DynamicProxyImpl());
        dynamicProxy.loveBaby();

        // CGLIB动态代理
        System.out.println("I am the cglib dynamic model");
        CglibDynamicProxy cglibDynamicProxy = new CglibDynamicProxy();
        CglibDynamicProxyImpl cglibDynamicProxyImpl = (CglibDynamicProxyImpl) cglibDynamicProxy.getInstance(new CglibDynamicProxyImpl());
        cglibDynamicProxyImpl.loveBaby();
    }
}
