package com.ningyuanlong.Controller;

import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.core.JsonParser;
import com.ningyuanlong.domain.Student;
import com.ningyuanlong.domain.User;
import com.ningyuanlong.service.StudentService;
import com.ningyuanlong.service.UserService;
import org.json.JSONArray;
import org.json.JSONException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    private static Logger logger = LoggerFactory.getLogger(HomeController.class);

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
        System.out.println(datas);
        modelMap.addAttribute("datas", datas);
        return "main";
    }

    @GetMapping("/main/getStudent")
    public String getResources(@RequestParam String sID, ModelMap modelMap){
        logger.info("检索成功!");
        this.studentService.getStudent(sID);
        modelMap.addAttribute("datas", this.studentService.getStudent(sID));
        return "redirect:/main";
    }

    @RequestMapping(value = "/addStudent", method = RequestMethod.POST)
    public String addStudent(String sID, String sname, String sex, Date enrolTime, String departmentID, String type, String riskLevel, String location, String memo){
        String valid = "1";
        studentService.CreateStudent(new Student(sID,sname,sex,enrolTime,departmentID,type,riskLevel,location,memo,valid));
        return "redirect:/main";
    }

    @InitBinder
    public void initBinder(WebDataBinder binder) {//webDataBinder是用于表单到方法的数据绑定的！
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        dateFormat.setLenient(false);
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
    }

    @RequestMapping(value = "/toEdit", method = RequestMethod.POST)
    public String toEdit(@RequestBody String request, Model model,Long id,HttpSession session) throws JSONException {
        System.out.println("获取到信息：" + request);
//        JSONArray jsonArray = new JSONArray(request);
        Student student = JSONObject.parseObject(request, Student.class);
//        System.out.println("student"+student);
//        JSONObject jsonObj = new JSONObject(request);
//        System.out.println(jsonArray);
        Student student1=studentService.findStudentById(student.getId());
        System.out.println("获取到的数据id："+student.getId());
        System.out.println(student1.getsID());
        model.addAttribute("student", student1);
        return "main";
    }

    @RequestMapping(value = "/editStudent", method = RequestMethod.POST)
    public String edit(@RequestBody String request, Model model,Long id, HttpSession session,Student student) throws JSONException {
        System.out.println("获取到信息：" + request);
        Student s = JSONObject.parseObject(request, Student.class);
        student = studentService.findStudentById(s.getId());
        System.out.println("获取到的数据："+student);
        model.addAttribute("student", student);

        studentService.edit(student);
        return "redirect:/main";
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public String delete(@RequestBody String request, Model model,Long id, HttpSession session,Student student) throws JSONException {
        System.out.println("获取到信息：" + request);
        Student s = JSONObject.parseObject(request, Student.class);
        student = studentService.findStudentById(s.getId());
        System.out.println("获取到的数据："+student);
        student.setValid("0");

//        model.addAttribute("student", student);

        studentService.save(student);
        return "redirect:/main";
    }




//    @RequestMapping(value = "/editStudent", method = RequestMethod.POST)
//    public String edit(Student student) {
//        studentService.edit(student);
//        return "redirect:/main";
//    }

//    //用来定义一个保存输出的变量
//    private Map<String, Object> params= new HashMap<>();
//
//    @CrossOrigin
//    @RequestMapping(value = "/v1", method = RequestMethod.POST)
//    public Object login(String id,String pwd) {
//        params.clear();
//        params.put("id", id);
//        params.put("pwd", pwd);
//        return params;
//    }

}
