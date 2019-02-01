package com.github.giraffetree.basic.io.nio;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

/**
 * @author: GiraffeTree
 * @date: 2018/11/12 0012
 */
public class NioClient {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("127.0.0.1", 8888);
        OutputStream out = socket.getOutputStream();
        String s = "hello world";
        out.write(s.getBytes());
        out.close();
    }
}
