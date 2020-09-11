package com.sanstwy27.redisio.protocol;

/**
 * @author Sanstwy27
 * @create 9/11/2020
 */

public class Protocol {
    public static final String DOLLER = "$";
    public static final String ALLERTSTIC = "*";
    public static final String CRLF = "\r\n";

    // *3\r\n
    // $3\r\n
    // SET\r\n
    // $3\r\n
    // ant\r\n
    // $3\r\n
    // 777\r\n
    public static byte[] buildRespByte(Command command, byte[]... bytes) {
        StringBuilder sb = new StringBuilder();
        // bytes.length + 1 = command + parameters
        sb.append(ALLERTSTIC).append(bytes.length + 1).append(CRLF);
        sb.append(DOLLER).append(command.name().length()).append(CRLF);
        sb.append(command.name()).append(CRLF);
        for(byte[] arg : bytes) {
            sb.append(DOLLER).append(arg.length).append(CRLF);
            sb.append(new String(arg)).append(CRLF);
        }
        return sb.toString().getBytes();
    }

    public enum Command {
        SET, GET
    }
}
