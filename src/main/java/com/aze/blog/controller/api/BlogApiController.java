package com.aze.blog.controller.api;
import	java.nio.file.Path;

import com.aze.blog.common.Result;
import com.aze.blog.dao.BlogMapper;
import com.aze.blog.model.Blog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author ：Aze
 * @description：前台api
 * @date ：Created in 2019/10/29 15:02
 * @modified By：
 * @version:
 */
@RestController
@RequestMapping("/api/blog")
public class BlogApiController {
    @Autowired
    BlogMapper blogMapper;

    /**
     * @description: 查询所有
     * @author: Aze
     * @time: 2019/10/29 15:11
     * @return:
     */
    @GetMapping("/list")
    public Result listAll(){
        return Result.successData(blogMapper.selectList(null));
    }

    @PostMapping("/insert")
    public Result insertBlog(@RequestBody Blog blog){
        return  Result.successData(blogMapper.insert(blog));
    }

}
