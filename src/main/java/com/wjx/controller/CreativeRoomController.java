package com.wjx.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user")
public class CreativeRoomController {
    @RequestMapping("/CreativeRoom")
    public String CreativeRoom(){
        return "creativeroom";
    }
    @RequestMapping("/editblog")
    public String EditBlog(){
        return "editblog";

    }
}
