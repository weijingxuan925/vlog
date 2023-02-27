package com.wjx.controller;

import com.wjx.pojo.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class IndexController {

    @Autowired
    @Qualifier("PostServiceImpl")
    private com.wjx.service.PostService PostService;

    @RequestMapping("/")
    public String index(Model model,HttpServletRequest request){
        System.out.println("进入了index控制器");
        //随机获取三篇博客放到首页
        List<Post> PostList = PostService.queryThreePost();
        model.addAttribute("PostList",PostList);
        //改善图片路径
        for (Post post : PostList){
            String imagePath = post.getPostThumbnail();
            String imageName = imagePath.substring(imagePath.lastIndexOf("/") + 1);
            post.setPostThumbnail(imageName);
        }
        return "forward:/index.jsp";
    }
}
