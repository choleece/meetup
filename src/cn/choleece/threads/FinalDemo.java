package cn.choleece.threads;

/**
 * final demo
 * @author choleece
 * @description: cn.choleece.threads
 * @date 2018/6/7 11:08
 */
public class FinalDemo {
    private final int a = 6;

    private final String str;

    private final static boolean b;

    private final double d;

    private final char ch;

    {
        // 实例变量可以在初始代码块中赋值
        str = "初始化实例变量";
    }

    static {
        // 类变量（静态变量）可以在静态初始化代码块中赋值
        b = true;
        // 非静态变量不能在静态初始化代码块中赋值
        str = "非静态变量不能在静态初始化代码块中赋值";
    }

    public FinalDemo(double d) {
        // 实例变量可以在构造函数中赋值
        this.d = d;
        // 已赋值的实例变量不能再赋值
        a = 7;
    }

    public void setC() {
        // final修饰的变量不能在成员方法中赋值
        ch = 'c';
    }

    public void test(final int e) {
        final int f;
        f = 2;
        // 在final赋值过一次后再对其进行赋值会报错
        f = 3;
        // final型参数再对其进行赋值会报错，在参数的时候已经赋值了
        e = 4;
    }
}
