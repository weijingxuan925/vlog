package com.wjx.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Post {
    /**
     * id
     */
    private int id;
    /**
     * 正文
     */
    private String postContent;
    /**
     * 状态
     */
    private String postStatus;
    /**
     * 概况
     */
    private String postSummary;
    /**
     * 封面
     */
    private String postThumbnail;
    /**
     * 标题
     */
    private String postTitle;
    /**
     * 访问量
     */
    private String postViews;
    /**
     * 创建时间
     */
    private Date createTime;
    /**
     * 文章所有者
     */
    private String articleOwner;
}
