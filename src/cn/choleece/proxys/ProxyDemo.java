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
        /**
         * CGLIB实现的动态代理，要求委托不能被final关键字修饰，因为在运行期间，通过Java的反射极致，会生成委托类的子类，我们知道，一旦被final关键字修饰，那么这个类就不能被继承
         */
        System.out.println("I am the cglib dynamic model");
        CglibDynamicProxy cglibDynamicProxy = new CglibDynamicProxy();
        CglibDynamicProxyImpl cglibDynamicProxyImpl = (CglibDynamicProxyImpl) cglibDynamicProxy.getInstance(new CglibDynamicProxyImpl());
        cglibDynamicProxyImpl.loveBaby();
    }
}
