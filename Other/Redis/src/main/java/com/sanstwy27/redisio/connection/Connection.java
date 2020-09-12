package com.sanstwy27.redisio.connection;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

/**
 * @author Sanstwy27
 * @create 9/11/2020
 */

public class Connection {
    private String host;
    private int port;
    private Socket socket;
    private InputStream inputStream;
    private OutputStream outputStream;

    public Connection(String host, int port) {
        this.host = host;
        this.port = port;

        try {
            this.socket = new Socket(host, port);
            this.inputStream = socket.getInputStream();
            this.outputStream = socket.getOutputStream();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public boolean isConnection() {
        if(socket != null && !socket.isClosed() && socket.isBound() && socket.isConnected()) {
            return true;
        }
        return false;
    }

    public String sendCommand(byte[] command) {
        if(isConnection()) {
            try {
                outputStream.write(command);
                int length = 0;
                byte[] res = new byte[1024];
                while((length = inputStream.read(res)) > 0) {
                    return new String(res, 0, length);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return null;
    }
}
