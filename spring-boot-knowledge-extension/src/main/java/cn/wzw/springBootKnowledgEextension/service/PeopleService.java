package cn.wzw.springBootKnowledgEextension.service;

import cn.wzw.springBootKnowledgEextension.dao.PeopleMapper;
import cn.wzw.springBootKnowledgEextension.dao.UserMapper;
import cn.wzw.springBootKnowledgEextension.pojo.People;
import cn.wzw.springBootKnowledgEextension.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
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
}
