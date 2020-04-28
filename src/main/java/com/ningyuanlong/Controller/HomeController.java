package com.ningyuanlong.Controller;

import com.ningyuanlong.domain.Student;
import com.ningyuanlong.domain.User;
import com.ningyuanlong.service.StudentService;
import com.ningyuanlong.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

/**
 * Created by Tony on 2020/4/25
 */
@Controller
@RequestMapping("")
public class HomeController {

    @Autowired
    private UserService userService;

    @Autowired
    private StudentService studentService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String homePage(){
        return "index";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(){
        return "login";
    }

//    @RequestMapping(value = "/register", method = RequestMethod.GET)
//    public String register(){
//        return "register";
//    }

//    @RequestMapping(value = "/main", method = RequestMethod.GET)
//    public String chat(@AuthenticationPrincipal User user, Model model){
////        model.addAttribute("user", user);
////        String username = user.getUsername();
////        user.setUsername(username);
//        return "main";
//    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String Register(String username, String nickname, String password){
        userService.CreateUser(new User(username,nickname,password));
        return "redirect:/login";
    }

    @RequestMapping(value = "/main", method = RequestMethod.GET)
    public String main(HttpSession session, Model model, ModelMap modelMap,
                       @RequestParam(value = "page", defaultValue = "0") Integer page,
                       @RequestParam(value = "size", defaultValue = "6") Integer size){

        Page<Student> datas = studentService.findStudentCriteria(page, size);
        modelMap.addAttribute("datas", datas);
        return "main";
    }

    @RequestMapping(value = "/allot", method = RequestMethod.GET)
    public String roomAllot(){
        return "roomAllot";
    }
}
