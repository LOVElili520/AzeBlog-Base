package com.aze.blog.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.util.Date;

/**
 * @author ：Aze
 * @description：博客模型
 * @date ：Created in 2019/10/29 14:11
 * @modified By：
 * @version:
 */
@Data
public class Blog {
    @TableId(value = "id", type = IdType.ID_WORKER_STR)
    private String id;

    private String title;

    private String userId;

    private Date createTime;

    //描述
    private String blogDescribe;

    //标签
    private String tagName;

    private String content;

    //封面地址
    private String imageUrl;

    //是否置顶
    private Boolean isStick;

    //权重大小
    private int weightNum;

}
