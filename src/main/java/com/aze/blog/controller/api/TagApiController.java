package com.aze.blog.controller.api;
import	java.awt.Desktop.Action;

import com.aze.blog.common.Result;
import com.aze.blog.dao.TagMapper;
import com.aze.blog.model.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("/insert")
    public Result insert(@RequestBody Tag tag){
        return Result.successData(tagMapper.insert(tag));
    }
}
