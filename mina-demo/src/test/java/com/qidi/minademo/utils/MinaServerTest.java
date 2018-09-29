package com.qidi.minademo.utils;

import com.qidi.minademo.service.Handler;
import org.apache.mina.core.filterchain.DefaultIoFilterChainBuilder;
import org.apache.mina.core.service.IoAcceptor;
import org.apache.mina.filter.codec.ProtocolCodecFilter;
import org.apache.mina.filter.codec.textline.TextLineCodecFactory;
import org.apache.mina.transport.socket.nio.NioSocketAcceptor;

import java.io.IOException;
import java.net.InetSocketAddress;

/**
 * Created with IntelliJ IDEA.
 * User: qidi
 * Date: 2018/9/7
 * Time: 下午4:43
 */

public class MinaServerTest {
    private static final int PORT = 22222;// 定义监听端口

    public static void main(String[] args) throws IOException {
        //创建一个非阻塞的Server端socket，用NIO
        IoAcceptor acceptor = new NioSocketAcceptor();
        //创建接受数据的过滤器
        DefaultIoFilterChainBuilder chain = acceptor.getFilterChain();
        //设定这个过滤器将一行一行的读取数据
        chain.addLast("codec", new ProtocolCodecFilter(new TextLineCodecFactory()));// 指定编码过滤器
        // 指定业务逻辑处理器
        acceptor.setHandler(new Handler());
        // 设置端口号
        acceptor.setDefaultLocalAddress(new InetSocketAddress(PORT));
        acceptor.bind(); //启动监听
        System.out.println("Mina Server is Listen on:" + PORT);
    }
}