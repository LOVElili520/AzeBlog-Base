package com.aze.blog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author ：Aze
 * @description：
 * @date ：Created in 2019/10/25 18:20
 * @modified By：
 * @version:
 */
@Controller
public class TestController {

    @ResponseBody
    @RequestMapping("/hello")
    public String hello(){
        return  "hello world";
    }


}
