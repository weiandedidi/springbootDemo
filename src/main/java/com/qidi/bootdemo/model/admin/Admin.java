package com.qidi.bootdemo.model.admin;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

/**
 * 变异后出现get和set方法
 * User: qidi
 * Date: 2018/8/1
 * Time: 上午10:35
 */
@Data
@Getter
@Setter
@NoArgsConstructor
@Accessors(chain=true)  //链式引用

public class Admin {
    private Integer id;
    private String name;
    private String datasource;


/*    public static void main(String[] args) {
        Admin admin = new Admin().setDatasource("adf").setId(3).setName("wu");
    }*/

}
