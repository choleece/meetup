package cn.choleece.threads;

/**
 * Created by choleece on 2018/7/17.
 */
public class CompareAndSwap {
    private int value;

    public synchronized int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public synchronized int compareAndSwap(int expectedValue, int newValue) {
        int oldValue = this.value;

        System.out.println("oldValue: " + oldValue + " newValue: " + newValue + " exepectedValue: " + expectedValue);

        if (oldValue == expectedValue) {
            this.value = newValue;
            return this.value;
        }

        return oldValue;
    }

    public synchronized boolean compareAndSet(int expectedValue, int newValue) {
        return expectedValue == compareAndSwap(expectedValue, newValue);
    }
}
