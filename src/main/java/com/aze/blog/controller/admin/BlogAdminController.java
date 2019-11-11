package com.aze.blog.controller.admin;

import com.aze.blog.common.Result;
import com.aze.blog.dao.BlogMapper;
import com.aze.blog.model.Blog;
import com.aze.blog.service.BlogService;
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
@RequestMapping("/admin/blog")
public class BlogAdminController {
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

    @PostMapping("/insert")
    public Result insertBlog(@RequestBody Blog blog) {
        return Result.successData(blogMapper.insert(blog));
    }

    /**
     * @description: 博客置顶
     * @author: Aze
     * @time: 2019/11/11 16:27
     * @return:
     */
    @PostMapping("/stickBlog/{id}")
    public Result stickBlog(@PathVariable String id) {
        blogService.stickBlog(id);
        return Result.success();
    }

}
