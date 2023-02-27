package com.wjx.controller;

import com.wjx.pojo.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.ServletContext;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Controller
public class BlogViewController {
    @Autowired
    @Qualifier("PostServiceImpl")
    private com.wjx.service.PostService PostService;

    @RequestMapping("/blog")
    public String showBlog(Model model,String blogid) throws IOException {
        //获取博客id
        System.out.println(blogid);
        //根据博客id从数据库中查出对应文件路径
        Post post = PostService.getPostById(Integer.parseInt(blogid));
        String filePath = post.getPostContent();
        System.out.println("得出正文路径为:" + filePath);

        String imagePath = post.getPostThumbnail();
        String imageName = imagePath.substring(imagePath.lastIndexOf("/") + 1);
        System.out.println("得出图片名为：" + imageName);
        model.addAttribute("cover",imageName);

        String createTime = String.valueOf(post.getCreateTime());
        model.addAttribute("createTime",createTime);

        File file = new File(filePath);
        if (file.exists()) {
            BufferedReader br = new BufferedReader(new FileReader(file));
            String line;
            StringBuilder sb = new StringBuilder();
            while ((line = br.readLine()) != null) {
                sb.append(line);
            }
            model.addAttribute("content", sb.toString());
            return "showBlog";
        } else {
            return "error";
        }

    }
}
