package cn.choleece.nios;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.IntBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.util.Random;

/**
 * Created by choleece on 2018/7/11.
 */
public class LockTest {
    private static final int SIZEOF_INT = 4;

    private static final int INDEX_START = 0;

    private static final int INDEX_COUNT = 10;

    private static final int INDEX_SIZE = INDEX_COUNT * SIZEOF_INT;

    private ByteBuffer buffer = ByteBuffer.allocate(INDEX_SIZE);

    private IntBuffer indexBUffer = buffer.asIntBuffer();

    private Random random = new Random();

    public static void main(String[] args) throws IOException, InterruptedException {
        for (int i = 0; i < args.length; i++) {
            System.out.printf(args[i]);
        }

        boolean writer = false;

        String filename;

        if (args.length != 2) {
            System.out.println("Usage : [ -r | -w  filename ]");
            return;
        }
        writer = args[0].equals("-w");
        filename = args[1];

        RandomAccessFile raf = new RandomAccessFile(filename, writer ? "rw" : "r");
        FileChannel fc = raf.getChannel();

        LockTest lockTest = new LockTest();
        if (writer) {
            lockTest.doUpdates(fc);
        } else {
            lockTest.doQueries(fc);
        }
    }

    void doQueries(FileChannel fc) throws IOException, InterruptedException {
        while (true) {
            println("trying for shared lock...");
            FileLock lock = fc.lock(INDEX_START, INDEX_SIZE, true);

            int reps = random.nextInt(60) + 20;

            for (int i = 0; i < reps; i++) {
                int n = random.nextInt(INDEX_COUNT);
                int position = INDEX_START + (n * SIZEOF_INT);
                buffer.clear();
                fc.read(buffer, position);
                int value = indexBUffer.get(n);
                println("Index entry " + n + "=" + value);
                Thread.sleep(100);
            }
            lock.release();
            println("<sleeping>");
            Thread.sleep(random.nextInt(3000) + 500);
        }
    }

    void doUpdates(FileChannel fc) throws IOException, InterruptedException {
        while (true) {
            println("trying for exclusive lock...");
            FileLock lock = fc.lock(INDEX_START, INDEX_SIZE, false);
            updateIndex(fc);
            lock.release();
            println("<sleeping>");
            Thread.sleep(random.nextInt(2000) + 500);
        }
    }

    private int idxval = 1;

    private void updateIndex(FileChannel fc) throws InterruptedException, IOException {
        indexBUffer.clear();
        for (int i = 0; i < INDEX_COUNT; i++) {
            idxval++;
            println("updating index " + i + "=" + idxval);
            indexBUffer.put(idxval);
            Thread.sleep(500);
        }
        buffer.clear();
        fc.write(buffer, INDEX_START);
    }

    private int lastLineLen = 0;

    private void println(String msg) {
        System.out.print("\r");
        System.out.print(msg);
        for (int i = msg.length(); i < lastLineLen ; i++) {
            System.out.printf(" ");
        }
        System.out.printf("\r");
        System.out.flush();
        lastLineLen = msg.length();
    }
}
