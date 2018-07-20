package com.qidi.bootdemo.model;

/**
 * Created with IntelliJ IDEA.
 * User: qidi
 * Date: 2018/7/20
 * Time: 上午10:41
 */
public class Department {
    /**
     * 部门名字
     */
    private String name;
    /**
     * 部门no
     */
    private Integer departNo;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getDepartNo() {
        return departNo;
    }

    public void setDepartNo(Integer departNo) {
        this.departNo = departNo;
    }
}
