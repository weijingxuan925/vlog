package com.wjx.controller;

import com.wjx.pojo.Post;
import com.wjx.pojo.User;
import com.wjx.service.PostService;
import com.wjx.service.UserService;
import com.wjx.utils.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

@Controller
@RequestMapping("/user")
public class CreativeRoomController {
    @Autowired
    private ServletContext servletContext;

    @Autowired
    @Qualifier("PostServiceImpl")
    private com.wjx.service.PostService PostService;

    @RequestMapping("/CreativeRoom")
    public String CreativeRoom(){
        return "creativeroom";
    }
    @RequestMapping("/editblog")
    public String EditBlog(){
        return "editblog";

    }
    @RequestMapping("/submitForm")
    public String uploadForm(HttpServletRequest request, @RequestParam("title") String title, @RequestParam("content1") String content1, @RequestParam("cover") MultipartFile cover, Model model) throws IOException, ParseException {
        String fileName = UUID.randomUUID().toString();
        // 获取Web应用程序的根目录
        String rootPath = servletContext.getRealPath("/");
        //保存正文html
        String filePath = rootPath + "post/" + fileName + ".html";
        FileWriter writer = new FileWriter(filePath);
        writer.write(content1);
        writer.close();

        // 保存封面图片
        String coverFilePath = null;
        if (cover != null){
            String coverFileName = fileName + "-" + cover.getOriginalFilename();
            coverFilePath = rootPath + "images/" + File.separator + coverFileName;
            cover.transferTo(new File(coverFilePath));
        }

        //获取现在时间
        Date date = new Date();//获得系统时间.
        SimpleDateFormat sdf =   new SimpleDateFormat( " yyyy-MM-dd HH:mm:ss " );
        String nowTime = sdf.format(date);
        Date time = sdf.parse( nowTime );

        //把文件路径，文章标题，文章所有者，创建时间保存到数据库
        User user = (User) request.getSession().getAttribute(Constants.USER_SESSION);
        String userid = String.valueOf(user.getId());
        Post post = new Post(1,filePath,"已发布","",coverFilePath,title,"0",time,userid);

        PostService.addPost(post);
        return "BlogPublishingSuccess";
    }

}
