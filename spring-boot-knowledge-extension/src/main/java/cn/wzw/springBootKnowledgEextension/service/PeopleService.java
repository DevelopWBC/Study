package cn.wzw.springBootKnowledgEextension.service;

import cn.wzw.springBootKnowledgEextension.dao.PeopleMapper;
import cn.wzw.springBootKnowledgEextension.dao.UserMapper;
import cn.wzw.springBootKnowledgEextension.pojo.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

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

    @Autowired
    private UserMapper userMapper;
    @Autowired
    private PeopleMapper peopleMapper;


    public List<User> findAll(){
        List<User> all = userMapper.findAll();
        return all;
    }

    public List<User> findAllP(){
        List<User> all = peopleMapper.findAll();
        return all;
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
