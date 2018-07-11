package cn.choleece.nios;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.nio.channels.GatheringByteChannel;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

/**
 * Created by choleece on 2018/7/8.
 */
public class Marketing {
    private static String[] col1 = {
            "Aggregate", "Enable", "Leverage",
            "Facilitate", "Synergize", "Repurpose",
            "Stratefize", "Reinvent", "Harness"
    };

    private static String[] col2 = {
            "cross-platform", "best-of breed", "frictionless",
            "ubiquitous", "extensible", "compelling",
            "mission-critical", "collaborative", "integrated"
    };

    private static String[] cols = {
            "methodologies", "infomediaries", "platforms",
            "schemas", "mindshare", "paradigms",
            "functionalities", "web services", "infrastructires"
    };

    private static String newLine = System.getProperty("line.separator");

    private static ByteBuffer[] utterBS(int howMany) throws UnsupportedEncodingException {
        List list = new LinkedList();

        for (int i = 0; i < howMany; i++) {
            list.add(pickRandom(col1, " "));
            list.add(pickRandom(col2, " "));
            list.add(pickRandom(cols, " "));
        }

        ByteBuffer[] buffers = new ByteBuffer[list.size()];
        list.toArray(buffers);
        return (buffers);
    }

    private static Random rand = new Random();

    private static ByteBuffer pickRandom(String[] strings, String suffix) throws UnsupportedEncodingException {
        String string = strings[rand.nextInt(strings.length)];
        int total = string.length() + suffix.length();
        ByteBuffer buf = ByteBuffer.allocate(total);
        buf.put(string.getBytes("US-ASCII"));
        buf.put(suffix.getBytes("US-ASCII"));
        buf.flip();
        return (buf);
    }

    private static final String DEMOGRAPHIC = "blahblah.txt";

    public static void main(String[] args) throws IOException {
        int reps = 9;
        if (args.length > 0) {
            reps = Integer.parseInt(args[0]);
        }
        FileOutputStream fos = new FileOutputStream(DEMOGRAPHIC);
        GatheringByteChannel gatheringByteChannel = fos.getChannel();
        ByteBuffer[] bs = utterBS(reps);

        while (gatheringByteChannel.write(bs) > 0) {
        }

        System.out.println("mindshare paradigms synergized to " + DEMOGRAPHIC);

        fos.close();
    }
}
