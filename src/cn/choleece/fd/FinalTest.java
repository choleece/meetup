package cn.choleece.fd;

/**
 * 查看final, finalize, finally的区别
 * Created by choleece on 2018/5/28.
 */
public class FinalTest {
    final int a = 6;

    /**
     * 在声明final成员变量时没有赋值，称为空白final，
     */
    final int b;

    /**
     * 如有空白final值，则不允许空的构造函数，必须将空白final初始化，并且已初始化final的成员变量不能再改变
     * @param b
     */
    public FinalTest(int b) {
        this.b = b;
    }

    void doIt() {
        /**
         * 局部变量定义为final,不可改变i的值
         */
        final int i = 7;
    }

    /**
     * final修饰的方法只能使用，不能重载
     * @param a
     * @return
     */
    final int testFinalFunc(int a) {
        return a;
    }

}
