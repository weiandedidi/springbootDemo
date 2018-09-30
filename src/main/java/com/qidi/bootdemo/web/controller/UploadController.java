package com.qidi.bootdemo.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: qidi
 * Date: 2018/9/29
 * Time: 下午5:42
 */
@Controller
@RequestMapping("/caface")
public class UploadController {
    /**
     * 多文件上传form 表单形式提交
     * head
     * Content-Type: multipart/form-data; boundary=boundary
     * <p>
     * body
     * 1. name="face"; filename="faceinfo.json"
     * 2. name="faceImage"; filename="faceImage.jpg"
     *
     * @return
     * @CrossOrigin可实现跨域
     */
    @RequestMapping(value = "/add", method = RequestMethod.POST, consumes = "multipart/form-data")
    @ResponseBody
    @CrossOrigin
    public Map<String, Object> uploadFile(@RequestParam(name = "face") MultipartFile face, @RequestParam(name = "faceImage") MultipartFile faceImage) {
        System.out.println(face.getContentType());
        System.out.println(faceImage.getContentType());
        Map<String, Object> reslut = new HashMap<>();
        reslut.put("code", 0);
        reslut.put("msg", "success");
        return reslut;
    }

    @RequestMapping("/hi")
    @ResponseBody
    public String hi() {
        return "success";
    }
}
