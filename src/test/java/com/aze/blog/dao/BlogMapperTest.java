package com.aze.blog.dao;
import java.util.Date;
import	java.util.List;

import com.aze.blog.model.Blog;
import com.aze.blog.model.Tag;
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
}