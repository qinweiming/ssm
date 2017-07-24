package zizai.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import zizai.model.User;
import zizai.service.UserService;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * Created by Administrator on 2017/4/24.
 */
@Controller
@RequestMapping("/user")
public class UserController {

    private UserService userService;

    @RequestMapping("/showUser")
    public String showUser(HttpServletRequest request, Model model) {
        int userId = Integer.parseInt(request.getParameter("id"));
        User user = this.userService.getUserById(userId);
        model.addAttribute("user", user);
        return "shpwUser";


    }

    @RequestMapping("/table")
    public ModelAndView showTable(HttpServletRequest request) {

        ModelAndView view = new ModelAndView("tables");
        return view;
    }

    @RequestMapping("/index")
    public ModelAndView toIndex(HttpServletRequest request) {
        ModelAndView view = new ModelAndView("login");
        return view;
    }

    @RequestMapping("/login2")
    public ModelAndView login(HttpServletRequest request, Model model) {

        String username = request.getParameter("name");
        String pwd = request.getParameter("pwd");
        User user = this.userService.getUserByName(username);
        String url = "login";
        if (user != null && pwd.equals(user.getPassword())) {
            url = "success"
            ;
        } else {
            url = "fail";
        }
        ModelAndView view = new ModelAndView(url);
        return view;
    }

    @RequestMapping("/register")
    public ModelAndView register(HttpServletRequest request, Model model) {
        String username = request.getParameter("name");
        String pwd = request.getParameter("pwd");
        User user = new User();
        user.setUsername(username);
        user.setPassword(pwd);
        int i=this.userService.addUser(user);
        String  url="register";
        if (username!=null||pwd!=null){
            if (i>0){
                url="login";

            }else {
                url="fail";

            }
        }
        ModelAndView  view  =new ModelAndView(url);
        return   view;
    }
   @RequestMapping("/uppdataUserPwd")
    public   String   updateUserpwd(HttpServletRequest  request,Model  model){
         String  name=request.getParameter("name");
         String   pwd=request.getParameter("pwd");
         String   pwd1=request.getParameter("pwd1");
       if (pwd.equals(pwd)&&pwd1!=null){
             if (true){

             }


       }

   }

}
