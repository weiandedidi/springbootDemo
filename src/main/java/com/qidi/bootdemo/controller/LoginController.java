package com.qidi.bootdemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created with IntelliJ IDEA.
 * jspdemo
 * User: qidi
 * Date: 2018/7/18
 * Time: 下午5:49
 */
@Controller
public class LoginController {
    @PostMapping("/login")
    public String login(@RequestParam("username")String username, @RequestParam("password")String password){
        if("miaozhihao".equals(username)&&"123456".equals(password)){
            return "success";
        }

        return "fail";
    }

    @GetMapping("/login")
    public String loginIndex(Model model){
        model.addAttribute("username", "miaozhihao");
        return "login";
    }

    @GetMapping("/admin")
    public String admin(Model model){
        model.addAttribute("admin", "miaozhihaoer");
        return "admin/index";
    }
}
