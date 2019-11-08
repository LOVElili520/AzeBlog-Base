package com.aze.blog.dao;
import java.util.Date;
import java.util.HashMap;
import	java.util.List;
import java.util.Map;

import com.aze.blog.model.Blog;
import com.aze.blog.model.Tag;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.catalina.User;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest
class BlogMapperTest {

    @Autowired
    BlogMapper blogMapper;
    @Autowired
    TagMapper tagMapper;

    @Test
    public  void insert(){
        Blog blog = new Blog();
        blog.setTitle("安妮宝贝");
        blog.setUserId("2");
        blog.setCreateTime(new Date());
        blogMapper.insert(blog);


    }

    @Test
    public  void insertTag(){
        Tag t = new Tag();
        t.setTagName("打工日记");
        tagMapper.insert(t);
    }


    @Test
    public  void select(){
        List <Blog> list = blogMapper.selectList(null);
        Assert.assertEquals(3,list.size());
        list.forEach(System.out::println);
    }

    /**
     * @description: 测试条件构造器
     * @author: Aze
     * @time: 2019/11/8 16:14
     * @return:
     */
    //查询 置顶博客
    @Test
    public void selectWrapper(){
        QueryWrapper<Blog> queryWrapper = new QueryWrapper<>();
        //QueryWrapper<Blog> queryWrapper = Wrapper.<Blog>query();
        // 前面的参数为数据库的列名   lt ： 小于
        queryWrapper.isNotNull("is_stick").orderByDesc("weight_num");
        /*模糊查询 like操作*/

        //总页数+总记录数
          Page<Blog> page = new Page<>(1, 2 ,false);

//      不返回总记录数 设置false
        IPage<Map<String, Object>> iPage = blogMapper.selectMapsPage(page, queryWrapper);
        List <Blog> list = blogMapper.selectPage(page,queryWrapper).getRecords();
        Blog blog = blogMapper.selectOne(queryWrapper);
        list.forEach(System.out::println);
    }

    /**
     * @description:
     * @author: Aze
     * @time: 2019/11/8 17:13
     * @return:
     */
    @Test
    public void selectByMap(){
        Map<String, Object> columnMap =new  HashMap<String ,Object>();
        columnMap.put("weight_num",6);
        /*模糊查询 like操作*/
        List <Blog> list = blogMapper.selectByMap(columnMap);
        list.forEach(System.out::println);
    }




}
