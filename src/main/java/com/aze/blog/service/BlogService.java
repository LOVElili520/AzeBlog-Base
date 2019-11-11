package com.aze.blog.service;

import com.aze.blog.model.Blog;

import javax.validation.constraints.Min;
import java.util.List;

public interface BlogService {

    /**
     * @description: 获取置顶博客
     * @author: Aze
     * @time: 2019/11/11 14:48
     * @return:
     */
    List<Blog> selectByIsStick();

    /**
     * @description: 置顶博客
     * @author: Aze
     * @time: 2019/11/11 16:29
     * @return:
     */
    void stickBlog(String id);

}
