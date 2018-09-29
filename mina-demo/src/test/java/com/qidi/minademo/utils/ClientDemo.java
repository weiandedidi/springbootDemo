package com.qidi.minademo.utils;

import java.io.*;
import java.net.Socket;

/**
 * Created with IntelliJ IDEA.
 * User: qidi
 * Date: 2018/9/7
 * Time: 下午4:54
 */
public class ClientDemo {
    public static void main(String[] args) {
        //构建IO
        try {
            DataInputStream dataInputStream = null;
//            Socket socket = new Socket("103.37.152.146", 10010);
            Socket socket = new Socket("127.0.0.1", 22222);
            InputStream in = socket.getInputStream();
            OutputStream os = socket.getOutputStream();
            dataInputStream = new DataInputStream(socket.getInputStream());
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(os));
            //向服务器端发送一条消息json数据
            bw.write("65537,33098,0,1,0,1111111111,1,1,0,0\n");
            bw.flush();

            //读取服务器返回的消息
            byte[] body = new byte[2048];
            int length = dataInputStream.read(body);
            if (-1 == length) {
                System.out.println("读错了");
                return;
            }

            String message = new String(body, "utf-8");
            System.out.println("服务器：" + message);
            throw new NullPointerException();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
