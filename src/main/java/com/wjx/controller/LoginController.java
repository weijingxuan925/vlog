package com.wjx.controller;

import com.wjx.pojo.User;
import com.wjx.service.UserService;
import com.wjx.utils.Constants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class LoginController {
    @Autowired
    @Qualifier("UserServiceImpl")
    private UserService userService;

    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public String login(HttpServletRequest request, HttpServletResponse response, Model model){
        //获取传入的用户名和密码
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        User user = userService.queryUserByUsernameAndPassword(username,password);
        //如果有这个人
        if (user != null){
            //把用户信息存入到session
            request.getSession().setAttribute(Constants.USER_SESSION,user);

//            request.setAttribute("username",username);
//            model.addAttribute("username",username);
//            request.setAttribute("username", username);
            //跳转到主页
            System.out.println("登入成功");
            return "redirect:/index.jsp";
        } else {
            System.out.println("登入失败");
            String loginfailed = "登入失败";
            request.setAttribute("loginfailed",loginfailed);
            model.addAttribute("loginfailed",loginfailed);
//            request.getRequestDispatcher("loginerror.jsp").forward(request,response);
            return "redirect:/index.jsp";
        }
    }
    @RequestMapping("/loginout")
    public String  loginout(HttpServletRequest request){
        System.out.println("账号已注销");
        //移除用户的session信息
        request.getSession().removeAttribute(Constants.USER_SESSION);
        //返回主页
        return "redirect:/index.jsp";
    }
}
