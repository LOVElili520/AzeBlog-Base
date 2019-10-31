package com.aze.blog.controller.api;
import	java.awt.Desktop.Action;

import com.aze.blog.common.Result;
import com.aze.blog.dao.TagMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ：Aze
 * @description：
 * @date ：Created in 2019/10/29 17:40
 * @modified By：
 * @version:
 */
@RestController
@RequestMapping("/api/tag")
public class TagApiController {
    @Autowired
    TagMapper  tagMapper;

    @GetMapping("/list")
    public Result list(){
        return Result.successData(tagMapper.selectList(null));
    }
}
