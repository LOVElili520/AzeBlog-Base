package com.aze.blog.model;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

/**
 * @author ：Aze
 * @description：博客标签
 * @date ：Created in 2019/10/29 17:36
 * @modified By：
 * @version:
 */
@Data
public class Tag {

    @TableId(value = "id",type = IdType.ID_WORKER_STR)
    private String id;

    private String tagName;
}
