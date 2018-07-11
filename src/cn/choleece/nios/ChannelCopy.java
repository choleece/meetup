package cn.choleece.nios;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;
import java.nio.channels.WritableByteChannel;

/**
 *
 * 通道的复制
 * @author choleece
 * @date 2018/7/8
 */
public class ChannelCopy {
    public static void main(String[] args) throws IOException {
        ReadableByteChannel src = Channels.newChannel(System.in);
        System.out.println(src.isOpen());
        WritableByteChannel dest = Channels.newChannel(System.out);
        System.out.println(dest.isOpen());
        channelCopy1(src, dest);
        src.close();
        System.out.println(src.isOpen());
        dest.close();
        System.out.println(dest.isOpen());
    }

    private static void channelCopy1(ReadableByteChannel src, WritableByteChannel dest) throws IOException {
        ByteBuffer byteBuffer = ByteBuffer.allocateDirect(16 * 1024);
        while (src.read(byteBuffer) != -1) {
            // prepare the buffer to be drained
            byteBuffer.flip();

            // write to the channel; may block
            dest.write(byteBuffer);

            // if partial transfer ,shift remainder down
            // if buffer is empty same sa doing clear()
            byteBuffer.compact();

            // EOF will leave in fill state
            byteBuffer.flip();

            // make sure that the buffer is fully drained
            while (byteBuffer.hasRemaining()) {
                dest.write(byteBuffer);
            }
        }
    }

    private static void channelCopy2(ReadableByteChannel src, WritableByteChannel dest) throws IOException {
        ByteBuffer buffer = ByteBuffer.allocateDirect(1 * 1024);

        while (src.read(buffer) != -1) {
            // prepare the buffer to be trained
            buffer.flip();

            // make sure that he buffer was fully drained
            while (buffer.hasRemaining()) {
                dest.write(buffer);
            }

            // make the buffer empty. ready for filling
            buffer.clear();
        }
    }
}
