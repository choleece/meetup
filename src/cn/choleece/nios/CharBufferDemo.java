package cn.choleece.nios;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.CharBuffer;
import java.util.Arrays;

/**
 * Created by choleece on 2018/7/6.
 */
public class CharBufferDemo {
    public static void main(String[] args) {
        char[] chars = {'a', 'b', 'c', 'd'};

        CharBuffer charBuffer = CharBuffer.wrap(chars);

        System.out.println(charBuffer.get());
        System.out.println(charBuffer.isReadOnly());
        System.out.println(charBuffer.hasArray());
        Arrays.stream(new char[][]{chars}).forEach(item -> System.out.println(item));

        ByteBuffer byteBuffer = ByteBuffer.allocate(10);
        byteBuffer.asCharBuffer();
    }
}
