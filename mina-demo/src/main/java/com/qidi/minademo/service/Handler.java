package com.qidi.minademo.service;

import org.apache.mina.core.service.IoHandlerAdapter;
import org.apache.mina.core.session.IdleStatus;
import org.apache.mina.core.session.IoSession;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: qidi
 * Date: 2018/9/7
 * Time: 下午4:48
 */
public class Handler extends IoHandlerAdapter {
    @Override
    public void sessionOpened(IoSession session) throws Exception {
        System.out.println("incoming client:" + session.getRemoteAddress());
        super.sessionOpened(session);
    }

    //当客户端发送消息到达时
    @Override
    public void messageReceived(IoSession session, Object message) throws Exception {
        String s = message.toString();
        String[] infos = s.split(",");
        String sn = infos[1].trim();

        System.out.println("client send message is:" + s);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd mm:hh:ss");
        Date date = new Date();
//        session.write(sdf.format(date));// 返回当前时间的字符串
        session.write(sn);   //返回sn
        System.out.println("message written...");
    }

    //当一个客户端连接关闭时
    @Override
    public void sessionClosed(IoSession session) throws Exception {
        System.out.println("one client closed");
    }

    //发送消息时候
    @Override
    public void messageSent(IoSession session, Object message) throws Exception {
        super.messageSent(session, message);
    }

    //穿件session
    @Override
    public void sessionCreated(IoSession session) throws Exception {
        super.sessionCreated(session);
    }


    @Override
    public void sessionIdle(IoSession session, IdleStatus status) throws Exception {
        super.sessionIdle(session, status);
    }
}
