package com.aze.blog.controller.api;

import java.nio.file.Path;
import java.util.List;
import java.util.Map;

import com.aze.blog.common.Result;
import com.aze.blog.dao.BlogMapper;
import com.aze.blog.model.Blog;
import com.aze.blog.service.BlogService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
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
    @Autowired
    BlogService blogService;

    /**
     * @description: 查询所有
     * @author: Aze
     * @time: 2019/10/29 15:11
     * @return:
     */
    @GetMapping("/list")
    public Result listAll() {
        return Result.successData(blogMapper.selectList(null));
    }

    /**
     * @description: 查询置顶博客
     * @author: Aze
     * @time: 2019/11/11 14:05
     * @return:
     */
    @GetMapping("/select-by-stick" )
    public Result selectByIsStick(){
        return Result.successData(blogService.selectByIsStick());
    }

    @GetMapping("/getById/{blogId}")
    public Result getById(@PathVariable String blogId) {
        return Result.successData(blogMapper.selectById(blogId));
    }


}
