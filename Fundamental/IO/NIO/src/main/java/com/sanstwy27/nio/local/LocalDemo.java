package com.sanstwy27.nio.local;

import org.junit.Test;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @author Sanstwy27
 * @create 9/14/2020
 */

/**
 * 1. Buffer (by allocate()):
 *    ByteBuffer
 *    CharBuffer
 *    ShortBuffer
 *    IntBuffer
 *    LongBuffer
 *    FloatBuffer
 *    DoubleBuffer
 *
 * 2. method: put(), get()
 *
 * 3. attributes：
 *    capacity : A buffer's capacity is the number of elements it contains. The capacity of a buffer is never negative and never changes.
 *    limit : A buffer's limit is the index of the first element that should not be read or written. A buffer's limit is never negative and is never greater than its capacity.
 *    position : A buffer's position is the index of the next element to be read or written. A buffer's position is never negative and is never greater than its limit.
 *    mark : A buffer's mark is the index to which its position will be reset when the reset method is invoked. The mark is not always defined, but when it is defined it is never negative and is never greater than the position. If the mark is defined then it is discarded when the position or the limit is adjusted to a value smaller than the mark. If the mark is not defined then invoking the reset method causes an InvalidMarkException to be thrown.
 *
 *    0 <= mark <= position <= limit <= capacity
 *
 * 4. allocate() and allocateDirect()
 *    A byte buffer is either direct or non-direct. Given a direct byte buffer, the Java virtual machine will make a best effort to perform native I/O operations directly upon it. That is, it will attempt to avoid copying the buffer's content to (or from) an intermediate buffer before (or after) each invocation of one of the underlying operating system's native I/O operations.
 */
public class LocalDemo {

    @Test
    public void test1() {
        String str = "abcde";

        // 1. allocate()
        ByteBuffer buf = ByteBuffer.allocate(1024);

        System.out.println("-----------------allocate()----------------");
        System.out.println(buf.position());
        System.out.println(buf.limit());
        System.out.println(buf.capacity());

        // 2. put()
        buf.put(str.getBytes());

        System.out.println("-----------------put()----------------");
        System.out.println(buf.position());
        System.out.println(buf.limit());
        System.out.println(buf.capacity());

        // 3. The flip() method switches a Buffer from writing mode to reading mode.
        buf.flip();

        System.out.println("-----------------flip()----------------");
        System.out.println(buf.position());
        System.out.println(buf.limit());
        System.out.println(buf.capacity());

        // 4. get() This method transfers bytes from this buffer into the given destination array.
        byte[] dst = new byte[buf.limit()];
        buf.get(dst);
        System.out.println(new String(dst, 0, dst.length));

        System.out.println("-----------------get()----------------");
        System.out.println(buf.position());
        System.out.println(buf.limit());
        System.out.println(buf.capacity());

        // 5. rewind() : set the position back to 0, so you can reread all the data in the buffer.
        buf.rewind();

        System.out.println("-----------------rewind()----------------");
        System.out.println(buf.position());
        System.out.println(buf.limit());
        System.out.println(buf.capacity());

        // 6. clear() : The position is set to zero, the limit is set to the capacity, and the mark is discarded.
        buf.clear();

        System.out.println("-----------------clear()----------------");
        System.out.println(buf.position());
        System.out.println(buf.limit());
        System.out.println(buf.capacity());

        System.out.println((char) buf.get());

        /**
         * -----------------allocate()----------------
         * 0
         * 1024
         * 1024
         * -----------------put()----------------
         * 5
         * 1024
         * 1024
         * -----------------flip()----------------
         * 0
         * 5
         * 1024
         * abcde
         * -----------------get()----------------
         * 5
         * 5
         * 1024
         * -----------------rewind()----------------
         * 0
         * 5
         * 1024
         * -----------------clear()----------------
         * 0
         * 1024
         * 1024
         * a
         */
    }

    @Test
    public void test2() {
        String str = "abcde";

        ByteBuffer buf = ByteBuffer.allocate(1024);

        buf.put(str.getBytes());

        buf.flip();

        byte[] dst = new byte[buf.limit()];
        buf.get(dst, 0, 2);
        System.out.println(new String(dst, 0, 2));
        System.out.println(buf.position());

        // mark()
        buf.mark();

        buf.get(dst, 2, 2);
        System.out.println(new String(dst, 2, 2));
        System.out.println(buf.position());

        // reset()
        buf.reset();
        System.out.println(buf.position());

        if (buf.hasRemaining()) {
            System.out.println(buf.remaining());
        }

        /**
         * ab
         * 2
         * cd
         * 4
         * 2
         * 3
         */
    }

    @Test
    public void test3() {
        ByteBuffer buffer = ByteBuffer.allocate(64);

        buffer.putInt(100);
        buffer.putLong(9);
        buffer.putChar('尚');
        buffer.putShort((short) 4);

        buffer.flip();

        System.out.println();
        System.out.println(buffer.getInt());
        System.out.println(buffer.getLong());
        System.out.println(buffer.getChar());
        System.out.println(buffer.getShort());
        /**
         * 100
         * 9
         * 尚
         * 4
         */
    }

    @Test
    public void test4() {
        ByteBuffer buf = ByteBuffer.allocateDirect(1024);
        System.out.println(buf.isDirect());
        /**
         * true
         */
    }
    
    @Test
    public void test5() throws IOException {
        RandomAccessFile randomAccessFile = new RandomAccessFile("E:/1.txt", "rw");
        FileChannel channel = randomAccessFile.getChannel();
        // A direct byte buffer whose content is a memory-mapped region of a file.
        // release by FullGC or sun.misc.Cleaner
        MappedByteBuffer mappedByteBuffer = channel.map(FileChannel.MapMode.READ_WRITE, 0, 5);

        mappedByteBuffer.put(0, (byte) 'H');
        mappedByteBuffer.put(3, (byte) '9');
        //mappedByteBuffer.put(5, (byte) 'Y'); //IndexOutOfBoundsException

        randomAccessFile.close();
        System.out.println("success!");
    }
}
