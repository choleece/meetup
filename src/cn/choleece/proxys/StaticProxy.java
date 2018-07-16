package cn.choleece.proxys;

/**
 * @author choleece
 * @description: cn.choleece.proxys
 * @date 2018/7/16 12:26
 */
public class StaticProxy {
    private StaticProxyInterfaceImpl staticProxyInterface;

    public StaticProxy(StaticProxyInterfaceImpl staticProxyInterface) {
        this.staticProxyInterface = staticProxyInterface;
    }

    public void loveBaby() {
        System.out.println("introduced by wg");
        staticProxyInterface.loveBaby();
        System.out.println("married....");
    }
}
