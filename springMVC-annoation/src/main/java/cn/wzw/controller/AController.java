package cn.wzw.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @Author Wangzhiwen
 * @ClassName AController
 * @Description
 * @Date 2019/5/28 16:52
 * @Version 1.0
 */
@Controller
public class AController {

    @RequestMapping(value = "/succ",method = RequestMethod.GET)
    public String a(){
        return "succ";
    }
}
