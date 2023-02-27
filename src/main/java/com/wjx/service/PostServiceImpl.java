package com.wjx.service;

import com.wjx.dao.PostMapper;
import com.wjx.pojo.Post;
import com.wjx.pojo.User;

import java.util.List;

public class PostServiceImpl implements PostService{
    private PostMapper psotMapper;

    @Override
    public Post getPostById(int id) {
        return psotMapper.getPostById(id);
    }

    @Override
    public Post getPostByTitle(String title) {
        return psotMapper.getPostByTitle(title);
    }

    @Override
    public List<Post> getPostAllByUser(User user) {
        return psotMapper.getPostAllByUser(user);
    }

    @Override
    public int addPost(Post post) {
        return psotMapper.addPost(post);
    }

    @Override
    public int deletePost(int id) {
        return psotMapper.deletePost(id);
    }

    @Override
    public int updatePost(Post post) {
        return psotMapper.updatePost(post);
    }

    @Override
    public List<Post> queryAllPost() {
        return psotMapper.queryAllPost();
    }

    @Override
    public List<Post> queryThreePost() {
        return psotMapper.queryThreePost();
    }

    public void setPsotMapper(PostMapper psotMapper) {
        this.psotMapper = psotMapper;
    }
}
