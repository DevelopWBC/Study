package springbootcase.demo.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import springbootcase.demo.manager.UserCacheManager;
import springbootcase.demo.pojo.data.test2.User;
import springbootcase.demo.pojo.data.test3.Person;
import springbootcase.demo.pojo.vo.ResponseResult;
import springbootcase.demo.service.TestService;
import springbootcase.demo.util.ResponseUtil;

import java.util.List;
import java.util.concurrent.Callable;

/**
 * @Author Wangzhiwen
 * @ClassName UserController
 * @Description
 * @Date 2019/7/30 11:22
 * @Version 1.0
 */
@RestController
@RequestMapping(value = "/user")
public class UserController {
    private final TestService service;
    private final UserCacheManager userCacheManager;

    @Autowired
    public UserController(TestService service,UserCacheManager userCacheManager)
    {
        this.service = service;
        this.userCacheManager = userCacheManager;
    }

    @GetMapping(value = "/getUser/{id}")
    public User getUser(@PathVariable(name = "id") Integer id){
        return service.getUser(id);
    }

    @GetMapping(value = "/saveUser")
    public ResponseResult saveUser(User user,Person person){
        int i = 10/0;
        service.insertUser(user);
        return ResponseUtil.success();
    }

    @GetMapping(value = "/getPerson/{id}")
    public ResponseResult getPerson(@PathVariable(name = "id") Integer id){
        int i = 10/0;
        List<Person> people = service.listPersons();
        return ResponseUtil.success(people);
    }

    // springmvc异步线程的处理方式一：
    @RequestMapping("/async01")
    public Callable<String> async01(){
        System.out.println("主线程开始..."+Thread.currentThread()+"==>"+System.currentTimeMillis());

        Callable<String> callable = () -> {
            System.out.println("副线程开始..."+Thread.currentThread()+"==>"+System.currentTimeMillis());
            Thread.sleep(300000); // 处理时间过长时，还是会报错org.springframework.web.context.request.async.AsyncRequestTimeoutException
            System.out.println("副线程开始..."+Thread.currentThread()+"==>"+System.currentTimeMillis());
            return "Callable<String> async01()";
        };

        System.out.println("主线程结束..."+Thread.currentThread()+"==>"+System.currentTimeMillis());
        return callable;
    }

    @GetMapping("/user/{id}")
    public ResponseResult user(@PathVariable(value = "id") Integer id){
        User userById = userCacheManager.getUserById(id);
        return ResponseUtil.success(userById);
    }

    @GetMapping("/userRedis/{id}")
    public ResponseResult userByRedis(@PathVariable(value = "id") Integer id){
        User userById = userCacheManager.getUserByRedis(id);
        return ResponseUtil.success(userById);
    }

    @GetMapping(value="/updateUser")
    public ResponseResult updateUser(User user){
        User updateUser = userCacheManager.updateUser(user);
        return ResponseUtil.success(updateUser);
    }

    @GetMapping(value = "/delete/{id}")
    public ResponseResult delete(@PathVariable(value = "id") Integer id){
        userCacheManager.deleteUserById(id);
        return ResponseUtil.success();
    }
}
