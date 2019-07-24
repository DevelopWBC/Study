package cn.wzw.springBootKnowledgEextension.service;

import cn.wzw.springBootKnowledgEextension.dao.PeopleMapper;
import cn.wzw.springBootKnowledgEextension.dao.UserMapper;
import cn.wzw.springBootKnowledgEextension.pojo.Result;
import cn.wzw.springBootKnowledgEextension.pojo.User;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Author Wangzhiwen
 * @ClassName PeopleService
 * @Description
 * @Date 2019/6/3 14:18
 * @Version 1.0
 */
@Service
public class PeopleService {

    private static final Logger LOGGER = LoggerFactory.getLogger(PeopleService.class);
    private final UserMapper userMapper;
    private final PeopleMapper peopleMapper;

    @Autowired
    public PeopleService(UserMapper userMapper,PeopleMapper peopleMapper){
        this.userMapper = userMapper;
        this.peopleMapper = peopleMapper;
    }

    public List<User> findAll(){
        List<User> all = userMapper.findAll();
        return all;
    }

    public List<User> findAllP(){
        List<User> all = peopleMapper.findAll();
        return all;
    }

    @Async(value = "async")
    @Transactional(rollbackFor = Exception.class)
    public void saveOneUser(){
        for (int i=0;i<1000;i++){
            User user = new User();
           user.setAge(i);
           user.setName("wzw"+i);
           userMapper.addPerson(user);
        }
    }

    public Result listUser(int page,int size){
        PageHelper.startPage(page,size); // 设置当前页，每页记录数
        List<User> all = peopleMapper.findAll();
        PageInfo<User> info = new PageInfo<>(all); // 使用PageInfo的构造方法
        Result result = new Result();
        result.setList(info.getList()); // 获取总的记录集合
        result.setTotalPages((int) info.getTotal());
        return result;
    }



    @Async(value = "async")
    public String async() throws InterruptedException {
        int sum = 0;
        LOGGER.info("线程即将休眠");
        Thread.sleep(5000);
        for (int i = 0; i < 8888888; i++) {
            sum += i;
        }
        System.out.println("异步线程。。。。。。。"+sum);
        String msg = "异步线程";
        LOGGER.info("返回结果");
        return msg;
    }
}
