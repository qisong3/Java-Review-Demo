package cn.errison.feature.demo.nio;

import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.Selector;

public class Demo1 {


    private static void buffer2String() {
        // Allocate a new non-direct byte buffer with a 50 byte capacity
        // set this to a big value to avoid BufferOverflowException
        CharBuffer buf = CharBuffer.allocate(50);

        System.out.println("before insert into buffer");
        System.out.println("capacity is " + buf.capacity());
        System.out.println("limit is " + buf.limit());
        System.out.println("position is " + buf.position() + "\n");

        // Write a string to char buffer
        buf.put("learn java from errison");

        System.out.println("after insert into buffer");
        System.out.println("capacity is " + buf.capacity());
        System.out.println("limit is " + buf.limit());
        System.out.println("position is " + buf.position() + "\n");

        // Flips this buffer. The limit is set to the current position and then
        // the position is set to zero. If the mark is defined then it is
        // discarded
        buf.flip();

        // Output again
        System.out.println("after flip ");
        System.out.println("capacity is " + buf.capacity());
        System.out.println("limit is " + buf.limit());
        System.out.println("position is " + buf.position() + "\n");

        String s = buf.toString(); // a string
        System.out.println(s);

    }

    public static void readWithChannel() {
        try {
            // random access a file
            RandomAccessFile aFile = new RandomAccessFile("test.txt", "r");

            // open a channel
            FileChannel inChannel = aFile.getChannel();
            long fileSize = inChannel.size();

            // create a buffer
            ByteBuffer buffer = ByteBuffer.allocate((int) fileSize);
            inChannel.read(buffer);
            buffer.flip();

            //Verify the file content
            for (int i = 0; i < fileSize; i++) {
                System.out.print((char) buffer.get());
            }

            inChannel.close();
            aFile.close();
        } catch (Exception exc) {
            System.out.println(exc);
            System.exit(1);
        }
    }


    public static void main(String[] args) {
        buffer2String();
        readWithChannel();
    }
}
