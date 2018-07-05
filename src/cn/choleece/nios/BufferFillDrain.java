package cn.choleece.nios;

import java.nio.CharBuffer;

/**
 * Created by choleece on 2018/7/1.
 */
public class BufferFillDrain {
    private static int index = 0;

    private static String[] strings = {
            "A random string value",
            "The prduct of an infinite number of monkeys",
            "Hei hey we're the monkeys",
            "opening act for the monkees: Jimi Hendrix",
            "Help me, Help me"
    };

    public static void main(String[] args) {
        CharBuffer charBuffer = CharBuffer.allocate(100);
        while (fillBuffer(charBuffer)) {
            charBuffer.flip();
            drainBuffer(charBuffer);
            charBuffer.clear();
        }
    }

    private static void drainBuffer(CharBuffer charBuffer) {
        while (charBuffer.hasRemaining()) {
            System.out.print(charBuffer.get());
        }
        System.out.println("");
    }

    private static boolean fillBuffer(CharBuffer charBuffer) {
        if (index >= strings.length) {
            return false;
        }
        String string = strings[index++];

        for (int i = 0; i < string.length(); i++) {
            charBuffer.put(string.charAt(i));
        }
        return true;
    }
}
