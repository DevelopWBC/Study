package cn.wzw.ex.contriller;

import cn.wzw.ex.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

/**
 * @Author Wangzhiwen
 * @ClassName UserController
 * @Description
 * @Date 2019/5/6 8:14
 * @Version 1.0
 */
@Controller
public class UserController {

    @RequestMapping("/{page}")
    public String indexPage(@PathVariable(value = "page") String page){
        return page;
    }

    /**
      *@author Wangzhiwen
      *@description：参数校验，使用@Vaild注解。要求被检验的属性名称为类名称驼峰式小写
      *@date 2019/5/6 10:50
      *@param user：被校验的数据, result：校验后的结果，如果hasErrors为true则代表校验不通过
      *@return void
    */
    @PostMapping(value = "/add")
    public void login(@Valid User user, BindingResult result){
        if (result.hasErrors())
        System.out.println("错误");
    }
}
