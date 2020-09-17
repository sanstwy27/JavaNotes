package com.sanstwy27.nio.local;

import org.junit.Test;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.CharacterCodingException;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CharsetEncoder;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Map;
import java.util.Set;

/**
 * @author Sanstwy27
 * @create 9/14/2020
 */

/**
 * 1. java.nio.channels.Channel
 *    |--FileChannel
 *    |--SocketChannel
 *    |--ServerSocketChannel
 *    |--DatagramChannel
 *
 * 2. getChannel
 *   (1). getChannel()
 *     LocalIO:
 *       FileInputStream/FileOutputStream
 *       RandomAccessFile
 *     NetworkIO
 *       Socket
 *       ServerSocket
 *       DatagramSocket
 *  (2). NIO.2 open()
 *  (3). NIO.2 newByteChannel()
 *
 * 3. transferFrom(), transferTo()
 *
 * 4. Scatter and Gather
 *   Scattering Reads, Gathering Writes
 *
 * 5.
 *   Charset
 *
 */
public class TestChannel {

    /**
     * non-direct buffer copy
     */
    @Test
    public void test1() {
        long start = System.currentTimeMillis();

        FileInputStream fis = null;
        FileOutputStream fos = null;

        FileChannel inChannel = null;
        FileChannel outChannel = null;
        try {
            fis = new FileInputStream("E:/1.mp4");
            fos = new FileOutputStream("E:/2.mp4");

            // 1. get channels
            inChannel = fis.getChannel();
            outChannel = fos.getChannel();

            // 2. allocate
            ByteBuffer buf = ByteBuffer.allocate(1024);

            // 3. operate buffer with channel
            while (inChannel.read(buf) != -1) {
                // read mode
                buf.flip();
                // 4. write to buffer
                outChannel.write(buf);
                buf.clear();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (outChannel != null) {
                try {
                    outChannel.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (inChannel != null) {
                try {
                    inChannel.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (fos != null) {
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (fis != null) {
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        long end = System.currentTimeMillis();
        System.out.println("time：" + (end - start));
        /**
         * time：6197
         */
    }

    /**
     * direct buffer copy (get, put)
     */
    @Test
    public void test2() {
        long start = System.currentTimeMillis();

        FileChannel inChannel = null;
        FileChannel outChannel = null;
        try {
            inChannel = FileChannel.open(Paths.get("E:/1.mp4"), StandardOpenOption.READ);
            outChannel = FileChannel.open(Paths.get("E:/2.mp4"), StandardOpenOption.WRITE, StandardOpenOption.READ, StandardOpenOption.CREATE);

            // mapping buffer
            MappedByteBuffer inMappedBuf = inChannel.map(FileChannel.MapMode.READ_ONLY, 0, inChannel.size());
            MappedByteBuffer outMappedBuf = outChannel.map(FileChannel.MapMode.READ_WRITE, 0, inChannel.size());

            // operate direct buffer
            byte[] dst = new byte[inMappedBuf.limit()];
            inMappedBuf.get(dst);
            outMappedBuf.put(dst);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (outChannel != null) {
                try {
                    outChannel.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (inChannel != null) {
                try {
                    inChannel.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        long end = System.currentTimeMillis();
        System.out.println("time：" + (end - start));
        /**
         * time：842
         */
    }

    /**
     * direct buffer copy (transferTo, transferFrom)
     *
     *
     */
    @Test
    public void test3() {
        long start = System.currentTimeMillis();

        FileChannel inChannel = null;
        FileChannel outChannel = null;
        try {
            inChannel = FileChannel.open(Paths.get("E:/1.mp4"), StandardOpenOption.READ);
            outChannel = FileChannel.open(Paths.get("E:/2.mp4"), StandardOpenOption.WRITE, StandardOpenOption.READ, StandardOpenOption.CREATE);

            inChannel.transferTo(0, inChannel.size(), outChannel);
            outChannel.transferFrom(inChannel, 0, inChannel.size());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (outChannel != null) {
                try {
                    outChannel.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (inChannel != null) {
                try {
                    inChannel.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        long end = System.currentTimeMillis();
        System.out.println("time：" + (end - start));
        /**
         * time：609
         */
    }

    /**
     * Scatter and Gather
     */
    @Test
    public void test4() {
        RandomAccessFile raf1 = null;
        FileChannel channel1 = null;
        RandomAccessFile raf2 = null;
        FileChannel channel2 = null;
        try {
            raf1 = new RandomAccessFile("E:/1.txt", "rw");

            // 1. get channel
            channel1 = raf1.getChannel();

            // 2. allocate
            ByteBuffer buf1 = ByteBuffer.allocate(100);
            ByteBuffer buf2 = ByteBuffer.allocate(1024);

            // 3. Scatter
            ByteBuffer[] bufs = {buf1, buf2};
            channel1.read(bufs);

            for (ByteBuffer byteBuffer : bufs) {
                byteBuffer.flip();
            }
            System.out.println(new String(bufs[0].array(), 0, bufs[0].limit()));
            System.out.println("--------------------");
            System.out.println(new String(bufs[1].array(), 0, bufs[1].limit()));

            // 4. Gather
            raf2 = new RandomAccessFile("E:/2.txt", "rw");
            channel2 = raf2.getChannel();
            channel2.write(bufs);
            /**
             * Hello, World!
             *
             * a1234567890
             * b1234567890
             * c1234567890
             * d1234567890
             * e1234567890
             * f1234567890
             * g1234
             * --------------------
             * 567890
             * h1234567890
             * i1234567890
             * j1234567890
             * k1234567890
             */
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (channel2 != null) {
                try {
                    channel2.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (channel1 != null) {
                try {
                    channel1.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (raf2 != null) {
                try {
                    raf2.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (raf1 != null) {
                try {
                    raf1.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * available Charsets
     */
    @Test
    public void test5() {
        Map<String, Charset> map = Charset.availableCharsets();
        Set<Map.Entry<String, Charset>> set = map.entrySet();

        for (Map.Entry<String, Charset> entry : set) {
            System.out.println(entry.getKey() + "=" + entry.getValue());
        }
        /**
         * Big5=Big5
         * Big5-HKSCS=Big5-HKSCS
         * CESU-8=CESU-8
         * EUC-JP=EUC-JP
         * EUC-KR=EUC-KR
         * GB18030=GB18030
         * GB2312=GB2312
         * GBK=GBK
         * IBM-Thai=IBM-Thai
         * IBM00858=IBM00858
         * IBM01140=IBM01140
         * IBM01141=IBM01141
         * IBM01142=IBM01142
         * IBM01143=IBM01143
         * IBM01144=IBM01144
         * IBM01145=IBM01145
         * IBM01146=IBM01146
         * IBM01147=IBM01147
         * IBM01148=IBM01148
         * IBM01149=IBM01149
         * ...
         */
    }

    /**
     * Charset Encoder and Decoder
     */
    @Test
    public void test6(){
        Charset cs1 = Charset.forName("UTF-8");

        CharsetEncoder ce = cs1.newEncoder();
        CharsetDecoder cd = cs1.newDecoder();

        CharBuffer cBuf = CharBuffer.allocate(1024);
        cBuf.put("一二三四五六七八九十");
        cBuf.flip();

        // encode
        ByteBuffer bBuf = null;
        try {
            bBuf = ce.encode(cBuf);
        } catch (CharacterCodingException e) {
            e.printStackTrace();
        }

        for (int i = 0; i < 12; i++) {
            System.out.println(bBuf.get());
        }

        // decode
        bBuf.flip();
        CharBuffer cBuf2 = null;
        try {
            cBuf2 = cd.decode(bBuf);
        } catch (CharacterCodingException e) {
            e.printStackTrace();
        }
        System.out.println(cBuf2.toString());

        /**
         * -28
         * -72
         * -128
         * -28
         * -70
         * -116
         * -28
         * -72
         * -119
         * -27
         * -101
         * -101
         * 一二三四
         *
         */
    }
}
