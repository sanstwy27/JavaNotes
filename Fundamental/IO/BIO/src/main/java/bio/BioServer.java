package bio;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author Sanstwy27
 * @create 9/16/2020
 * @ref  https://gitee.com/liner123/netty-project/blob/master/src/main/java/com/athl/netty/bio/BioServer.java
 */

public class BioServer {
    public static void main(String[] args) throws IOException {
        ThreadPoolExecutor executorService = new ThreadPoolExecutor(10, 20, 30L, TimeUnit.SECONDS,
                new LinkedBlockingQueue<>(50), Executors.defaultThreadFactory(), new ThreadPoolExecutor.AbortPolicy());
        ServerSocket serverSocket = new ServerSocket(6666);
        while (true) {
            System.out.println(Thread.currentThread().getId() + ":main:" + Thread.currentThread().getName());
            Socket socket = serverSocket.accept();
            executorService.execute(new Runnable() {
                @Override
                public void run() {
                    handler(socket);
                }
            });
        }
    }

    public static void handler(Socket socket) {
        InputStream inputStream = null;
        try {
            System.out.println(Thread.currentThread().getId() + ":handler:" + Thread.currentThread().getName());
            inputStream = socket.getInputStream();
            byte[] bytes = new byte[1024];
            while (true) {
                int read = inputStream.read(bytes);
                if (read != -1) {
                    System.out.println(new String(bytes, 0, read));
                } else {
                    break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                inputStream.close();
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
