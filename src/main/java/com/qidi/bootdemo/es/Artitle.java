package com.qidi.bootdemo.es;

/**
 * 操作ES有两种方式
 * 1. jest 客户端
 * 2.  spring-data的elasticsearch
 * 如果版本不适配：
 * 1。升级springboot
 * 2。换es的版本
 * User: qidi
 * Date: 2018/8/17
 * Time: 下午1:42
 */
public class Artitle {
//    @JestId
    private Integer id;
    private String author;
    private String title;
    private String content;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
