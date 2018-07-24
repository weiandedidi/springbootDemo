package com.qidi.bootdemo.web.controller;

import com.qidi.bootdemo.web.exception.MyException;
import com.qidi.bootdemo.model.Person;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

/**
 * Created with IntelliJ IDEA.
 * jspdemo
 * User: qidi
 * Date: 2018/7/18
 * Time: 下午5:49
 */
@Controller
public class LoginController {
    @PostMapping("/dologin")
    public String login(@RequestParam("username")String username, @RequestParam("password")String password, HttpSession session){
        if("miaozhihao".equals(username)&&"123456".equals(password)){
            session.setAttribute("user",username);
            return "success";
        }
        if ("qidi".equals(username)){
            throw new MyException();
        }

//        return "fail";
        return "rediret:/login";
    }

    @GetMapping("/login")
    public String loginIndex(Model model){
        model.addAttribute("username", "miaozhihao");
        return "login";
        //使用mvc的重定向
//        return "redirect:/admin";

    }

    @GetMapping("/admin")
    public String admin(Model model){
        model.addAttribute("admin", "miaozhihaoer");
        return "admin/index";
    }

    @PutMapping("/person")
    @ResponseBody
    public String updatePerson(Person person){
        //put是put方式
        return "成功";
    }

    @GetMapping("/person")
    public String infoPerson(Person person){
        //put是put方式
        return "info";
    }
}
