package com.wjx.service;

import com.wjx.pojo.Post;
import com.wjx.pojo.User;

import java.util.List;

public interface PostService {
    //通过id获取文章
    Post getPostById(int id);
    //通过标题获取文章
    Post getPostByTitle(String title);
    //获取指定用户的所有文章
    List<Post> getPostAllByUser(User user);
    //添加文章
    int addPost(Post post);
    //删除文章
    int deletePost(int id);
    //修改文章
    int updatePost(Post post);
    //查询所有文章
    List<Post> queryAllPost();
}
