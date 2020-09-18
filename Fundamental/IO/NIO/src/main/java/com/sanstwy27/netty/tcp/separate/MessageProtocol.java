package com.sanstwy27.netty.tcp.separate;

/**
 * @author Sanstwy27
 * @create 9/18/2020
 */

public class MessageProtocol {
    private int len;
    private byte[] content;

    public int getLen() {
        return len;
    }

    public void setLen(int len) {
        this.len = len;
    }

    public byte[] getContent() {
        return content;
    }

    public void setContent(byte[] content) {
        this.content = content;
    }
}
