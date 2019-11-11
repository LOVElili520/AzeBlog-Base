package com.aze.blog.service.impl;

import com.aze.blog.dao.BlogMapper;
import com.aze.blog.model.Blog;
import com.aze.blog.service.BlogService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author ：Aze
 * @description：博客Service
 * @date ：Created in 2019/10/29 14:16
 * @modified By：
 * @version:
 */
@Service
public class BlogServiceImpl implements BlogService {
    @Autowired
    BlogMapper blogMapper;


    /**
     * @description: 查询置顶博客
     * @author: Aze
     * @time: 2019/11/11 14:44
     * @return:
     */
    @Override
    public List<Blog> selectByIsStick() {
        QueryWrapper<Blog> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("is_stick",1).orderByDesc("weight_num");
        //总页数+总记录数
        Page<Blog> page = new Page<>(1, 6 ,false);
        //不返回总记录数 设置false
        //IPage<Map<String, Object>> iPage = blogMapper.selectMapsPage(page, queryWrapper);
        List<Blog> list = blogMapper.selectPage(page,queryWrapper).getRecords();
        return list;
    }

    /**
     * @description: 置顶博客
     * @author: Aze
     * @time: 2019/11/11 16:29
     * @return:
     */
    @Override
    public void stickBlog(String id) {
        //查询出权重最高的博客。之后在其权重中加一，设置为需要置顶的博客的权重
        int weightNum=1;

        Blog blog = blogMapper.selectById(id);
        QueryWrapper<Blog> queryWrapper = new QueryWrapper<>();
        //使用last查询出
        queryWrapper.orderByDesc("weight_num").last("limit 1");
        Blog topBlog= blogMapper.selectOne(queryWrapper);
        if (topBlog != null){
            weightNum= topBlog.getWeightNum()+1 ;
        }

        blog.setWeightNum(weightNum);
        blog.setIsStick(true);
        blogMapper.updateById(blog);
    }
}
