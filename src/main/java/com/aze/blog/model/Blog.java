package com.aze.blog.model;
import lombok.Data;

import	java.util.Date;

/**
 * @author ：Aze
 * @description：博客模型
 * @date ：Created in 2019/10/29 14:11
 * @modified By：
 * @version:
 */
@Data
public class Blog {

    private  Long id;

    private String title;

    private String userId;

    private Date createTime;

    //描述
    private  String blogDescribe;

    //标签
    private String tagName;

    private  String content;

}
